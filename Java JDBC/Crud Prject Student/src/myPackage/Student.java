package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    // Database connection details
    private final String url = "jdbc:mysql://localhost:3306/DB";
    private final String userName = "root";
    private final String password = "root";

    // Method to insert data into the 'student' table
    public void createData(int id, String name, String email) {
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO student (sid, sname, semail) VALUES (?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, id);
            pstm.setString(2, name);
            pstm.setString(3, email);
            
            pstm.executeUpdate();
            System.out.println("Data Inserted Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read data from the 'student' table
    public void readData() {
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM student";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt(1));
                System.out.println("Name = " + rs.getString(2));
                System.out.println("Email = " + rs.getString(3));
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to update data in the 'student' table
    public void updateData(int id, String name) {
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE student SET sname = ? WHERE sid = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setString(1, name);
            pstm.setInt(2, id);
            
            pstm.executeUpdate();
            System.out.println("Data Updated Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete data from the 'student' table
    public void deleteData(int id) {
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, id);
            
            pstm.executeUpdate();
            System.out.println("Data Deleted Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
