package Affichage;

import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Fenetre_ajout extends Ecran {



    public Fenetre_ajout(int type,int id){

        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));


        name="Fenetre_ajout 1";
        setBackground(Color.pink);


        //---------------------------------------------------


        //-------------------------------------------------------------------------------------------------------------------
        // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
        // -------------------------------------------------------------------------------------------------------------------



        initialisation_formulaire(type,id);

        add(new Bouton("Retour",new Retour()));
    }


    private void initialisation_formulaire(int type,int id)
    {
        switch (type) {
//------------------------------------------------------------------------------------

         case 0://Nouveau Emprunteur
              nouveau_Emprunteur();
             name="nouveau_Emprunteur()";
             break;
            //Nouveau vehicule
         case 1: //Nouveau devis
             name="nouveau_Devis()";
             break;

         case 2:
             name="nouveau_Vehicule()";
             break;
//------------------------------------------------------------------------------------
         case 3:name="afficher_emprunteur_test(id);";

             break;

         case 4:name="afficher_emprunteur_test(id);";
                break;
         case 5:name="afficher_emprunteur_test(id);";
                break;





        }
    }




 private void nouveau_Emprunteur()
 {name="Nouveau Emprunteur";
     initialiser(5,1);
     GridLayout Layout=new GridLayout(7, 1);    Layout.setVgap(10);     setLayout(Layout);

     //ligne 0
     form[0].setTexteString("Nom");         add(form[0]);
     form[1].setTexteString("Prenom");      add(form[1]);
     form[2].setTexteString("Adresse");     add(form[2]);
     form[3].setTexteString("Assurance");   add(form[3]);// =>  JCheckBox premier = new JCheckBox("Nom check box");

     texte[0].setText("");     add(texte[0]);

     add(new Bouton("Validation",new Validation()));
 }


    private void afficher_emprunteur(int Id)
    {   name="afficher_emprunteur Emprunteur";
        add(Gestion_BDD.afficher_utilisateur_console(Id));
    }

    private void afficher_devis(int Id)
    {   name="afficher_devis ";
        add(Gestion_BDD.afficher_Devis_console(Id));
    }

    private void afficher_vehicule(int Id)
    {   name="afficher_vehicule ";
        add(Gestion_BDD.afficher_utilisateur_console(Id));
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

            for(int i=0;i<3;i++) { if(form[i].getContain().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {   texte[0].setText("nouveau user cree");
                    LinkedList<String> text=add(form[0].getContain(),form[1].getContain(),form[2].getContain(),""+form[3].getContain().equals(""),""+0);

                    ajout_Eprunteur(text);
                   // Gestion_BDD. ajout_Eprunteur(LinkedList<String> texte); =>>> a integrer c'est plus reutilisable
                }
            else
                {texte[0].setText("(erreur) pas tous les champ remplie");}
            System.out.println(" confirmation ");
        }
    }


    class Retour implements ActionListener { public void actionPerformed(ActionEvent arg0) {setIsopen(3);}  }


}
