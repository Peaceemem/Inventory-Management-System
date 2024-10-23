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
        Connection con = null;
        Statement st = null;

        try {
            // Establish the database connection
            con = ConnectionProvider.getCon();
            if (con != null) {
                st = con.createStatement();

                // SQL query to create the 'customer' table with a UNIQUE constraint on the email field
//                String createTableQuery = "CREATE TABLE orderDetails ("
//                        + "order_pk INT AUTO_INCREMENT PRIMARY KEY, "
//                        + "orderId VARCHAR(200), "
//                        + "customer_fk int, "
//                        + "orderDate VARCHAR(200),"
//                        + "totalPaid int)";
                String createTableQuery = "CREATE TABLE orderDetails ("
                        + "order_pk INT AUTO_INCREMENT PRIMARY KEY, "
                        + "orderId VARCHAR(200), "
                        + "customer_fk INT, "
                        + "orderDate VARCHAR(200)," // Changed to DATE type for better date management
                        + "totalPaid INT,"
                        + "FOREIGN KEY (customer_fk) REFERENCES customer(customer_pk))";

                // Execute the SQL query
                st.executeUpdate(createTableQuery);
                JOptionPane.showMessageDialog(null, "Table created successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Connection failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print full error for debugging
            JOptionPane.showMessageDialog(null, e.getMessage());
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
