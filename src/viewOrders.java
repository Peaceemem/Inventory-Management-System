
import Database.ConnectionProvider;
import common.OpenPdf;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class viewOrders extends javax.swing.JFrame {

    /**
     * Creates new form viewOrders
     */
    public viewOrders() {
        initComponents();
        setLocationRelativeTo(null);

    }

    private void loadAllCustomerData() {
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        model.setRowCount(0); // Clear existing rows

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            String query = "SELECT * FROM customer";
            rs = st.executeQuery(query);

            // Add all rows to the table
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("customer_pk"),
                    rs.getString("name"),
                    rs.getString("mobileNumber"),
                    rs.getString("email")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading customer data: " + e.getMessage());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrders = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        jtxtFilter = new javax.swing.JTextField();
        btnAnalzeSpending = new javax.swing.JButton();
        btnAnalzeRevenue = new javax.swing.JButton();
        btnShowRevenueChart = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VIEW ORDERS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 6, 213, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 96, 565, 540));

        tableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Date", "Total Paid"
            }
        ));
        tableOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableOrders);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 96, 565, 540));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 660, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer List");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 67, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Order List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 67, -1, -1));

        btnFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 90, 30));

        jtxtFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtxtFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, 350, 30));

        btnAnalzeSpending.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAnalzeSpending.setText("Analyze Spending");
        btnAnalzeSpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalzeSpendingActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnalzeSpending, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 660, -1, 30));

        btnAnalzeRevenue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAnalzeRevenue.setText("Analyze Revenue");
        btnAnalzeRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalzeRevenueActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnalzeRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 660, -1, 30));

        btnShowRevenueChart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShowRevenueChart.setText("Show Revenue Chart");
        btnShowRevenueChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRevenueChartActionPerformed(evt);
            }
        });
        jPanel1.add(btnShowRevenueChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 660, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM customer");

            // Add rows to the table model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("customer_pk"),
                    rs.getString("name"),
                    rs.getString("mobileNumber"),
                    rs.getString("email")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading customer data: " + e.getMessage());
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

    }//GEN-LAST:event_formComponentShown

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();

        String id = model.getValueAt(index, 0).toString();

        DefaultTableModel orderModel = (DefaultTableModel) tableOrders.getModel();
        orderModel.setRowCount(0); // Clear existing rows in the orders table

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();

            // Use PreparedStatement to avoid SQL injection
            String query = "SELECT * FROM orderDetails WHERE customer_fk = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                orderModel.addRow(new Object[]{
                    rs.getString("orderId"),
                    rs.getString("orderDate"),
                    rs.getString("totalPaid")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading customer orders: " + e.getMessage());
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

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrdersMouseClicked
        // TODO add your handling code here:
        int index = tableOrders.getSelectedRow();
        TableModel model = tableOrders.getModel();
        String orderId = model.getValueAt(index, 0).toString();
        OpenPdf.OpenById(orderId);

    }//GEN-LAST:event_tableOrdersMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
