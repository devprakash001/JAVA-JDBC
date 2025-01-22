package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

    public void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();
            
            String query = "CREATE DATABASE DB";
            stm.executeUpdate(query);
            System.out.println("Database Created Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            String url = "jdbc:mysql://localhost:3306/DB";
            String userName = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();
            
            String query = "CREATE TABLE student (sid INT(3), sname VARCHAR(200), semail VARCHAR(200))";
            stm.executeUpdate(query);
            System.out.println("Table Created Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createData() {
        try {
            String url = "jdbc:mysql://localhost:3306/DB";
            String userName = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String query = "INSERT INTO student (sid, sname, semail) VALUES (?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, 2);
            pstm.setString(2, "Dev");
            pstm.setString(3, "dev@gmail.com");
            
            pstm.executeUpdate();
            System.out.println("Data Inserted Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            String url = "jdbc:mysql://localhost:3306/DB";
            String userName = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String query = "Select * from student";
            Statement stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("id = "+rs.getInt(1));
                System.out.println("name = "+rs.getString(2));
                System.out.println("email = "+rs.getString(3));
            }

            System.out.println("Read Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        try {
            String url = "jdbc:mysql://localhost:3306/DB";
            String userName = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String query = "UPDATE student set sid = ? where sname = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, 1001);
            pstm.setString(2, "shivam");
            
            pstm.executeUpdate();
            System.out.println("Data Updated Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {
        try {
            String url = "jdbc:mysql://localhost:3306/DB";
            String userName = "root";
            String password = "root";
    
            Connection conn = DriverManager.getConnection(url, userName, password);
            
            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, 1002);
            
            pstm.executeUpdate();
            System.out.println("Data Deleted Successfully");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
