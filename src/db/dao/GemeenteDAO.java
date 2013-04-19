/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;
import gebruikers.data.Gemeente;

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
public class GemeenteDAO {
    
    private static GemeenteDAO instance = null;
    
    private GemeenteDAO() {}
    
    public static GemeenteDAO getInstance() {
        if (instance == null) {
            instance = new GemeenteDAO();
            return instance;
        } else {
            return instance;
        }
    }
    
    
    
    public Gemeente getPostcodeByGemeente(String gemeente) throws SQLException{
        String sql = "SELECT *  FROM postcode WHERE Gemeente=?;";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gemeente);
        ResultSet res = ps.executeQuery();
        
        Gemeente gem = new Gemeente();
        gem.setPostcode(res.getInt(1));
        gem.setGemeente(res.getString(2));
        gem.setHoofdgemeente(res.getString(3));
        gem.setProvincie(res.getString(4));
        return gem;
        
    }
    
    public List<Gemeente> getGemeentes() throws SQLException {
        List<Gemeente> lstGemeente = new ArrayList<>();

        String sql = "SELECT *  FROM postcode WHERE Gemeente=?;";

        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet res = ps.executeQuery();

        while (res.next()) {
            Gemeente gem = new Gemeente();
            gem.setPostcode(res.getInt(1));
            gem.setGemeente(res.getString(2));
            gem.setHoofdgemeente(res.getString(3));
            gem.setProvincie(res.getString(4));
            lstGemeente.add(gem);
        }
        return lstGemeente;
    }
    
}
