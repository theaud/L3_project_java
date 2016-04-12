package Affichage;

import BDD.Gestion_BDD;
import Graphique.Ecran;
import Graphique.Fenetre;
import Graphique.Lign;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class affichage_utilisateur extends Ecran {

    public affichage_utilisateur(){

        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));



        name="Login initialiser";



        initialiser(6,6);
        Login_initialisation();

    }


    private void Login_initialisation()
    {
        //on modifie la taille des ligne

//--------------------------------------------------------------------------------------------------------------

        LinkedList<JLabel> text= Gestion_BDD.lecture_ecran("src/BDD/Emprunteur/",1);

        Fenetre container=new Fenetre();
    for(int i=0;i<6;i++)
        {texte[i]=text.get(i);
            container.add(texte[i]);}


//--------------------------------------------------------------------------------------------------------------
        //on met les differentes lignes dans la fenetre
        add(container);
    }










}
