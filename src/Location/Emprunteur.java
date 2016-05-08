package Location;

import BDD.Gestion_BDD;
import Graphique.Lign;

import javax.swing.*;
import java.util.LinkedList;

public class Emprunteur {

    private int Id=0;
    private String Nom="nom";
    private String Prenom="prenom";
    private String Adresse;
    private boolean Assurance=true;
    private int Nb_devis=0;
    private int [] reference_Devis;

    public void louer(){}
    public void ramener(){}


    public Emprunteur(int id, String adresse, String nom, String prenom) {
        Id = id;
        Adresse = adresse;
        Nom = nom;
        Prenom = prenom;
    }

    public Emprunteur(int id)
    {String chemin="./src/BDD/Emprunteur/";

    LinkedList<String> texte= Gestion_BDD.lecture(chemin,id);
    util3.Util3.afficher(texte);

    Id = id;
    Nom=texte.get(1);
    Prenom=texte.get(2);
    Adresse=texte.get(3);
    Assurance=texte.get(4).equals("true");
    Nb_devis=Integer.parseInt("0"+texte.get(5));
    reference_Devis=new int [Nb_devis];

    if(!texte.get(5).equals(""+0))
        {for(int i=0;i<texte.size()-6;i++)
            {reference_Devis[i]=Integer.parseInt("0"+texte.get(i+6));}
        }

    }

    public static JLabel afficher_utilisateur_console(int id)
        {Emprunteur current=new Emprunteur(id);
        LinkedList<String> texte_ajout=new LinkedList<String>();

        texte_ajout.add("Fiche emprunteur");
        texte_ajout.add("Id de l'utilisateur :"+id);
        texte_ajout.add("Nom  :"+current.getNom());
        texte_ajout.add("Prenom :"+current.getPrenom());
        texte_ajout.add("Adresse :"+current.getAdresse());
        texte_ajout.add("A souscrit à l'assurance :"+current.isAssurance());

        if(current.getNb_devis()<=0)
            {texte_ajout.add("L'emprunteur a actuellment louer aucun vehicules");}
        else
            {texte_ajout.add("\nL'emprunteur a actuellment louer :"+current.getNb_devis()+" vehicules");
                for(int i=0;i<current.getNb_devis()-6;i++)
                {texte_ajout.add("\ndevis numero :"+current.getReference_Devis()[i+6]);}
            }


        util3.Util3.afficher(texte_ajout);
        return Lign.mise_en_forme_ligne_jpanel(texte_ajout);
    }
    public int getId() {return Id;    }
    public void setId(int id) {        Id = id;    }

    public String getAdresse() {        return Adresse;    }
    public void setAdresse(String adresse) {this.Adresse = adresse;    }

    public String getNom() {return Nom;}
    public void setNom(String nom) {        Nom = nom;    }

    public String getPrenom() { return Prenom;    }
    public void setPrenom(String prenom) {        Prenom = prenom;    }


    public boolean isAssurance() {        return Assurance;    }
    public void setAssurance(boolean assurance) {        Assurance = assurance;    }

    public int[] getReference_Devis() {        return reference_Devis;    }
    public void setReference_Devis(int[] reference_Devis) {        this.reference_Devis = reference_Devis;    }

    public int getNb_devis() {        return Nb_devis;    }
    public void setNb_devis(int nb_devis) {        Nb_devis = nb_devis;    }
}
