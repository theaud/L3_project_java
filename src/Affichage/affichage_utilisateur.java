package Affichage;

import BDD.Gestion_BDD;
import Graphique.Ecran;
import Graphique.Lign;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class affichage_utilisateur extends Ecran {

    public affichage_utilisateur(){

        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));



        name="Login initialiser";



        initialiser(0,0,6,6);
        Login_initialisation();

    }


    private void Login_initialisation()
    {
        //on modifie la taille des ligne
        lign= Lign.assemblage_ligne(lign,4,60);
//--------------------------------------------------------------------------------------------------------------

        LinkedList<JLabel> text= Gestion_BDD.lecture_ecran("src/BDD/Emprunteur/",1);


    for(int i=0;i<6;i++)
        {texte[i]=text.get(i);
        lign[i].add(texte[i]);}


//--------------------------------------------------------------------------------------------------------------
        //on met les differentes lignes dans la fenetre
        add(lign,6);
    }










}
