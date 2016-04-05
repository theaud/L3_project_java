package Affichage;

import BDD.Gestion_BDD;
import Graphique.Ecran;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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
 {name="Nouveau Emprunteur";
     initialiser(1,5,5,6);

     //ligne 0
     texte[0].setText("Nom");
     lign[0].add(texte[0],form[0]);

     //ligne 1
     texte[1].setText("Prenom");
     lign[1].add(texte[1],form[1]);

     //ligne 2
     texte[2].setText("Adresse");
     lign[2].add(texte[2],form[2]);

     //ligne 3
     texte[3].setText("Assurance");
     lign[3].add(texte[3],form[3]);

     //ligne 4
     texte[4].setText("");
     lign[4].add(texte[4]);

     //ligne 5
     bouton[0].setBouton(" nom a trouver",new Validation());
     lign[5].add(bouton[0]);

    //on met les differentes lignes dans la fenetre
     add(lign,6);

 }


    public static  LinkedList<String> add(String t1,String t2,String t3,String t4)
    {LinkedList<String> text=new LinkedList<String>();
        text.add(t1);        text.add(t2);        text.add(t3);        text.add(t4);
        return text;
    }
    public static void ajout_Eprunteur(LinkedList<String> texte)    {   Gestion_BDD. ajout("./src/BDD/Emprunteur/",  texte);}



    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;

            for(int i=0;i<3;i++) { if(form[i].getText().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {
                    texte[4].setText("nouveau user cree");
                    LinkedList<String> text=add(form[0].getText(),form[1].getText(),form[2].getText(),""+form[3].getText().equals(""));

                    ajout_Eprunteur(text);
                   // Gestion_BDD. ajout_Eprunteur(LinkedList<String> texte); =>>> a integrer c'est plus reutilisable
                }
            else
                {
                    texte[4].setText("(erreur) pas tous les champ remplie");
                }
            System.out.println(" confirmation ");

        }
    }








}
