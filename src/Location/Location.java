package Location;


public class Location {
    private int Numero=0;
    private int Debut;
    private int Fin;

    public Location(int numero, int fin, int debut) {
        Numero = numero;
        Fin = fin;
        Debut = debut;
    }

    public int getNumero() {        return Numero;    }
    public void setNumero(int numero) {        Numero = numero;    }

    public int getFin() {        return Fin;    }
    public void setFin(int fin) {        Fin = fin;}

    public int getDebut() {return Debut;}
    public void setDebut(int debut) {Debut = debut;}
}
