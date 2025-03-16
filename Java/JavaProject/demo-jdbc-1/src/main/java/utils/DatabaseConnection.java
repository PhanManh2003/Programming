package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
public class DatabaseConnection {

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Human", "sa", "123");
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        System.out.println("Connected: " + connection);
    }
}
