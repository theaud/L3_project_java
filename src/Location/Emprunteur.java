package Location;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Emprunteur {

    private int Id=0;
    private String Nom="nom";
    private String Prenom="prenom";
    private Adresse adresse;


    public void louer(){}
    public void ramener(){}


    public Emprunteur(int id, Adresse adresse, String nom, String prenom) {
        Id = id;
        this.adresse = adresse;
        Nom = nom;
        Prenom = prenom;
    }

    public int getId() {return Id;    }

    public void setId(int id) {        Id = id;    }

    public Adresse getAdresse() {        return adresse;    }

    public void setAdresse(Adresse adresse) {this.adresse = adresse;    }

    public String getNom() {return Nom;}

    public void setNom(String nom) {        Nom = nom;    }

    public String getPrenom() { return Prenom;    }

    public void setPrenom(String prenom) {        Prenom = prenom;    }
}
