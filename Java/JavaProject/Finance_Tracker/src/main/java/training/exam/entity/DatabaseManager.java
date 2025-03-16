package training.exam.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-MLOTP07\\MANH:1433;databaseName=FA_JavaFinal";
            String user = "sa";
            String password = "123";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");
            return null;
        }

    }

    public static void main(String[] args) {
        DatabaseManager test = new DatabaseManager();
        test.connection = test.getConnection();
        System.out.println(test.connection);
    }

    public void AddUser(User user) {
        // Declare resources
        PreparedStatement statement = null;
        try {
            // Connect with DB
            connection = getConnection();
            // Prepare SQL statement
            String sql = "INSERT INTO [dbo].[Users] ([Username], [Password]) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, user.getUsername());
            statement.setObject(2, user.getPassword());

            // Execute update
            int i = statement.executeUpdate();
            // Get generated key
            if (i > 0) {
                System.out.println("Add user successfully!");
            } else {
                System.out.println("Add user fail!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void addTransaction(Transaction transaction) {
        // Declare resources
        PreparedStatement statement = null;

        try {
            // Connect with DB
            connection = getConnection();
            // Prepare SQL statement
            String sql = "INSERT INTO [dbo].[Transactions] ([User_id], [Amount],"
                    + " [Category], [Type],[Date],[Description]) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, transaction.getUserId());
            statement.setObject(2, transaction.getAmount());
            statement.setObject(3, transaction.getCategory());
            statement.setObject(4, transaction.getType());
            statement.setObject(5, new java.sql.Date(transaction.getDate().getTime()));
            statement.setObject(6, transaction.getDescription());

            // Execute update
            int i = statement.executeUpdate();

            // Get generated key
            if (i > 0) {
                System.out.println("Add transaction successfully!");
            } else {
                System.out.println("Add transaction fail!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Close resources
            try {

                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void removeTransaction(int transactionId) {
        // Declare resources
        PreparedStatement statement = null;

        try {
            // Connect with DB
            connection = getConnection();
            // Prepare SQL statement
            String sql = "DELETE FROM [dbo].[Transactions] WHERE [Transaction_id] = ?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, transactionId);

            // Execute delete
            int i = statement.executeUpdate();

            // Get generated key
            if (i > 0) {
                System.out.println("Delete transaction successfully!");
            } else {
                System.out.println("Delete transaction fail!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Transaction> getUserTransaction(int userId) {
        ArrayList<Transaction> trans = new ArrayList<>();
        try {
            // Connect with DB
            connection = getConnection();
            // Take data from DB to create an human object, then add to ArrayList
            String sql = "SELECT Transaction_id, User_id, Amount, Category,"
                    + "Type, Date, Description " + " FROM Transactions"
                    + " WHERE User_id= ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction();
                t.setTransactionId(rs.getInt("Transaction_id"));
                t.setUserId(rs.getInt("User_id"));
                t.setAmount((double) rs.getDouble("Amount"));
                t.setCategory(rs.getString("Category"));
                t.setType(rs.getString("Type"));
                t.setDescription(rs.getString("Description"));
                t.setDate(rs.getDate("Date"));
                trans.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return trans;
    }

}
