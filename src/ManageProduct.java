
import Database.ConnectionProvider;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageProduct extends javax.swing.JFrame {

    private int productPK = 0;
    private int totalQuantity = 0;

    public ManageProduct() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private static final int ORDERING_COST = 10000; // Example: ₦10000 per order
    private static final int HOLDING_COST = 50;   // Example: ₦50 per unit per year

    private int getAnnualDemand(int productId) {
        int annualDemand = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            // Query to calculate total demand for the last 365 days
            String query = "SELECT SUM(quantity) AS totalDemand "
                    + "FROM orderdetails "
                    + "WHERE product_fk = ? AND STR_TO_DATE(orderDate, '%d-%m-%Y') >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)";
            ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();

            if (rs.next()) {
                annualDemand = rs.getInt("totalDemand");
            }
            System.out.println("Annual Demand for Product ID " + productId + ": " + annualDemand);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching annual demand: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
        return annualDemand;
    }

    private double calculateSafetyStock(double averageDemand, double demandStdDev, double leadTime, double leadTimeStdDev, double zValue) {
        return zValue * Math.sqrt((Math.pow(demandStdDev, 2) * leadTime) + (Math.pow(leadTimeStdDev, 2) * Math.pow(averageDemand, 2)));
    }

//    private double calculateReorderLevel(double averageDemand, double leadTime, double safetyStock) {
//        return (averageDemand * leadTime) + safetyStock;
//    }
    private double calculateReorderLevel(double averageDemand, double leadTime, double safetyStock) {
        double reorderLevel = (averageDemand * leadTime) + safetyStock;

        // Log intermediate values
        System.out.println("Average Demand: " + averageDemand + ", Lead Time: " + leadTime + ", Safety Stock: " + safetyStock);
        System.out.println("Reorder Level: " + reorderLevel);

        return reorderLevel;
    }

    private int calculateEOQ(int annualDemand, int orderingCost, int holdingCost) {
        return (int) Math.sqrt((2 * annualDemand * orderingCost) / (double) holdingCost);
    }

    private double getCurrentStock(int productId) {
        double stock = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            ps = con.prepareStatement("SELECT quantity FROM product WHERE product_pk = ?");
            ps.setInt(1, productId);

            rs = ps.executeQuery();
            if (rs.next()) {
                stock = rs.getDouble("quantity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching current stock: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
        return stock;
    }

    private double getAverageDailyDemand(int productId) {
        double totalDemand = 0;
        int days = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            ps = con.prepareStatement(
                    "SELECT SUM(quantity) AS totalDemand, COUNT(DISTINCT orderDate) AS days "
                    + "FROM orderdetails WHERE product_fk = ? GROUP BY product_fk");
            ps.setInt(1, productId);

            rs = ps.executeQuery();
            if (rs.next()) {
                totalDemand = rs.getDouble("totalDemand");
                days = rs.getInt("days");
            }

            // Log intermediate values
            System.out.println("Total Demand: " + totalDemand + ", Days: " + days);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error calculating average demand: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }

        return (days > 0) ? totalDemand / days : 0; // Avoid division by zero
    }

    private double getDemandStandardDeviation(int productId) {
        double meanDemand = getAverageDailyDemand(productId);
        double sumSquaredDifferences = 0;
        int days = 0;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            ps = con.prepareStatement(
                    "SELECT orderDate, SUM(quantity) AS dailyDemand "
                    + "FROM orderdetails WHERE product_fk = ? GROUP BY orderDate");
            ps.setInt(1, productId);

            rs = ps.executeQuery();
            while (rs.next()) {
                double dailyDemand = rs.getDouble("dailyDemand");
                double cap = meanDemand * 1.5; // Cap extreme differences at 1.5 times mean demand
                if (Math.abs(dailyDemand - meanDemand) > cap) {
                    // Limit extreme deviations in daily demand to prevent skewing
                    dailyDemand = meanDemand + (dailyDemand > meanDemand ? cap : -cap);
                }
                sumSquaredDifferences += Math.pow(dailyDemand - meanDemand, 2);
                days++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error calculating demand standard deviation: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }

        // Handle cases with only 1 day of data
        if (days <= 1) {
            return 0.1 * meanDemand; // Default to 10% of mean demand
        }

        // Return standard deviation formula
        return Math.sqrt(sumSquaredDifferences / (days - 1));
    }

    private void continuousStockCheck(int productId, double leadTime, double zValue) {
        double averageDemand = getAverageDailyDemand(productId);
        double demandStdDev = getDemandStandardDeviation(productId);
        //double leadTimeStdDev = 1; // Default variability in lead time
        double leadTimeStdDev = leadTime * 0.1; // Assume 10% variability in lead time

        double currentStock = getCurrentStock(productId);

        // Skip products with no average demand
        if (averageDemand == 0) {
            System.out.println("Skipping calculations for Product ID: " + productId + " (No demand)");
            return;
        }

        // Calculate Safety Stock
        double safetyStock = calculateSafetyStock(averageDemand, demandStdDev, leadTime, leadTimeStdDev, zValue);

        // Calculate Reorder Level
        double reorderLevel = calculateReorderLevel(averageDemand, leadTime, safetyStock);

        // Get dynamic annual demand
        int annualDemand = getAnnualDemand(productId);

        if (annualDemand == 0) {
            System.out.println("No annual demand for Product ID: " + productId);
            return;
        }

        // Calculate EOQ
        int eoq = calculateEOQ(annualDemand, ORDERING_COST, HOLDING_COST);
        double requiredQuantity = reorderLevel - currentStock;

        int orderQuantity = (eoq >= requiredQuantity) ? eoq : (int) Math.ceil(requiredQuantity);
        double updatedStock = currentStock + orderQuantity;

        if (updatedStock < reorderLevel) {
            orderQuantity += (int) Math.ceil(reorderLevel - updatedStock);
            updatedStock = currentStock + orderQuantity;
        }

        System.out.println("Product ID: " + productId);
        System.out.println("Average Demand: " + averageDemand + ", Demand Std Dev: " + demandStdDev);
        System.out.println("Safety Stock: " + safetyStock + ", Reorder Level: " + reorderLevel);
        System.out.println("EOQ: " + eoq);
        System.out.println("Updated Stock: " + updatedStock);

        if (updatedStock >= reorderLevel) {
            JOptionPane.showMessageDialog(null, "Stock level is sufficient for Product ID " + productId);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Stock is still low after the update!"
                    + "\nReorder Level: " + reorderLevel
                    + "\nUpdated Stock: " + updatedStock
                    + "\nSuggested EOQ: " + eoq);
        }
//        // Log intermediate values
//        System.out.println("Product ID: " + productId);
//        System.out.println("Average Demand: " + averageDemand + ", Demand Std Dev: " + demandStdDev);
//        System.out.println("Safety Stock: " + safetyStock + ", Reorder Level: " + reorderLevel);
//        System.out.println("EOQ: " + eoq);
//
//        // Trigger reorder notification if stock is below reorder level
//        if (currentStock <= reorderLevel) {
//            JOptionPane.showMessageDialog(null,
//                    "Stock for Product ID " + productId + " is low!"
//                    + "\nReorder Level: " + reorderLevel
//                    + "\nSafety Stock: " + safetyStock
//                    + "\nSuggested Order Quantity (EOQ): " + eoq);
//        }
    }

    private void getAllCategory() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM category");

            comboBoxCategory.removeAllItems(); // Clear existing items
            while (rs.next()) {
                comboBoxCategory.addItem(rs.getString("category_pk") + "-" + rs.getString("name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching categories: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }

    private boolean validateFields(String formType) {
        if (formType.equals("edit") && !txtName.getText().equals("") && !txtPrice.getText().equals("") && !txtDescription.getText().equals("")) {
            return false;

        } else if (formType.equals("new") && !txtName.getText().equals("") && !txtPrice.getText().equals("") && !txtDescription.getText().equals("") && !txtQuantity.getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }

    private void searchProducts(String searchText) {
        DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
        model.setRowCount(0); // Clear the table to display search results

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            String query = "SELECT * FROM product INNER JOIN category ON product.category_fk = category.category_pk "
                    + "WHERE product.name LIKE ? OR category.name LIKE ?";
            pst = con.prepareStatement(query);
            pst.setString(1, "%" + searchText + "%");
            pst.setString(2, "%" + searchText + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_pk"), rs.getString("name"), rs.getString("quantity"),
                    rs.getString("price"), rs.getString("description"),
                    rs.getString("category_fk"), rs.getString(9) // Adjust index based on your database structure
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCategory = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jbtnSearch = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MANAGE PRODUCT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 6, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Dsecription", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 79, 650, 604));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 483, 37));

        lblQuantity.setBackground(new java.awt.Color(255, 255, 255));
        lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity");
        jPanel1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 483, 38));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 483, 37));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dsecription");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 100, 38));

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 483, 37));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 78, -1));

        comboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 483, 35));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, -1, 31));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, -1, 31));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 650, -1, 31));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 650, -1, 31));

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, -1, 30));

        jtxtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 390, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getAllCategory();
        DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon(); // Get the connection
            st = con.createStatement(); // Create the statement
            rs = st.executeQuery("SELECT * FROM product INNER JOIN category ON product.category_fk = category.category_pk");

            while (rs.next()) {
                // Add row to the table
                model.addRow(new Object[]{
                    rs.getString("product_pk"),
                    rs.getString("name"),
                    rs.getString("quantity"),
                    rs.getString("price"),
                    rs.getString("description"),
                    rs.getString("category_fk"),
                    rs.getString(9) // Adjust based on the table structure
                });

                // Trigger stock check for each product
                int productId = rs.getInt("product_pk");
                continuousStockCheck(productId, 7, 1.65); // Example: Lead Time = 7 days, Z-Value = 1.65
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            // Properly close resources to avoid memory leaks
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }

        btnUpdate.setEnabled(false);

    }//GEN-LAST:event_formComponentShown

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageProduct().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <= 1.0; i += 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String quantity = txtQuantity.getText();
        String price = txtPrice.getText();
        String description = txtDescription.getText();
        String category = (String) comboBoxCategory.getSelectedItem();
        String categoryid[] = category.split("-", 0);

        // Validate fields
        if (validateFields("new")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            Connection con = null;
            PreparedStatement ps = null;
            try {
                // Establish database connection
                con = ConnectionProvider.getCon();
                ps = con.prepareStatement("INSERT INTO product (name, quantity, price, description, category_fk) VALUES (?,?,?,?,?)");
                ps.setString(1, name);
                ps.setString(2, quantity);
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, categoryid[0]);
                ps.executeUpdate();

                // Show success message
                JOptionPane.showMessageDialog(null, "Product Added Successfully");
                // Trigger stock check for the newly added product
                int productId = getLastInsertedProductId(con); // Implement a helper method to get the last product ID
                continuousStockCheck(productId, 7, 1.65);

                // Refresh UI
                setVisible(false);
                new ManageProduct().setVisible(true);
            } catch (Exception e) {
                // Show error message
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } finally {
                // Ensure resources are closed
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();

        String id = model.getValueAt(index, 0).toString();
        productPK = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);

        String quantity = model.getValueAt(index, 2).toString();
        totalQuantity = 0;
        lblQuantity.setText("Add Quantity");
        totalQuantity = Integer.parseInt(quantity);

        String price = model.getValueAt(index, 3).toString();
        txtPrice.setText(price);

        String description = model.getValueAt(index, 4).toString();
        txtDescription.setText(description);

        comboBoxCategory.removeAllItems();
        String categoryid = model.getValueAt(index, 5).toString();
        String categoryName = model.getValueAt(index, 6).toString();
        comboBoxCategory.addItem(categoryid + "-" + categoryName); // Add the selected product's category as the first item

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM category");
            while (rs.next()) {
                if (Integer.parseInt(categoryid) != rs.getInt(1)) {
                    comboBoxCategory.addItem(rs.getString("category_pk") + "-" + rs.getString("name"));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching categories: " + e.getMessage());
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }

        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);

    }//GEN-LAST:event_tableProductMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String quantity = txtQuantity.getText();
        String price = txtPrice.getText();
        String description = txtDescription.getText();
        String category = (String) comboBoxCategory.getSelectedItem();
        String categoryid[] = category.split("-", 0);

        if (validateFields("edit")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            Connection con = null;
            PreparedStatement psFetch = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Disable auto-commit
                int newQuantity = 0;
                if (!quantity.equals("")) {
                    newQuantity = Integer.parseInt(quantity); // Quantity input by the user
                }

                // Fetch existing stock from the database
                con = ConnectionProvider.getCon();
                psFetch = con.prepareStatement("SELECT quantity FROM product WHERE product_pk = ?");
                psFetch.setInt(1, productPK);
                rs = psFetch.executeQuery();
                int existingQuantity = 0;

                if (rs.next()) {
                    existingQuantity = rs.getInt("quantity");
                }

                // Add existing stock to the new quantity
                totalQuantity = existingQuantity + newQuantity;

                // Update the product in the database
                ps = con.prepareStatement(
                        "UPDATE product SET name=?, quantity=?, price=?, description=?, category_fk=? WHERE product_pk=?");
                ps.setString(1, name);
                ps.setInt(2, totalQuantity); // Updated total quantity
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, categoryid[0]);
                ps.setInt(6, productPK);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Product Updated Successfully");

                double updatedStock = getCurrentStock(productPK);

