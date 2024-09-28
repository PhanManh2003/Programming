package demojbdc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    public static void main(String[] args) throws SQLException {
        String serverName = "DESKTOP-MLOTP07\\MANH";
        String dbName = "HE172481";
        String uid = "sa";
        String pwd = "123";
        String port = "1433";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + serverName + ":" + port
                + ";databaseName=" + dbName
                + ";encrypt=true;TrustServerCertificate=true";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver
            Class.forName(driver);

            // Establish the connection
            conn = DriverManager.getConnection(url, uid, pwd);

            if (conn != null) {
                System.out.println("Connected to the database.");

                // Create a statement object
                stmt = conn.createStatement();

                // Insert a record into the Car table
//                String sql_insert = "INSERT INTO Car VALUES (4, 'BMW')";
//                stmt.executeUpdate(sql_insert);

//Insert cách 2
                String sql_insert = "INSERT INTO Car VALUES (?,?)";
                // create prepareStatement object
                PreparedStatement preStmt = conn.prepareStatement(sql_insert); 
                preStmt.setInt(1, 6);
                preStmt.setString(2, "Santafe");
                int i = preStmt.executeUpdate();
                
                System.out.println(i + " lines changed.");

                // Retrieve and print records from the Car table
                String sql = "SELECT * FROM Car";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2));
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE,
                    "JDBC Driver not found", ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE,
                    "SQL Exception", ex);
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDBC.class.getName()).log(
                        Level.SEVERE, "Error closing resources", 
                        ex);
            }
        }
    }
}
