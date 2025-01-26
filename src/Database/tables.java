package Database;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PEACE
 */
public class tables {

    public static void main(String args[]) {
        Connection con = null; //Initially set to null until a connection is established.

        Statement st = null;

        try {
            // Establish the database connection
            con = ConnectionProvider.getCon();
            if (con != null) { //Checks if the connection was successfully established before proceeding.
                st = con.createStatement(); //Creates a Statement object, which is used to send SQL queries to the database.
//                CREATE TABLE demandData (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    product_fk INT NOT NULL, -- Foreign key to link to the product table
//    date DATE NOT NULL, -- Date for demand tracking
//    demand INT NOT NULL, -- Recorded demand for the product
//    leadTime DOUBLE NOT NULL, -- Lead time for restocking
//    stddev DOUBLE NOT NULL, -- Standard deviation of demand
//    FOREIGN KEY (product_fk) REFERENCES product(id) -- Ensure referential integrity
//);

                // Corrected CREATE TABLE query
//                String createTableQuery = "CREATE TABLE orderItems ("
//                        + "orderitem_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                        + "order_pk INT NOT NULL, "
//                        + "product_pk INT NOT NULL, "
//                        + "quantity INT NOT NULL, "
//                        + "price DECIMAL(10, 2) NOT NULL, "
//                        + "totalPaid DECIMAL(10, 2) NOT NULL, "
//                        + "FOREIGN KEY (order_pk) REFERENCES orderdetails(order_pk), "
//                        + "FOREIGN KEY (product_pk) REFERENCES product(product_pk))";
                String createTableQuery = "CREATE TABLE demandData ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "product_fk INT NOT NULL, "
                        + "date DATE NOT NULL, "
                        + "demand INT NOT NULL, "
                        + "leadTime DOUBLE NOT NULL, "
                        + "stddev DOUBLE NOT NULL, "
                        + "FOREIGN KEY (product_fk) REFERENCES product(id))";

                // Execute the SQL query
                st.executeUpdate(createTableQuery);
                JOptionPane.showMessageDialog(null, "Table 'orderItems' created successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Database connection failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print full error for debugging
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();  // Close the statement safely
                }
                if (con != null) {
                    con.close();  // Close the connection safely
                }
            } catch (Exception e) {
                e.printStackTrace();  // Catch and print any closing exceptions
            }
        }
    }
}

//package Database;
//
//import java.sql.Connection;
//import java.sql.Statement;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author PEACE
// */
//public class tables {
//
//    public static void main(String args[]) {
//        Connection con = null;
//        Statement st = null;
//
//        try {
//            // Establish the database connection
//            con = ConnectionProvider.getCon();
//            if (con != null) {
//                st = con.createStatement();
//
//                // SQL query to create the 'customer' table with a UNIQUE constraint on the email field
////                String createTableQuery = "CREATE TABLE orderDetails ("
////                        + "order_pk INT AUTO_INCREMENT PRIMARY KEY, "
////                        + "orderId VARCHAR(200), "
////                        + "customer_fk int, "
////                        + "orderDate VARCHAR(200),"
////                        + "totalPaid int)";
////                String createTableQuery = "CREATE TABLE orderDetails ("
////                        + "order_pk INT AUTO_INCREMENT PRIMARY KEY, "
////                        + "orderId VARCHAR(200), "
////                        + "customer_fk INT, "
////                        + "orderDate VARCHAR(200)," // Changed to DATE type for better date management
////                        + "totalPaid INT,"
////                        + "FOREIGN KEY (customer_fk) REFERENCES customer(customer_pk))";
//                String createTableQuery = "CREATE TABLE orderItems ("
//                        + "orderitem_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                        + "order_fk INT, "
//                        + "product_fk INT, "
//                        + "quantity INT, "
//                        + "price INT "
//                        + "totalPaid INT "
//                        + "FOREIGN KEY (order_fk) REFERENCES orderdetails(order_pk), "
//                        + "FOREIGN KEY (product_fk) REFERENCES product(product_pk))";
//
//                // Execute the SQL query
//                st.executeUpdate(createTableQuery);
//                JOptionPane.showMessageDialog(null, "Table created successfully!");
//            } else {
//                JOptionPane.showMessageDialog(null, "Connection failed!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();  // Print full error for debugging
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        } finally {
//            try {
//                if (st != null) {
//                    st.close();  // Close the statement safely
//                }
//                if (con != null) {
//                    con.close();  // Close the connection safely
//                }
//            } catch (Exception e) {
//                e.printStackTrace();  // Catch and print any closing exceptions
//            }
//        }
//    }
//}
//package Database;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author PEACE
// */
//public class tables {
//
//    public static void main(String args[]) {
//        Connection con = null;
//        Statement st = null;
//        PreparedStatement pst = null;
//
//        try {
//            // Establish the database connection
//            con = ConnectionProvider.getCon();
//            if (con != null) {
//                st = con.createStatement();
//
//                // SQL query to create the table
//                // String createTableQuery = "CREATE TABLE appuser ("
//                //         + "appuser_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                //         + "userRole VARCHAR(50), "
//                //         + "name VARCHAR(200), "
//                //         + "mobileNumber VARCHAR(50), "
//                //         + "email VARCHAR(200) UNIQUE, "
//                //         + "password VARCHAR(50), "
//                //         + "address VARCHAR(200), "
//                //         + "status VARCHAR(50))";
//                // Execute the SQL query to create the table
//                // st.executeUpdate(createTableQuery);
//                //JOptionPane.showMessageDialog(null, "Table creation code is commented out.");
//
//                // SQL query to insert values into the table
//                String insertQuery = "INSERT INTO appuser (userRole, name, mobileNumber, email, password, address, status) "
//                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//                // Prepare the statement for insertion
//                pst = con.prepareStatement(insertQuery);
//
//                // Set values for the prepared statement
//                pst.setString(1, "SuperAdmin"); // userRole
//                pst.setString(2, "Aniefiork peace"); // name
//                pst.setString(3, "09137696550"); // mobileNumber
//                pst.setString(4, "aniefiorkpeace@gmail.com"); // email
//                pst.setString(5, "admin"); // password
//                pst.setString(6, "123 Main St"); // address
//                pst.setString(7, "Admin"); // status
//
//                // Execute the insertion
//                pst.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Data inserted successfully!");
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Connection failed!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();  // Print full error for debugging
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        } finally {
//            try {
//                if (pst != null) {
//                    pst.close();  // Close the prepared statement safely
//                }
//                if (st != null) {
//                    st.close();  // Close the statement safely
//                }
//                if (con != null) {
//                    con.close();  // Close the connection safely
//                }
//            } catch (Exception e) {
//                e.printStackTrace();  // Catch and print any closing exceptions
//            }
//        }
//    }
//}
