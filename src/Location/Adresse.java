package Location;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Adresse {

    private int     Numero=0;
    private String  Rue="rue";
    private int     CP=0;
    private String  Ville="ville";

    public Adresse() {}

    public Adresse(int numero, int CP, String rue, String ville) {
        Numero = numero;
        this.CP = CP;
        Rue = rue;
        Ville = ville;
    }

    public int getNumero() {return Numero;}

    public void setNumero(int numero) {Numero = numero;}

    public String getRue() {        return Rue;}

    public void setRue(String rue) {        Rue = rue;}

    public String getVille() {        return Ville;}

    public void setVille(String ville) {        Ville = ville;}

    public int getCP() {        return CP;    }

    public void setCP(int CP) {this.CP = CP;    }
}
