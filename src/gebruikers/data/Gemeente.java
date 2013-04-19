/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gebruikers.data;

/**
 *
 * @author xavier
 */
public class Gemeente {
    
    private int postcode;
    private String gemeente;
    private String hoofdgemeente;
    private String provincie;

    public Gemeente() {
    }

    public Gemeente(int postcode, String gemeente, String hoofdgemeente, String provincie) {
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.hoofdgemeente = hoofdgemeente;
        this.provincie = provincie;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getHoofdgemeente() {
        return hoofdgemeente;
    }

    public void setHoofdgemeente(String hoofdgemeente) {
        this.hoofdgemeente = hoofdgemeente;
    }

    public String getProvincie() {
        return provincie;
    }

    public void setProvincie(String provincie) {
        this.provincie = provincie;
    }
}
