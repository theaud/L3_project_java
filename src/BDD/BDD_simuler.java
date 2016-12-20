package BDD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Graphique.aide.Lign.mise_en_forme_ligne_jpanel;


public class BDD_simuler {

    public List<user>     utilisateur=new ArrayList<>();
    public List<vehicule> flotte=new ArrayList<>();



    public BDD_simuler()
    {
        utilisateur.add(new user());
        utilisateur.add(new user());
        utilisateur.add(new user());
        utilisateur.add(new user());


        flotte.add(new vehicule());
        flotte.add(new vehicule());
        flotte.add(new vehicule());
        flotte.add(new vehicule());
    }

    public LinkedList<String> get_Affichage_user()
    {
        LinkedList<String> text=new LinkedList<>();

        text.add("ID nom prenom");
        for (BDD.user valeur:utilisateur) {
           text.add(valeur.afficher());}
        text.add("");
        return text;
    }

    public LinkedList<String> get_Affichage_flotte()
    {
        LinkedList<String> text=new LinkedList<>();


        text.add("ID marque");
        for(int i=0;i<utilisateur.size();i++){text.add(flotte.get(i).afficher());}

        return text;
    }

    public JLabel afficher_BDD_simuler()
    {
    LinkedList<String> texte=get_Affichage_user();
    texte.addAll(get_Affichage_flotte());
        return mise_en_forme_ligne_jpanel(texte);
    }


    public boolean estPresentNom(String nom)
        {for (BDD.user valeur:utilisateur) {
           if(valeur.nom.equals(nom))
                {return true;}}
            return false;
        }





}
