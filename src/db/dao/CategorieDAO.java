/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;
import items.data.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
/**
 *
 * @author xavier
 */
public class CategorieDAO {
    
    private static CategorieDAO instance = null;
    
    private CategorieDAO() {}
    
    public static CategorieDAO getInstance() {
        if (instance == null) {
            instance = new CategorieDAO();
            return instance;
        } else {
            return instance;
        }
    }
    
    public void createCategorie(Categorie cat) throws SQLException {
        //INSERT INTO `categorie` (`ID`, `Naam`, `Beschrijving`) VALUES ('BADK', 'Kleine Badkamer Apparatuur', 'Haardroger, voetbad, scheerapparaat, . . .');
        String sql = "INSERT INTO `categorie` (`ID`, `Naam`, `Beschrijving`) VALUES (?,?,?)";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cat.getID());
        ps.setString(2, cat.getNaam());
        ps.setString(3, cat.getBeschrijving());
        ps.executeUpdate();
    }
    
    public void deleteCategorie(Categorie cat) throws SQLException {
        String sql = "DELETE FROM categorie WHERE ID=?";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cat.getID());
        ps.executeUpdate();
    }
    
    public Categorie getCategorieByID(String id) throws SQLException{
        String sql = "SELECT *  FROM categorie WHERE ID=?;";
        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet res = ps.executeQuery();
        
        Categorie cat = new Categorie();
        
        if (res.next()){
            cat.setID(res.getString(1));
            cat.setNaam(res.getString(2));
            cat.setBeschrijving(res.getString(3));
        }

        return cat;
        
    }
    
    public List<Categorie> getCategories() throws SQLException {
        List<Categorie> lstcategories = new ArrayList<>();

        String sql = "SELECT *  FROM categorie;";

        Connection conn = MySQLDatabase.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //invoeren van parameters

        //uitvoeren
        ResultSet res = ps.executeQuery();

        while (res.next()) {
            String id = res.getString(1);
            String naam = res.getString(2);
            String beschrijving = res.getString(3);
            Categorie cat = new Categorie(id, naam, beschrijving);
            lstcategories.add(cat);
        }
        return lstcategories;
    }
    
    
    
}
