/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gebruikers.data;

/**
 *
 * @author xavier
 */
public class Gebruiker extends gebruikers.data.Login{
    //<editor-fold defaultstate="collapsed" desc="fields">
    private int id;
    private String voornaam;
    private String achternaam;
    private String Straat;
    private int huisnr;
    private int bus;
    private String gemeente;
    private String email;
    private String tel;
    private String gsm;
    private String login;
    private String pass;
    private boolean admin;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors">
    public Gebruiker() {
    }
    
    public Gebruiker(Login login) {
        super(login.getGebruikersnaam(), login.getWachtwoord(), login.getIsAdmin());
    }

    public Gebruiker(int id, String voornaam, String achternaam, String Straat, int huisnr, int bus, String gemeente, String email, String tel, String gsm) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.Straat = Straat;
        this.huisnr = huisnr;
        this.bus = bus;
        this.gemeente = gemeente;
        this.email = email;
        this.tel = tel;
        this.gsm = gsm;
    }
    
    public Gebruiker(String gebruikersnaam, String wachtwoord, boolean isAdmin, int id, String voornaam, String achternaam, String Straat, int huisnr, int bus, String gemeente, String email, String tel, String gsm) {
        super(gebruikersnaam, wachtwoord, isAdmin);
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.Straat = Straat;
        this.huisnr = huisnr;
        this.bus = bus;
        this.gemeente = gemeente;
        this.email = email;
        this.tel = tel;
        this.gsm = gsm;
    }
    
    public Gebruiker(Login login, int id, String voornaam, String achternaam, String Straat, int huisnr, int bus, String gemeente, String email, String tel, String gsm) {
        super(login.getGebruikersnaam(), login.getWachtwoord(), login.getIsAdmin());
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.Straat = Straat;
        this.huisnr = huisnr;
        this.bus = bus;
        this.gemeente = gemeente;
        this.email = email;
        this.tel = tel;
        this.gsm = gsm;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getStraat() {
        return Straat;
    }

    public void setStraat(String Straat) {
        this.Straat = Straat;
    }

    public int getHuisnr() {
        return huisnr;
    }

    public void setHuisnr(int huisnr) {
        this.huisnr = huisnr;
    }

    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
    //</editor-fold>
}
