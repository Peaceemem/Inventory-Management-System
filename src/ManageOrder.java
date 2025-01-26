
import Database.ConnectionProvider;
import Database.InventoryUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;


public class ManageOrder extends javax.swing.JFrame {

    private int customerPK = 0;
    private int productPK = 0;
    private int finalTotalPrice = 0;
    private String orderId = "";

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);

    }

    private void clearProductFields() {
        productPK = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");

    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
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
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));
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
        jLabel1.setText("MANAGE ORDER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CUSTOMER LIST");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 92, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 430, 360));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCT LIST");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 92, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 127, 630, 360));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CART");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1332, 92, -1, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 127, 490, 360));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selected Customer:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 408, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mobile Number");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        txtCustomerMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, 408, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 750, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, 408, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Selected Product:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Product Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, -1, -1));

        txtProductName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 600, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product Price");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, 600, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Product Description");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 690, -1, -1));

        txtProductDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 720, 600, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Order Quantity");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 760, -1, -1));

        txtOrderQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 790, 600, 30));

        btnAddToCart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 840, 140, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Amount #:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 520, 220, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblFinalTotalPrice.setText("00000");
        jPanel1.add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 520, -1, -1));

        btnSaveOrderDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveOrderDetails.setText("Save Order Details");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 590, 460, 40));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 660, 460, 40));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 740, 460, 40));

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 840, 90, 40));

        jtxtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jtxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 840, 340, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();

        model.setRowCount(0); // Clear existing rows in the customer table
        productModel.setRowCount(0); // Clear existing rows in the product table

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            // Fetch customer data
            rs = st.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("customer_pk"), // Customer primary key
                    rs.getString("name"), // Customer name
                    rs.getString("mobileNumber"), // Customer mobile number
                    rs.getString("email") // Customer email
                });
            }
            rs.close(); // Close the ResultSet after customer data retrieval

            // Fetch product data
            rs = st.executeQuery("SELECT * FROM product INNER JOIN category ON product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{
                    rs.getString("product_pk"), // Product primary key
                    rs.getString("name"), // Product name
                    rs.getString("price"), // Product price
                    rs.getString("quantity"), // Product quantity
                    rs.getString("description"), // Product description
                    rs.getString("category_fk"), // Category foreign key
                    rs.getString(9) // Category name or description
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        } finally {
            // Ensure resources are properly closed
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

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();

        String id = model.getValueAt(index, 0).toString();
        customerPK = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);

        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // Check if a customer has been selected first
        if (customerPK == 0) { // Assuming 0 means no customer selected
            JOptionPane.showMessageDialog(null, "Please select a customer first.");
            return; // Prevent further actions
        }

        // Proceed with the product selection
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();

        String id = model.getValueAt(index, 0).toString();
        productPK = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);

        String productDescription = model.getValueAt(index, 4).toString();
        txtProductDescription.setText(productDescription);

    }//GEN-LAST:event_tableProductMouseClicked

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed

        String noOfUnits = txtOrderQuantity.getText();

        if (!noOfUnits.equals("")) {
            String productName = txtProductName.getText();
            String productDescription = txtProductDescription.getText();
            String productPriceStr = txtProductPrice.getText();
            int totalPrice = Integer.parseInt(noOfUnits) * Integer.parseInt(productPriceStr);
            int checkStock = 0;
            boolean productAdded = false; // Flag to check if product was successfully added

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM product WHERE product_pk = " + productPK);
                while (rs.next()) {
                    int availableQuantity = rs.getInt("quantity");
                    int requestedQuantity = Integer.parseInt(noOfUnits);
                    int fixedPrice = rs.getInt("price"); // Base price from the database
                    int enteredPrice = Integer.parseInt(productPriceStr); // User-entered price

                    // Dynamic Pricing Rules
                    int allowedMarkup = (int) (fixedPrice * 0.10); // Allow 10% markup
                    int maxPrice = fixedPrice + allowedMarkup;

                    // Validate user-entered price
                    if (enteredPrice < fixedPrice || enteredPrice > maxPrice) {
                        JOptionPane.showMessageDialog(null, "Invalid price! Price must be between " + fixedPrice + " and " + maxPrice + ".");
                        txtProductPrice.setText(String.valueOf(fixedPrice)); // Reset to fixed price
                        return; // Exit if price is invalid
                    }

                    // Calculate the total price based on entered price
                    totalPrice = enteredPrice * requestedQuantity;

                    // If stock is out
                    if (availableQuantity == 0) {
                        JOptionPane.showMessageDialog(null, "Product is out of stock.");
                        return; // Exit and do not add to cart
                    }

                    int baseDemand = 200; // Increased base demand
                    double priceSensitivity = 0.1; // Reduced price sensitivity
                    double stockImpact = (availableQuantity > 50) ? 1.0 : ((availableQuantity > 10) ? 0.95 : 0.85); // Smoothed stock impact
                    int randomFluctuation = (int) (Math.random() * 20 - 10); // Random factor between -10 and +10

                    double priceImpact = Math.min(priceSensitivity * enteredPrice * stockImpact, 100); // Cap price impact at 100
                    int stochasticDemand = (int) (baseDemand - priceImpact + randomFluctuation);
                    stochasticDemand = Math.max(stochasticDemand, 0); // Ensure demand is non-negative

                    JOptionPane.showMessageDialog(null, "Stochastic demand suggests " + stochasticDemand + " units are likely to sell.");

                    // If stock is insufficient
                    if (availableQuantity < requestedQuantity) {
                        JOptionPane.showMessageDialog(null, "Insufficient stock. Only " + availableQuantity + " units left.");

                        // Stock shortage handling remains unchanged
                        DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                        boolean productFound = false;

                        // Check if the product is already in the cart
                        for (int i = 0; i < tableCart.getRowCount(); i++) {
                            if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPK) {
                                productFound = true;

                                // Option dialog for stock shortage
                                int choice = JOptionPane.showOptionDialog(
                                        null,
                                        "Insufficient stock. Only " + availableQuantity + " units available. Please choose an option",
                                        "Stock Shortage",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null,
                                        new String[]{"Add to Existing Cart", "Replace with Available Quantity"},
                                        "Add to Existing Cart"
                                );

                                if (choice == 0) { // Add to Existing Cart
                                    int existingQuantity = Integer.parseInt(model.getValueAt(i, 2).toString());
                                    int newQuantity = existingQuantity + requestedQuantity;

                                    // Check if the new quantity is within available stock
                                    if (newQuantity <= availableQuantity) {
                                        int updatedTotalPrice = newQuantity * enteredPrice;
                                        model.setValueAt(newQuantity, i, 2); // Update quantity in cart
                                        model.setValueAt(updatedTotalPrice, i, 5); // Update total price in cart

                                        finalTotalPrice = finalTotalPrice - existingQuantity * enteredPrice + updatedTotalPrice;
                                        lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));

                                        JOptionPane.showMessageDialog(null, "Quantity added to cart.");
                                        productAdded = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cannot add more than the available stock.");
                                    }
                                } else if (choice == 1) { // Replace with Available Quantity
                                    int existingQuantity = Integer.parseInt(model.getValueAt(i, 2).toString());
                                    model.setValueAt(availableQuantity, i, 2); // Replace quantity in cart
                                    model.setValueAt(availableQuantity * enteredPrice, i, 5); // Update total price in cart

                                    finalTotalPrice = finalTotalPrice - existingQuantity * enteredPrice + availableQuantity * enteredPrice;
                                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));

                                    JOptionPane.showMessageDialog(null, "Quantity replaced with available stock.");
                                    productAdded = true;
                                }
                                break;
                            }
                        }

                        // If product is not found in cart, add a new row
                        if (!productFound && !productAdded) {
                            model.addRow(new Object[]{productPK, productName, String.valueOf(availableQuantity), enteredPrice, productDescription, availableQuantity * enteredPrice});
                            finalTotalPrice += availableQuantity * enteredPrice;
                            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                            JOptionPane.showMessageDialog(null, "Added to cart with available stock.");
                            productAdded = true;
                        }
                        return; // Exit the method after showing the options or adding to cart
                    }

                    // If stock is sufficient
                    checkStock = 1;
                    if (availableQuantity <= 100) {
                        JOptionPane.showMessageDialog(null, "Warning: Product stock is running low. Only " + availableQuantity + " units left.");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            // Proceed to add product to cart if stock is sufficient
            if (checkStock == 1 && !productAdded) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                boolean productFound = false;

                // Check if product is already in the cart and update the quantity if found
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productPK) {
                        int existingQuantity = Integer.parseInt(model.getValueAt(i, 2).toString());
                        int newQuantity = existingQuantity + Integer.parseInt(noOfUnits);
                        int updatedTotalPrice = newQuantity * Integer.parseInt(productPriceStr);

                        model.setValueAt(newQuantity, i, 2); // Update quantity in cart
                        model.setValueAt(updatedTotalPrice, i, 5); // Update total price in cart

                        finalTotalPrice = finalTotalPrice - existingQuantity * Integer.parseInt(productPriceStr) + updatedTotalPrice;
                        lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));

                        JOptionPane.showMessageDialog(null, "Quantity updated successfully.");
                        productFound = true;
                        break;
                    }
                }

                // If product was not found in the cart, add it as a new row
                if (!productFound) {
                    model.addRow(new Object[]{productPK, productName, noOfUnits, productPriceStr, productDescription, totalPrice});
                    finalTotalPrice += totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added to cart.");
                }

                clearProductFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Quantity and Product fields are required.");
        }


    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {

            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tableCartMouseClicked

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        // TODO add your handling code here:
        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();

                        // Update product quantity in the product table
                        st.executeUpdate("UPDATE product SET quantity = quantity - "
                                + Integer.parseInt(dtm.getValueAt(i, 2).toString()) // Quantity from the cart
                                + " WHERE product_pk = "
                                + Integer.parseInt(dtm.getValueAt(i, 0).toString())); // Product PK from the cart

                        // Insert order details into orderDetails table
                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO orderDetails (orderId, customer_fk, orderDate, totalPaid, product_fk, quantity) VALUES (?, ?, ?, ?, ?, ?)");
                        ps.setString(1, orderId); // Order ID
                        ps.setInt(2, customerPK); // Customer PK
                        ps.setString(3, new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime())); // Order Date
                        ps.setInt(4, Integer.parseInt(dtm.getValueAt(i, 5).toString())); // Subtotal Price
                        ps.setInt(5, Integer.parseInt(dtm.getValueAt(i, 0).toString())); // Product PK
                        ps.setInt(6, Integer.parseInt(dtm.getValueAt(i, 2).toString())); // Product PK

                        ps.executeUpdate();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            // Generate the bill (PDF logic remains unchanged)
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(InventoryUtils.billPath + "" + orderId + ".pdf"));
                doc.open();

                Paragraph projectName = new Paragraph("                                                        Inventory Management System\n");
                doc.add(projectName);
                Paragraph startLine = new Paragraph("****************************************************************************************************************");
                doc.add(startLine);
                Paragraph details = new Paragraph("\torder ID:" + orderId + "\nDate:" + new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()) + "\nTotal Paid:" + finalTotalPrice);
                doc.add(details);
                doc.add(startLine);

                PdfPTable tb1 = new PdfPTable(5);
                PdfPCell nameCell = new PdfPCell(new Phrase("Name"));
                PdfPCell descriptionCell = new PdfPCell(new Phrase("Description"));
                PdfPCell priceCell = new PdfPCell(new Phrase("Price Per Unit"));
                PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalPriceCell = new PdfPCell(new Phrase("Sub Total Price"));

                BaseColor backgroundColor = new BaseColor(255, 204, 51);
                nameCell.setBackgroundColor(backgroundColor);
                descriptionCell.setBackgroundColor(backgroundColor);
                priceCell.setBackgroundColor(backgroundColor);
                quantityCell.setBackgroundColor(backgroundColor);
                subTotalPriceCell.setBackgroundColor(backgroundColor);

                tb1.addCell(nameCell);
                tb1.addCell(descriptionCell);
                tb1.addCell(priceCell);
                tb1.addCell(quantityCell);
                tb1.addCell(subTotalPriceCell);

                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    tb1.addCell(tableCart.getValueAt(i, 1).toString());
                    tb1.addCell(tableCart.getValueAt(i, 4).toString());
                    tb1.addCell(tableCart.getValueAt(i, 3).toString());
                    tb1.addCell(tableCart.getValueAt(i, 2).toString());
                    tb1.addCell(tableCart.getValueAt(i, 5).toString());
                }

                doc.add(tb1);
                doc.add(startLine);
                Paragraph thanksMsg = new Paragraph("Thank you, Please visit again.");
                doc.add(thanksMsg);
                OpenPdf.OpenById(orderId);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please add some product to Cart or select Customer");
        }


    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed
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

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        String searchText = jtxtSearch.getText().trim();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();

// Clear current rows
        productModel.setRowCount(0);

// Define the query
        String query = "SELECT product.product_pk, product.name, product.price, product.quantity, "
                + "product.description, product.category_fk, category.name AS category_name "
                + "FROM product "
                + "INNER JOIN category ON product.category_fk = category.category_pk "
                + "WHERE product.name LIKE ? OR category.name LIKE ?";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Establish connection
            con = ConnectionProvider.getCon();
            pst = con.prepareStatement(query);

            // Set query parameters
            pst.setString(1, "%" + searchText + "%");
            pst.setString(2, "%" + searchText + "%");

            // Execute the query
            rs = pst.executeQuery();
            while (rs.next()) {
                productModel.addRow(new Object[]{
                    rs.getString("product_pk"),
                    rs.getString("name"),
                    rs.getString("price"),
                    rs.getString("quantity"),
                    rs.getString("description"),
                    rs.getString("category_fk"),
                    rs.getString("category_name")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
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
                JOptionPane.showMessageDialog(null, "Error closing database resources: " + e.getMessage());
            }
        }


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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