// Get the text entered in the filter text field
        String filterText = jtxtFilter.getText().trim();

        // Check if the filter text is not empty
        if (!filterText.isEmpty()) {
            // Call the method to filter the customer data based on the entered text
            filterCustomerData(filterText);
        } else {
            // If the filter text is empty, load all customer data
            loadAllCustomerData();
        }    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnAnalzeSpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalzeSpendingActionPerformed
        // TODO add your handling code here:
        try {
            // Establish a connection to the database
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            try {
                con = ConnectionProvider.getCon();
                st = con.createStatement();

                // Query to calculate total spending per customer
                String query = "SELECT customer_fk, SUM(totalPaid) AS total_spent FROM orderDetails GROUP BY customer_fk";
                rs = st.executeQuery(query);

                // Create a new JFrame to display the data
                JFrame frame = new JFrame("Customer Spending Analysis");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(600, 400);

                // Create table model and JTable
                DefaultTableModel model = new DefaultTableModel(new String[]{"Customer ID", "Total Spent"}, 0);
                JTable table = new JTable(model);

                // Populate the table model with data from the result set
                while (rs.next()) {
                    String customerId = rs.getString("customer_fk");
                    double totalSpent = rs.getDouble("total_spent");
                    model.addRow(new Object[]{customerId, totalSpent});
                }

                // Add the table to a JScrollPane and add it to the frame
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane);

                // Display the frame
                frame.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error analyzing customer spending: " + e.getMessage());
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnAnalzeSpendingActionPerformed

    private void btnAnalzeRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalzeRevenueActionPerformed

        try {
            // Establish a connection to the database
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            try {
                con = ConnectionProvider.getCon();
                st = con.createStatement();

                // Query to calculate monthly revenue
                String query = "SELECT DATE_FORMAT(STR_TO_DATE(orderDate, '%d-%m-%Y'), '%Y-%m') AS month, "
                        + "SUM(totalPaid) AS monthly_revenue "
                        + "FROM orderDetails "
                        + "WHERE STR_TO_DATE(orderDate, '%d-%m-%Y') IS NOT NULL "
                        + "GROUP BY month";
                rs = st.executeQuery(query);

                // Create JFrame to display results
                JFrame frame = new JFrame("Monthly Revenue Analysis with Stochastic Demand");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(800, 600);
                DefaultTableModel model = new DefaultTableModel(new String[]{"Month", "Base Revenue", "Simulated Revenue"}, 0);
                JTable table = new JTable(model);

                Random random = new Random();
                double stddevFactor = 0.2; // 20% variability

                // Process the result set
                while (rs.next()) {
                    String month = rs.getString("month");
                    double baseRevenue = rs.getDouble("monthly_revenue");

                    // Stochastic demand factors
                    double seasonalMultiplier = switch (month.substring(5)) {
                        case "12", "01", "02" ->
                            1.2; // Festive season boost
                        case "06", "07", "08" ->
                            0.8; // Mid-year slowdown
                        default ->
                            1.0; // Normal months
                    };

                    double priceElasticity = -0.5; // A 1% price increase reduces demand by 0.5%
                    double priceChangePercentage = random.nextDouble() * 0.2 - 0.1; // Random price changes ±10%
                    double priceImpact = 1 + (priceChangePercentage * priceElasticity);

                    double competitorImpact = random.nextBoolean() ? 0.9 : 1.1; // Competitor impact on demand
                    double marketingMultiplier = random.nextBoolean() ? random.nextDouble(1.1, 1.3) : 1.0; // Marketing boost
                    double sentimentScore = random.nextDouble(0.8, 1.2); // Public sentiment impact (-20% to +20%)

                    // Combine all stochastic factors
                    double simulatedRevenue = baseRevenue
                            * seasonalMultiplier
                            * priceImpact
                            * competitorImpact
                            * marketingMultiplier
                            * sentimentScore
                            * (1 + random.nextGaussian() * stddevFactor);

                    // Add data to the table model
                    model.addRow(new Object[]{month, baseRevenue, simulatedRevenue});
                }

                // Add table to JScrollPane and JFrame
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane);
                frame.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error analyzing monthly revenue: " + e.getMessage());
            } finally {
                // Ensure proper resource cleanup
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnAnalzeRevenueActionPerformed

    private void btnShowRevenueChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRevenueChartActionPerformed

        // Create the dataset for the chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Random random = new Random();
        double stddevFactor = 0.2; // 20% variability in simulated demand

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Establish a connection to the database
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            // Fetch monthly revenue data
            String query = "SELECT DATE_FORMAT(STR_TO_DATE(orderDate, '%d-%m-%Y'), '%Y-%m') AS month, "
                    + "SUM(totalPaid) AS monthly_revenue "
                    + "FROM orderDetails "
                    + "WHERE STR_TO_DATE(orderDate, '%d-%m-%Y') IS NOT NULL " // Exclude invalid dates
                    + "GROUP BY month";
            rs = st.executeQuery(query);

            // Populate the dataset with base and simulated revenue data
            while (rs.next()) {
                String month = rs.getString("month");
                double baseRevenue = rs.getDouble("monthly_revenue");

                // Simulate stochastic demand by adding random variability
                double simulatedRevenue = baseRevenue * (1 + random.nextGaussian() * stddevFactor);

                // Add both base and simulated revenue to the dataset
                dataset.addValue(baseRevenue, "Base Revenue", month);
                dataset.addValue(simulatedRevenue, "Simulated Revenue", month);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error fetching data for revenue chart: " + e.getMessage());
            return;
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

// Create the bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Revenue with Stochastic Demand", // Chart title
                "Month", // X-axis label
                "Revenue", // Y-axis label
                dataset // Data
        );

// Customize the chart appearance
        barChart.getCategoryPlot().setBackgroundPaint(Color.WHITE);
        barChart.getCategoryPlot().setRangeGridlinePaint(Color.BLACK);

// Show the chart in a new frame
        ChartPanel chartPanel = new ChartPanel(barChart);
        JFrame chartFrame = new JFrame("Monthly Revenue Chart with Stochastic Demand");
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setContentPane(chartPanel);
        chartFrame.setSize(800, 600); // Adjust the size of the chart window
        chartFrame.setVisible(true);

    }//GEN-LAST:event_btnShowRevenueChartActionPerformed
    int xx, xy;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

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
    private void filterCustomerData(String filterText) {
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        model.setRowCount(0); // Clear existing rows

        // Define the query with placeholders
        String query = "SELECT * FROM customer WHERE name LIKE ? OR email LIKE ?";

        try (Connection con = ConnectionProvider.getCon(); PreparedStatement ps = con.prepareStatement(query)) {

            // Set the filter text to the query parameters (using '%' for partial match)
            String likeFilter = "%" + filterText.trim() + "%";
            ps.setString(1, likeFilter);
            ps.setString(2, likeFilter);

            // Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                // Add filtered rows to the table
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("customer_pk"), // Primary key
                        rs.getString("name"), // Customer name
                        rs.getString("mobileNumber"), // Customer mobile number
                        rs.getString("email") // Customer email
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error filtering customer data: " + e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(viewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalzeRevenue;
    private javax.swing.JButton btnAnalzeSpending;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnShowRevenueChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtxtFilter;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableOrders;
    // End of variables declaration//GEN-END:variables
}
