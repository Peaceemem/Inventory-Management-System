
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class POS extends javax.swing.JFrame {

    /**
     * Creates new form POS
     */
    public POS() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtn7 = new javax.swing.JButton();
        jbtn8 = new javax.swing.JButton();
        jbtn4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jbtn5 = new javax.swing.JButton();
        jbtn6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jbtn1 = new javax.swing.JButton();
        jbtn2 = new javax.swing.JButton();
        jbtn3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jbtn0 = new javax.swing.JButton();
        jbtnDot = new javax.swing.JButton();
        jbtnC = new javax.swing.JButton();
        jbtn9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbtnHotChocolate = new javax.swing.JButton();
        jbtnCoffee = new javax.swing.JButton();
        jbtnDonut = new javax.swing.JButton();
        jbtnChocolateCake = new javax.swing.JButton();
        jbtnBurger = new javax.swing.JButton();
        jbtnFrenchSandWich = new javax.swing.JButton();
        jbtnEggRoll = new javax.swing.JButton();
        jbtnBreadCake = new javax.swing.JButton();
        jbtnCoke = new javax.swing.JButton();
        jbtnIceCream = new javax.swing.JButton();
        jbtnCappuccino = new javax.swing.JButton();
        jbtnMineral = new javax.swing.JButton();
        jbtnNoodles = new javax.swing.JButton();
        jbtnRainBowCake = new javax.swing.JButton();
        jbtnGreen = new javax.swing.JButton();
        jbtnFruitCake = new javax.swing.JButton();
        jbtnMeatPie = new javax.swing.JButton();
        jbtnToastBread = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        jtxtSubTotal = new javax.swing.JTextField();
        jtxtTax = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jbtnRemove = new javax.swing.JButton();
        jbtnPay = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jbtnClose = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtChange = new javax.swing.JTextField();
        jtxtDisplay = new javax.swing.JTextField();
        jCboPayment = new javax.swing.JComboBox<>();
        jtxtCard = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtBarCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtn7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn7.setText("7");
        jbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn7ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 90));

        jbtn8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn8.setText("8");
        jbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, 90));

        jbtn4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn4.setText("4");
        jbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn4ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 90));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 770, 480));

        jbtn5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn5.setText("5");
        jbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn5ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 80, 90));

        jbtn6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn6.setText("6");
        jbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn6ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 80, 90));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setText("Close");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 770, 480));

        jbtn1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn1.setText("1");
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, 90));

        jbtn2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn2.setText("2");
        jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 80, 90));

        jbtn3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn3.setText("3");
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 80, 90));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton13.setText("Close");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 770, 480));

        jbtn0.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn0.setText("0");
        jbtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn0ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 80, 90));

        jbtnDot.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtnDot.setText(".");
        jbtnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDotActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 80, 90));

        jbtnC.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtnC.setText("C");
        jbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 80, 90));

        jbtn9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jbtn9.setText("9");
        jbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn9ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 290, 480));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnHotChocolate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnHotChocolate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chocolate.jpg"))); // NOI18N
        jbtnHotChocolate.setText("Burger");
        jbtnHotChocolate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHotChocolateActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnHotChocolate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 150, 170));

        jbtnCoffee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCoffee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Blend dark.jpg"))); // NOI18N
        jbtnCoffee.setText("Burger");
        jbtnCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCoffeeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCoffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 170));

        jbtnDonut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnDonut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/donut 2.jpg"))); // NOI18N
        jbtnDonut.setText("Burger");
        jbtnDonut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDonutActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnDonut, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 150, 170));

        jbtnChocolateCake.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnChocolateCake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cakec.jpg"))); // NOI18N
        jbtnChocolateCake.setText("Burger");
        jbtnChocolateCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChocolateCakeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnChocolateCake, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 150, 170));

        jbtnBurger.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnBurger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/burger.jpg"))); // NOI18N
        jbtnBurger.setText("Burger");
        jbtnBurger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBurgerActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBurger, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 150, 170));

        jbtnFrenchSandWich.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnFrenchSandWich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/french.jpeg"))); // NOI18N
        jbtnFrenchSandWich.setText("Burger");
        jbtnFrenchSandWich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFrenchSandWichActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnFrenchSandWich, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 150, 170));

        jbtnEggRoll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnEggRoll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/egg 2.jpeg"))); // NOI18N
        jbtnEggRoll.setText("Burger");
        jbtnEggRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEggRollActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnEggRoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 150, 160));

        jbtnBreadCake.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnBreadCake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fruit.jpg"))); // NOI18N
        jbtnBreadCake.setText("Burger");
        jbtnBreadCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBreadCakeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBreadCake, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, 160));

        jbtnCoke.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCoke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coke.jpg"))); // NOI18N
        jbtnCoke.setText("Burger");
        jbtnCoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCokeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 150, 160));

        jbtnIceCream.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnIceCream.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ice cream.jpg"))); // NOI18N
        jbtnIceCream.setText("Burger");
        jbtnIceCream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIceCreamActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnIceCream, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 150, 160));

        jbtnCappuccino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnCappuccino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/busra-salkim-bQ3Itez0vvI-unsplash.jpg"))); // NOI18N
        jbtnCappuccino.setText("Burger");
        jbtnCappuccino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCappuccinoActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCappuccino, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 150, 160));

        jbtnMineral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnMineral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mineral.jpg"))); // NOI18N
        jbtnMineral.setText("Burger");
        jbtnMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMineralActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 150, 160));

        jbtnNoodles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnNoodles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noodles.jpg"))); // NOI18N
        jbtnNoodles.setText("Burger");
        jbtnNoodles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNoodlesActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnNoodles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 150, 160));

        jbtnRainBowCake.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnRainBowCake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rainbow.jpg"))); // NOI18N
        jbtnRainBowCake.setText("Burger");
        jbtnRainBowCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRainBowCakeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnRainBowCake, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 150, 160));

        jbtnGreen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/green.jpg"))); // NOI18N
        jbtnGreen.setText("Burger");
        jbtnGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGreenActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnGreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 150, 160));

        jbtnFruitCake.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnFruitCake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/strawberry.jpg"))); // NOI18N
        jbtnFruitCake.setText("Burger");
        jbtnFruitCake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFruitCakeActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnFruitCake, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 150, 160));

        jbtnMeatPie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnMeatPie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meet.jpeg"))); // NOI18N
        jbtnMeatPie.setText("Burger");
        jbtnMeatPie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMeatPieActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnMeatPie, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 150, 160));

        jbtnToastBread.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnToastBread.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/high-angle-tasty-toast-arrangement (1).jpg"))); // NOI18N
        jbtnToastBread.setText("Burger");
        jbtnToastBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnToastBreadActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnToastBread, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 150, 160));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 12, 920, 530));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Items", "Quantity", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 370, 470));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 7, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Sub Total");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Sub Total");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Tax");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Total");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jtxtTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel8.add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 300, 40));

        jtxtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel8.add(jtxtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 22, 300, 40));

        jtxtTax.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel8.add(jtxtTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 300, 40));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 210));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnRemove.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnRemove.setText("Remove");
        jbtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 220, 50));

        jbtnPay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnPay.setText("Pay");
        jbtnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPayActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 50));

        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnReset.setText("Reset");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 220, 50));

        jbtnPrint.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnPrint.setText("Print");
        jbtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 50));

        jbtnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnClose.setText("Close");
        jbtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCloseActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 450, 50));

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 480, 210));

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Change");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Cash");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Payment Method");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtxtChange.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtxtChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtChangeActionPerformed(evt);
            }
        });
        jPanel11.add(jtxtChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 250, 40));

        jtxtDisplay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtxtDisplay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtDisplayFocusGained(evt);
            }
        });
        jPanel11.add(jtxtDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 250, 40));

        jCboPayment.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jCboPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Cash + Visa", "Visa Card", "Master Card" }));
        jPanel11.add(jCboPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 22, 250, 40));

        jtxtCard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtxtCard.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtCardFocusGained(evt);
            }
        });
        jtxtCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCardActionPerformed(evt);
            }
        });
        jPanel11.add(jtxtCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 250, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Card");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 500, 210));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1590, 250));

        jtxtBarCode.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(jtxtBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 482, 370, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void ItemCost() {
        double sum = 0;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            sum = sum + Double.parseDouble(jTable1.getValueAt(i, 2).toString());
        }
        jtxtSubTotal.setText(Double.toString(sum));
        double cTotal1 = Double.parseDouble(jtxtSubTotal.getText());

        double cTax = (cTotal1 * 0.5) / 100;
        String iTaxTotal = String.format("# %.2f", cTax);
        jtxtTax.setText(iTaxTotal);

        String iSubTotal = String.format("# %.2f", cTotal1);
        jtxtSubTotal.setText(iSubTotal);

        String iTotal = String.format("# %.2f", cTotal1 + cTax);
        jtxtTotal.setText(iTotal);

        String BarCode = String.format("Total is %.2f", cTotal1 + cTax);
        jtxtBarCode.setText(BarCode);
    }

    //**********************************Fuction Change*************************************
    public void Change(double cashAmount, double cardAmount) {
        try {
            double sum = 0;

            // Sum up the total price from the table
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                sum += Double.parseDouble(jTable1.getValueAt(i, 2).toString());
            }

            // Calculate tax
            double cTax = (sum * 0.5) / 100;
            double totalCost = sum + cTax;

            // Calculate total payment (cash + card)
            double totalPayment = cashAmount + cardAmount;

            // Calculate the change
            double cChange = totalPayment - totalCost;

            // Display the change if the payment is sufficient
            if (cChange >= 0) {
                String ChangeGiven = String.format("# %.2f", cChange);
                jtxtChange.setText(ChangeGiven);
            } else {
                // If the payment is insufficient, show an error message
                JOptionPane.showMessageDialog(this, "Insufficient payment. Please ensure the total amount covers the cost.",
                        "Payment Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Display an error dialog if any number format error occurs
            JOptionPane.showMessageDialog(this, "Invalid input: Please enter valid numbers in the cash or card fields.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jbtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);

    }//GEN-LAST:event_jbtnCloseActionPerformed

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn7.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn7.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
     }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn8.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn8.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn4.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn4.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn5.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn5.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn6.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn6.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn1.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn1.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn2.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn2.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn3.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn3.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jbtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn0ActionPerformed
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn0.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn0.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn0ActionPerformed

    private void jbtnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDotActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            // Ensure that the active text field does not already contain a dot
            if (!activeTextField.getText().contains(".")) {
                activeTextField.setText(activeTextField.getText() + jbtnDot.getText());
            }
        }
    }//GEN-LAST:event_jbtnDotActionPerformed

    private void jbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCActionPerformed
        // TODO add your handling code here:
        jtxtDisplay.setText("");
        jtxtCard.setText("");
        jtxtChange.setText("");
    }//GEN-LAST:event_jbtnCActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed
        // TODO add your handling code here:
        if (activeTextField != null) {
            String EnterNumer = activeTextField.getText(); // Get text from the active field

            if (EnterNumer.equals("")) {
                activeTextField.setText(jbtn9.getText()); // Set the text to the pressed number
            } else {
                EnterNumer = EnterNumer + jbtn9.getText(); // Append the pressed number
                activeTextField.setText(EnterNumer); // Update the active text field
            }
        }
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void jbtnHotChocolateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHotChocolateActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 1000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Fruit HotChocolate", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnHotChocolateActionPerformed

    private void jbtnCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCoffeeActionPerformed
        // TODO add your handling code here:

        double priceOfItem = 1000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Coffee", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnCoffeeActionPerformed

    private void jbtnDonutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDonutActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 800.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Donut", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnDonutActionPerformed

    private void jbtnChocolateCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChocolateCakeActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 10000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Chocolate cake", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnChocolateCakeActionPerformed

    private void jbtnBurgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBurgerActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 2500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Burger", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnBurgerActionPerformed

    private void jbtnFrenchSandWichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFrenchSandWichActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 2500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"French SandWich", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnFrenchSandWichActionPerformed

    private void jbtnEggRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEggRollActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Egg Roll", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnEggRollActionPerformed

    private void jbtnBreadCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBreadCakeActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 15000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Bread Cake", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnBreadCakeActionPerformed

    private void jbtnCokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCokeActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 700.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Coca", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnCokeActionPerformed

    private void jbtnIceCreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIceCreamActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 1200.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Ice Cream", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnIceCreamActionPerformed

    private void jbtnCappuccinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCappuccinoActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 1000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Cappuccino", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnCappuccinoActionPerformed

    private void jbtnMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMineralActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 700.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Coca", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnMineralActionPerformed

    private void jbtnNoodlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNoodlesActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 3500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Noodles", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnNoodlesActionPerformed

    private void jbtnRainBowCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRainBowCakeActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 2500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Rainbow Cake", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnRainBowCakeActionPerformed

    private void jbtnGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGreenActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 1000.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"GreenTTea", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnGreenActionPerformed

    private void jbtnFruitCakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFruitCakeActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 1500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Fruit Cake", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnFruitCakeActionPerformed

    private void jbtnMeatPieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMeatPieActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 700.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Meat Pie", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnMeatPieActionPerformed

    private void jbtnToastBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnToastBreadActionPerformed
        // TODO add your handling code here:
        double priceOfItem = 500.0;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"Toast Bread", "1", priceOfItem});
        ItemCost();
    }//GEN-LAST:event_jbtnToastBreadActionPerformed

    private void jtxtChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtChangeActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jtxtChange.setText("");
        jtxtTax.setText("");
        jtxtTotal.setText("");
        jtxtSubTotal.setText("");
        jtxtDisplay.setText("");
        jtxtBarCode.setText("");
        setVisible(false);
        new POS().setVisible(true);
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPayActionPerformed

        double cashAmount = 0;
        double cardAmount = 0;

        try {
            // Check if the user selected Cash + Visa payment method
            if (jCboPayment.getSelectedItem().equals("Cash + Visa")) {
                // Read the amounts entered for cash and card
                cashAmount = Double.parseDouble(jtxtDisplay.getText());
                cardAmount = Double.parseDouble(jtxtCard.getText());
                Change(cashAmount, cardAmount);
            } else if (jCboPayment.getSelectedItem().equals("Cash")) {
                cashAmount = Double.parseDouble(jtxtDisplay.getText());
                Change(cashAmount, 0); // Card amount is 0 for cash-only payments
            } else {
                // Clear the change and display fields for other payment methods
                jtxtChange.setText("");
                jtxtDisplay.setText("");
            }
        } catch (NumberFormatException ex) {
            // Display an error dialog instead of showing it in jtxtChange
            JOptionPane.showMessageDialog(this, "Invalid input: Please enter valid numbers for cash or card amounts.",
                    "Payment Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtnPayActionPerformed

    private void jbtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int RemoveItem = jTable1.getSelectedRow();
        if (RemoveItem >= 0) {
            model.removeRow(RemoveItem);
        }

        ItemCost();

        double cashAmount = 0;
        double cardAmount = 0;

        try {
            // Check if the user selected Cash + Visa payment method
            if (jCboPayment.getSelectedItem().equals("Cash + Visa")) {
                // Read the amounts entered for cash and card
                cashAmount = Double.parseDouble(jtxtDisplay.getText());
                cardAmount = Double.parseDouble(jtxtCard.getText());
                Change(cashAmount, cardAmount);
            } else if (jCboPayment.getSelectedItem().equals("Cash")) {
                cashAmount = Double.parseDouble(jtxtDisplay.getText());
                Change(cashAmount, 0); // Card amount is 0 for cash-only payments
            } else {
                // Clear the change and display fields for other payment methods
                jtxtChange.setText("");
                jtxtDisplay.setText("");
            }
        } catch (NumberFormatException ex) {
            // Display an error dialog instead of showing it in jtxtChange
            JOptionPane.showMessageDialog(this, "Invalid input: Please enter valid numbers for cash or card amounts.",
                    "Payment Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnRemoveActionPerformed

    private void jbtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintActionPerformed
        // TODO add your handling code here:
        String total = jtxtTotal.getText();

        // Adding total to the header or footer
        MessageFormat header = new MessageFormat("Total: " + total + " | Printing in progress");
        MessageFormat footer = new MessageFormat("Total: " + total + " | Page {0, number, integer}");

        try {
            // Print the table with the modified header and footer
            jTable1.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("No Printer found: %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jbtnPrintActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

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

    private void jtxtCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCardActionPerformed
    JTextField activeTextField;
    private void jtxtDisplayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDisplayFocusGained
        // TODO add your handling code here:
        activeTextField = jtxtDisplay; // Set jtxtDisplay as the active field

    }//GEN-LAST:event_jtxtDisplayFocusGained

    private void jtxtCardFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtCardFocusGained
        // TODO add your handling code here:
        activeTextField = jtxtCard; // Set jtxtCard as the active field
    }//GEN-LAST:event_jtxtCardFocusGained

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
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jCboPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtn0;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JButton jbtnBreadCake;
    private javax.swing.JButton jbtnBurger;
    private javax.swing.JButton jbtnC;
    private javax.swing.JButton jbtnCappuccino;
    private javax.swing.JButton jbtnChocolateCake;
    private javax.swing.JButton jbtnClose;
    private javax.swing.JButton jbtnCoffee;
    private javax.swing.JButton jbtnCoke;
    private javax.swing.JButton jbtnDonut;
    private javax.swing.JButton jbtnDot;
    private javax.swing.JButton jbtnEggRoll;
    private javax.swing.JButton jbtnFrenchSandWich;
    private javax.swing.JButton jbtnFruitCake;
    private javax.swing.JButton jbtnGreen;
    private javax.swing.JButton jbtnHotChocolate;
    private javax.swing.JButton jbtnIceCream;
    private javax.swing.JButton jbtnMeatPie;
    private javax.swing.JButton jbtnMineral;
    private javax.swing.JButton jbtnNoodles;
    private javax.swing.JButton jbtnPay;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnRainBowCake;
    private javax.swing.JButton jbtnRemove;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnToastBread;
    private javax.swing.JTextField jtxtBarCode;
    private javax.swing.JTextField jtxtCard;
    private javax.swing.JTextField jtxtChange;
    private javax.swing.JTextField jtxtDisplay;
    private javax.swing.JTextField jtxtSubTotal;
    private javax.swing.JTextField jtxtTax;
    private javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables
}
