package Vehicule;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Auto extends Vehicule {

    private String Marque;


    public Auto(String marque) {        this.Marque = marque;    }

    public String getMarque() {        return Marque;    }

    public void setMarque(String marque) {this.Marque = marque;    }
}
