package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

public class DBContext {

    Connection connection;

    public DBContext() {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://DESKTOP-MLOTP07\\MANH:1433;databaseName=Human";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<>();
        try {
            // Take data from DB to create an human object, then add to ArrayList
            String sql = "SELECT h.humanid, h.humanname, h.humandob, h.humangender,"
                    + "ht.typeid, ht.typename " + " FROM Human h INNER JOIN HumanType"
                    + " ht ON h.typeid = ht.typeid";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Human h = new Human();
                h.setID(rs.getInt("humanid"));
                h.setName(rs.getString("humanname"));
                h.setDob(rs.getDate("humandob"));
                h.setGender(rs.getBoolean("humangender"));

                HumanType ht = new HumanType();
                ht.setTypeiD(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                h.setType(ht);
                humans.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return humans;
    }

    public ArrayList<HumanType> getTypes() {
        ArrayList<HumanType> types = new ArrayList<>();
        try {
            String sql = "SELECT typeid, typename FROM HumanType";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HumanType ht = new HumanType();
                ht.setTypeiD(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                types.add(ht);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return types;
    }

    public void insertHuman(Human human) {
        String sql = "INSERT INTO Human (humanid, humanname, humandob, "
                + "humangender, typeid) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, human.getID());
            statement.setString(2, human.getName());
            // Corrected index and conversion
            statement.setDate(3, new java.sql.Date(human.getDob().getTime()));
            statement.setBoolean(4, human.isGender());
            statement.setInt(5, human.getType().getTypeiD());
            int i = statement.executeUpdate();
            System.out.println(i + " line(s) changed.");
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateHuman(Human human) {
        String sql = "UPDATE Human SET humanname = ?, humandob = ?, "
                + "humangender = ?, typeid = ? WHERE humanid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, human.getName());
            // Corrected index and conversion
            statement.setDate(2, new java.sql.Date(human.getDob().getTime()));
            statement.setBoolean(3, human.isGender());
            statement.setInt(4, human.getType().getTypeiD());
            statement.setInt(5, human.getID());
            int i = statement.executeUpdate();
            System.out.println(i + " line(s) changed.");
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteHuman(Human human) {
        String sql = "DELETE FROM Human WHERE humanid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, human.getID());
            int i = statement.executeUpdate();
            System.out.println(i + " line(s) deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
