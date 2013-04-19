/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gebruikers.data;

import db.dao.LoginDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author xavier
 */
public class Login{
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    private String gebruikersnaam;
    private String wachtwoord;
    private boolean isAdmin;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public Login() {
    }

    public Login(String gebruikersnaam, String wachtwoord, boolean isAdmin) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    

    //</editor-fold>
    
    public String checkPass(String gebruikersnaam, String pass){
        String s ="";
        pass = md5(pass);
        try {
            if (LoginDAO.getInstance().checkPassCorrect(gebruikersnaam).equals(pass)){
                s = pass;
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        } 
        return s;
    }
    
    public String checkGebruiker(String gebruikersnaam){
        String s ="";
        
        try { 
            if (LoginDAO.getInstance().checkUserCorrect(gebruikersnaam) == true){
                s = gebruikersnaam;
            }
         }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }  
        
        return s;
    }
    
    
    public static String md5(String input) {
        String md5 = null;
        if(null == input) return null;
  
        try {           
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
    
    
    
}
