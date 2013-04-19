/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;
import gebruikers.data.Gebruiker;

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
public class GebruikerDAO {
    private static GebruikerDAO instance = null;
    
    private GebruikerDAO() {}
    
    public static GebruikerDAO getInstance() {
        if (instance == null) {
            instance = new GebruikerDAO();
            return instance;
        } else {
            return instance;
        }
    }
}
