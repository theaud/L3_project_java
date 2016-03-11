package Location;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Location {
    private int Numero=0;
    private Date Debut;
    private Date Fin;

    public Location(int numero, Date fin, Date debut) {
        Numero = numero;
        Fin = fin;
        Debut = debut;
    }

    public int getNumero() {        return Numero;    }

    public void setNumero(int numero) {        Numero = numero;    }

    public Date getFin() {        return Fin;    }

    public void setFin(Date fin) {        Fin = fin;    }

    public Date getDebut() {        return Debut;    }

    public void setDebut(Date debut) {        Debut = debut;    }
}
