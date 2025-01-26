
import java.awt.Color;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
    }

    public Home(String role) {
        initComponents(); //A method (usually auto-generated in GUI frameworks like Swing) that initializes and sets up the GUI components for the Home window.
        setLocationRelativeTo(null);
        if (role.equals("Admin")) {
            btnUser.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnPos = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 224, 224));
        jPanel1.setPreferredSize(new java.awt.Dimension(6, 6));
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

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUser.setForeground(new java.awt.Color(0, 51, 0));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User.png"))); // NOI18N
        btnUser.setText("User");
        btnUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel2.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 50));

        btnCategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCategory.setForeground(new java.awt.Color(0, 51, 0));
        btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/market-segment.png"))); // NOI18N
        btnCategory.setText("Category");
        btnCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 50));

        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(0, 51, 0));
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/packaging.png"))); // NOI18N
        btnProduct.setText("Product");
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        jPanel2.add(btnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 140, 50));

        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(0, 51, 0));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer.png"))); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        jPanel2.add(btnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 150, 50));

        btnPos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPos.setForeground(new java.awt.Color(0, 51, 0));
        btnPos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/POS2.png"))); // NOI18N
        btnPos.setText("POS");
        btnPos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosActionPerformed(evt);
            }
        });
        jPanel2.add(btnPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 150, 50));

        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(0, 51, 0));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/order.png"))); // NOI18N
        btnOrder.setText("Order");
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jPanel2.add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 150, 50));

        btnView.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnView.setForeground(new java.awt.Color(0, 51, 0));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/view-order.png"))); // NOI18N
        btnView.setText("View-Order");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel2.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 150, 50));

        btnLog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLog.setForeground(new java.awt.Color(0, 51, 0));
        btnLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit (1).png"))); // NOI18N
        btnLog.setText("Log out");
        btnLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel2.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 10, 150, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you want to logout HomePage", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogActionPerformed
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

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        btnUser.setBackground(Color.GRAY);
        btnUser.setForeground(Color.WHITE);

        new ManageUser().setVisible(true);
        // Reset the button's colors after 1 second
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnUser.setBackground(Color.WHITE); // Reset to default background
            btnUser.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
        btnCategory.setBackground(Color.GRAY);
        btnCategory.setForeground(Color.WHITE);
        new ManageCateory().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnCategory.setBackground(Color.WHITE); // Reset to default background
            btnCategory.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
        btnProduct.setBackground(Color.GRAY);
        btnProduct.setForeground(Color.WHITE);
        new ManageProduct().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnProduct.setBackground(Color.WHITE); // Reset to default background
            btnProduct.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer

    }//GEN-LAST:event_btnProductActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        btnCustomer.setBackground(Color.GRAY);
        btnCustomer.setForeground(Color.WHITE);
        new ManageCustomer().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnCustomer.setBackground(Color.WHITE); // Reset to default background
            btnCustomer.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:
        btnOrder.setBackground(Color.GRAY);
        btnOrder.setForeground(Color.WHITE);
        new ManageOrder().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnOrder.setBackground(Color.WHITE); // Reset to default background
            btnOrder.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        btnView.setBackground(Color.GRAY);
        btnView.setForeground(Color.WHITE);
        new viewOrders().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnView.setBackground(Color.WHITE); // Reset to default background
            btnView.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosActionPerformed
        // TODO add your handling code here:
        btnPos.setBackground(Color.GRAY);
        btnPos.setForeground(Color.WHITE);
        new POS().setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            btnPos.setBackground(Color.WHITE); // Reset to default background
            btnPos.setForeground(Color.BLACK); // Reset to default font color
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start(); // Start the timer

    }//GEN-LAST:event_btnPosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPos;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
