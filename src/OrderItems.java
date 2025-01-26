
import java.math.BigDecimal;
import Database.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderItems extends javax.swing.JFrame {

    /**
     * Creates new form OrderItems
     */
    public OrderItems() {
        initComponents();

    }

    // Method to fetch data and display in table
    private void fetchAndDisplayData(String query) {
        DefaultTableModel model = (DefaultTableModel) tableSold.getModel();
        model.setRowCount(0); // Clear existing data

        try (Connection con = ConnectionProvider.getCon(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String productName = rs.getString("productName");
                BigDecimal totalPaid = rs.getBigDecimal("totalPaid");

                // Add data to the table
                model.addRow(new Object[]{productName, totalPaid});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSold = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSold.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Total Paid"
            }
        ));
        tableSold.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tableSoldComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tableSold);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1030, 531));

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FREQUENTLY SOLD PRODUCTS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        btnFilter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFilter.setText("FILTER");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, 100, 30));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 653, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        fetchAndDisplayData("SELECT p.name AS productName, COALESCE(SUM(oi.totalPaid), 0) AS totalPaid "
                + "FROM orderitems oi "
                + "JOIN product p ON oi.product_pk = p.product_pk "
                + "GROUP BY oi.product_pk "
                + "ORDER BY totalPaid DESC");

    }//GEN-LAST:event_btnFilterActionPerformed

    private void tableSoldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tableSoldComponentShown
        fetchAndDisplayData("SELECT p.name AS productName, COALESCE(SUM(od.totalPaid), 0) AS totalPaid "
                + "FROM orderitems oi "
                + "JOIN product p ON oi.product_pk = p.product_pk "
                + "JOIN orderdetails od ON oi.order_pk = od.order_pk "
                + "GROUP BY oi.product_pk "
                + "ORDER BY totalPaid DESC");


    }//GEN-LAST:event_tableSoldComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // Get the table model for the "tableSold" JTable
        DefaultTableModel model = (DefaultTableModel) tableSold.getModel();
        model.setRowCount(0); // Clear existing rows in the table to avoid duplication

        try {
            // Establish a database connection
            Connection con = ConnectionProvider.getCon();

            // Create a statement to execute SQL
            Statement st = con.createStatement();

            // Execute the SQL query to fetch product names and total payments
            ResultSet rs = st.executeQuery(
            "SELECT p.name AS productName, " +
            "COALESCE(SUM(od.totalPaid), 0) AS totalPaid " +
            "FROM product p " +
            "LEFT JOIN orderitems oi ON p.product_pk = oi.product_pk " +
            "LEFT JOIN orderdetails od ON oi.order_pk = od.order_pk " +
            "GROUP BY p.product_pk, p.name " +
            "ORDER BY totalPaid DESC"
        );

            // Loop through the result set and populate the table
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("productName"), // Use the alias "productName"
                    rs.getString("totalPaid") // Use the alias "totalPaid"
                });
            }
        } catch (Exception e) {
            // Display an error message if any exception occurs
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(OrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSold;
    // End of variables declaration//GEN-END:variables
}
