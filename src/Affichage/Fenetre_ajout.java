package Affichage;

import BDD.Gestion_BDD;
import Graphique.Ecran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre_ajout extends Ecran {



    public Fenetre_ajout(int type){

        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));


        name="Fenetre_ajout";
        setBackground(Color.pink);


        //---------------------------------------------------


        //-------------------------------------------------------------------------------------------------------------------
        // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
        // -------------------------------------------------------------------------------------------------------------------



        initialisation_formulaire(type);

    }


    private void initialisation_formulaire(int type)
    {
        switch (type)
        {//Nouveau Emprunteur
         case 0:nouveau_Emprunteur();
             break;
            //Nouveau vehicule
         case 1:break;
            //Nouveau devis
         case 2:break;


        }
    }

 private void nouveau_Emprunteur()
 {int largeur=500;
     initialiser(1,5,5,6);

     //ligne 0

     texte[0].setText("Nom");

     form[0].setPreferredSize(new Dimension(largeur/3, 30));
     lign[0].add(texte[0]);
     lign[0].add(form[0]);

     //ligne 1

     texte[1].setText("Prenom");

     form[1].setPreferredSize(new Dimension(largeur/3, 30));
     lign[1].add(texte[1]);
     lign[1].add(form[1]);

     //ligne 2

     texte[2].setText("Adresse");

     form[2].setPreferredSize(new Dimension(largeur/3, 30));
     lign[2].add(texte[2]);
     lign[2].add(form[2]);


     //ligne 3

     texte[3].setText("Assurance");

     form[3].setPreferredSize(new Dimension(largeur/3, 30));
     lign[3].add(texte[3]);
     lign[3].add(form[3]);


     //ligne 4

     texte[4].setText("(erreur)");

     lign[4].add(texte[4]);

     //ligne 5

     bouton[0].addActionListener(new Validation());
     lign[5].add(bouton[0]);

    //on met les differentes lignes dans la fenetre
     add(lign,6);

 }


    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;

            for(int i=0;i<3;i++)
            {
                if(form[i].getText().equals(""))
                {
                    test=false;
                }
            }
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {
                    texte[4].setText("nouveau user cree");
                    Gestion_BDD.ajout_Eprunteur(form[0].getText(),form[1].getText(),form[2].getText(),form[3].getText().equals(""));
                }
            else
                {
                    texte[4].setText("(erreur) pas tous les champ remplie");
                }
            System.out.println(" confirmation ");
















        }
    }








}
