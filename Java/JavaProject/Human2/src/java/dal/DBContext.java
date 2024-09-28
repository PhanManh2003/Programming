/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

/**
 *
 * @author PC
 */
public class DBContext {
        Connection connection;
    
    public DBContext(){
        try {
            String user = "sa";
            String pass = "1";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;"
                    + "databaseName=Human;TrustServerCertificate=True;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Human> getHumans(){
        ArrayList<Human> humans = new ArrayList<Human>();
        try{
            String sql = "SELECT h.humanid, h.humanname, h.humandob, h.humangender, ht.typeid, ht.typename "
                    + "FROM Human h INNER JOIN HumanType ht ON h.typeid=ht.typeid";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Human h = new Human();
                h.setID(rs.getInt("humanid"));
                h.setName(rs.getString("humanname"));
                h.setDob(rs.getDate("humandob"));
                h.setGender(rs.getBoolean("humangender"));
                
                HumanType ht = new HumanType();
                ht.setTypeID(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                
                h.setType(ht);
                
                humans.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return humans;
    }
    
    public int removeHuman(int id){
        int i = 0;
        try{
            String sql = "DELETE FROM Human WHERE humanid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            i = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public int insertHuman(Human h){
        int i = 0;
        
        try{
            String sql = "INSERT INTO Human VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, h.getID());
            statement.setString(2, h.getName());
            statement.setDate(3, new java.sql.Date(h.getDob().getTime()));
            statement.setInt(4, h.isGender()?1:0);
            statement.setInt(5, h.getType().getTypeID());
            
            String s = statement.toString();
            
            i = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
    
    public Human getHumanByID(int id){
        Human h = new Human();
        try{
            String sql = "SELECT h.humanid, h.humanname, h.humandob, h.humangender, ht.typeid, ht.typename FROM Human h INNER JOIN HumanType ht ON h.typeid=ht.typeid WHERE h.humanid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                h.setID(rs.getInt("humanid"));
                h.setName(rs.getString("humanname"));
                h.setDob(rs.getDate("humandob"));
                h.setGender(rs.getBoolean("humangender"));
                
                HumanType ht = new HumanType();
                ht.setTypeID(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                
                h.setType(ht);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }
    
    public int updateHuman(Human h){
        int i = 0;
        try{
            String sql = "UPDATE Human SET [humanname] = ?,[humandob] = ?,[humangender] = ?,[typeid] = ? WHERE humanid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, h.getName());
            statement.setDate(2, new java.sql.Date(h.getDob().getTime()));
            statement.setInt(3, h.isGender()?1:0);
            statement.setInt(4, h.getType().getTypeID());
            statement.setInt(5, h.getID());
            
            i = statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
}
