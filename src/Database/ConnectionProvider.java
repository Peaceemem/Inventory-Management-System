package Database;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    public static Connection getCon() {
        try {
            // Load MySQL Connector/J 8.x driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database, specifying the time zone
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventory?useSSL=false&serverTimezone=Africa/Lagos", 
                "root", 
                "peace@966721"
            );
            return con;
        } catch (Exception e) {
            // Print the full stack trace for better debugging
            e.printStackTrace();
            return null;
        }
    }
}
