import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CreateDB {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "Dev";
            String userName = "root";
            String password = "root";

            // Establishing the connection
            connection = DriverManager.getConnection(url, userName, password);

            // SQL query to create the database
            String sql = "CREATE DATABASE " + databaseName;

            // Executing the statement
            statement = connection.createStatement();
            statement.executeUpdate(sql);

            // Show success message
            JOptionPane.showMessageDialog(null, "Database '" + databaseName + "' created successfully!", 
                                          "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
