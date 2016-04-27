package Vehicule;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Exemplaire {

    private int     Numero=0;
    private Double  Kilometres=0.0;

    public Exemplaire(){}


    public Exemplaire(int numero, Double kilometres) {
        Numero = numero;
        Kilometres = kilometres;
    }


    public int getNumero() {return Numero;    }
    public void setNumero(int numero) {        Numero = numero;    }

    public Double getKilometres() {        return Kilometres;    }
    public void setKilometres(Double kilometres) {        Kilometres = kilometres;    }
}
