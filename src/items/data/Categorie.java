/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items.data;

/**
 *
 * @author xavier
 */
public class Categorie {
    //<editor-fold defaultstate="collapsed" desc="fields">
    private String ID;
    private String Naam;
    private String Beschrijving;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public Categorie(String ID, String Naam, String Beschrijving) {
        this.ID = ID;
        this.Naam = Naam;
        this.Beschrijving = Beschrijving;
    }
    
    public Categorie(){}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public String getBeschrijving() {
        return Beschrijving;
    }

    public void setBeschrijving(String Beschrijving) {
        this.Beschrijving = Beschrijving;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        return "Categorie{" + "ID=" + ID + ", Naam=" + Naam + ", Beschrijving=" + Beschrijving + '}';
    }
    
   
}
