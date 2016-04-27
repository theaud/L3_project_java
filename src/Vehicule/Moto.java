package Vehicule;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Moto extends Vehicule {

    private double Cylindree;


    public Moto(double cylindree) {        Cylindree = cylindree;    }


    public double getCylindree() {        return Cylindree;    }

    public void setCylindree(double cylindree) {        Cylindree = cylindree;    }
}
