package Affichage;

import BDD.Gestion_BDD;
import Graphique.Ecran;

import javax.swing.*;
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

         case 3:

             afficher_emprunteurtest();
             break;


        }
    }




 private void nouveau_Emprunteur()
 {name="Nouveau Emprunteur";
     initialiser(1,5,1,6);

     //ligne 0
     form[0].setTexteString("Nom");
     lign[0].add(form[0]);

     //ligne 1
     form[1].setTexteString("Prenom");
     lign[1].add(form[1]);

     //ligne 2
     form[2].setTexteString("Adresse");
     lign[2].add(form[2]);

     //ligne 3
     form[3].setTexteString("Assurance");// =>  JCheckBox premier = new JCheckBox("Nom check box");
     lign[3].add(form[3]);

     //ligne 4
     texte[0].setText("");
     lign[4].add(texte[0]);

     //ligne 5
     bouton[0].setBouton(" nom a trouver",new Validation());
     lign[5].add(bouton[0]);

    //on met les differentes lignes dans la fenetre
     add(lign,6);

 }

    private void afficher_emprunteurtest()
    {
        name="Nouveau Emprunteur";
        add(Gestion_BDD.afficher_utilisateur_console(2));




    }



    public static  LinkedList<String> add(String t1,String t2,String t3,String t4,String t5)
    {LinkedList<String> text=new LinkedList<String>();
        text.add(t1);        text.add(t2);        text.add(t3);        text.add(t4);    text.add(t5);
        return text;
    }
    public static void ajout_Eprunteur(LinkedList<String> texte)    {   Gestion_BDD. ajout("./src/BDD/Emprunteur/",  texte);}



    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;

            for(int i=0;i<3;i++) { if(form[i].getForm().getText().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {
                    texte[4].setText("nouveau user cree");
                    LinkedList<String> text=add(form[0].getContain(),form[1].getContain(),form[2].getContain(),""+form[3].getContain().equals(""),""+0);

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
