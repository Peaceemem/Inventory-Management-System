//package Database;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConnectionProvider {
//    public static Connection getCon() {
//        try {
//            // Load MySQL Connector/J 8.x driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Connect to the MySQL database, specifying the time zone
//            Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/inventory?useSSL=false&serverTimezone=Africa/Lagos", 
//                "root", 
//                "peace@966721"
//            );
//            return con;
//        } catch (Exception e) {
//            // Print the full stack trace for better debugging
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory?useSSL=false&serverTimezone=Africa/Lagos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "peace@966721";

    public static Connection getCon() {
        Connection con = null;
        try {
            // Load MySQL Connector/J 8.x driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Database Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to establish a database connection: " + e.getMessage());
        }

        // Return the connection (or null if unsuccessful)
        return con;
    }
}
