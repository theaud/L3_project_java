package Location;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Date {
    private int Jour;
    private int Mois;
    private int Annee ;

    public Date(int jour, int annee, int mois) {
        Jour = jour;
        Annee = annee;
        Mois = mois;
    }

    public int getJour() {        return Jour;    }

    public void setJour(int jour) {        Jour = jour;    }

    public int getAnnee() {        return Annee;    }

    public void setAnnee(int annee) {        Annee = annee;    }

    public int getMois() {        return Mois;    }

    public void setMois(int mois) {        Mois = mois;    }
}