// Recalculate EOQ, Reorder Level, and Safety Stock
                double averageDemand = getAverageDailyDemand(productPK);
                double demandStdDev = getDemandStandardDeviation(productPK);
                double leadTime = 7; // Example lead time
                double zValue = 1.65; // Service level factor
                double safetyStock = calculateSafetyStock(averageDemand, demandStdDev, leadTime, leadTime * 0.1, zValue);
                double reorderLevel = calculateReorderLevel(averageDemand, leadTime, safetyStock);
                int eoq = calculateEOQ(getAnnualDemand(productPK), ORDERING_COST, HOLDING_COST);

// Debugging logs for better clarity
                System.out.println("Updated Stock: " + updatedStock);
                System.out.println("Reorder Level: " + reorderLevel);
                System.out.println("Safety Stock: " + safetyStock);
                System.out.println("EOQ: " + eoq);

// Trigger alert if updated stock is still below the reorder level
                if (updatedStock < reorderLevel) {
                    double requiredOrder = reorderLevel - updatedStock;
                    JOptionPane.showMessageDialog(null,
                            "Warning: Stock is still low after the update!"
                            + "\nReorder Level: " + reorderLevel
                            + "\nUpdated Stock: " + updatedStock
                            + "\nSuggested Order Quantity (EOQ): " + eoq
                            + "\nAdditional Stock Needed: " + requiredOrder);
                } else {
                    JOptionPane.showMessageDialog(null, "Stock level is now sufficient!");
                    System.out.println("Stock level is sufficient after the update.");
                }

                // Refresh the UI
                setVisible(false);
                new ManageProduct().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } finally {
                // Ensure all resources are closed
                try {

                    if (rs != null) {
                        rs.close();
                    }
                    if (psFetch != null) {
                        psFetch.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
// Helper method to get the last inserted product ID

    private int getLastInsertedProductId(Connection con) {
        int productId = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT LAST_INSERT_ID() AS productId");
            rs = ps.executeQuery();
            if (rs.next()) {
                productId = rs.getInt("productId");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching last inserted product ID: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
        return productId;
    }
    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        String searchText = jtxtSearch.getText().trim();
        searchProducts(searchText); // Perform the search based on user input
    }//GEN-LAST:event_jbtnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
