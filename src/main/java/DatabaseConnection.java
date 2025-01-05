import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Connection connection = null;

    // Database credentials as class-level constants
    private static final String URL = "jdbc:mysql://localhost:3306/searchEnginApp";
    private static final String USER = "root";
    private static final String PASSWORD = "Harsh2003+";

    // Method to get connection
    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }
        // Call the private method to establish the connection
        return createConnection(URL, USER, PASSWORD);
    }

    // Private method to create the connection
    private static Connection createConnection(String db, String user, String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            connection = DriverManager.getConnection(db, user, pwd); // Create and return connection
        }catch (Exception exception){
            exception.printStackTrace(); // Print error if connection fails
        }
        return connection;
    }
}
