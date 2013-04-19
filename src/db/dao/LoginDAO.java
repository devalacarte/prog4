/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author xavier
 */
public class LoginDAO {
    private static LoginDAO instance = null;

    private LoginDAO() {
    }

    public static LoginDAO getInstance() {
        if (instance == null) {
            instance = new LoginDAO();
            return instance;
        } else {
            return instance;
        }
    }
    
    public boolean checkUserCorrect(String gebruikersnaam)throws SQLException{
        boolean gebruiker = false;
        
        String sql = "SELECT Login FROM gebruikers WHERE Login=?;";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gebruikersnaam);
        ResultSet res = ps.executeQuery();
        
        if (res.next()){
            //gebruiker = res.getString(1);
            gebruiker = true;
        }
        return gebruiker;
    }
    
    public String checkPassCorrect(String gebruikersnaam) throws SQLException{
        String pass = "";
        
        String sql = "SELECT Pass FROM gebruikers WHERE Login=?;";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gebruikersnaam);
        ResultSet res = ps.executeQuery();
        
        if (res.next()){
            //gebruiker = res.getString(1);
            pass = res.getString(1);
        }
        return pass;
    }
    
    public boolean isAdmin(String gebruikersnaam) throws SQLException{
        boolean bln = false;
        
        String sql = "SELECT Admin FROM gebruikers WHERE Login=?;";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gebruikersnaam);
        ResultSet res = ps.executeQuery();
        
        if (res.next()){
            if (res.getString(1).equals("Y")){
                bln = true;
            }else if (res.getString(1).equals("N")){
                bln = false;
            }
        }
        
        return bln;
    }
    
}
