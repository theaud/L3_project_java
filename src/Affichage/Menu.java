package Affichage;

import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;
import Graphique.Fenetre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Ecran {

    protected int id=1;
    protected JLabel texte=new JLabel();

    public  Menu()
    {//----------------------------Creation de la fenetre global ---------------------------------------------------------
        name="Menu initialiser";
        setBackground(Color.green);

        //---------------------
        setLayout(new GridLayout(11, 0));



        initialiser(4,0);

        setBackground(Color.red);


        Ecran[] liste =new Ecran[11];
        for(int i=0;i<11;i++){
            liste[i]=new Ecran();
            if(i!=0 &&i!=10){
                liste[i].setLayout(new GridLayout(0, 2));
                liste[i].setBackground(Color.orange);
                 }
            add(liste[i]);
        }



        //ligne 0
        liste[0].add(new JLabel("Menu"));


        //ligne 1

        liste[1].add(new JLabel("Recherche"));
         liste[1].add(new JLabel("Nouveau"));

        //ligne 2
        form[0].setTexteString("Emprunteur ID");
        form[0].addBouton(new Bouton("Validation 0", new Validation()));
        liste[2].add(form[0].getOnPanel());


        //ligne 3
        form[1].setTexteString("Devis ID");
        form[1].addBouton(new Bouton("Validation 1", new Validation()));
        liste[3].add(form[1].getOnPanel());

        liste[3].add(new Bouton("Nouveau Emprunteur", new Pression()));
        //ligne 4
        form[2].setTexteString("Vehicule ID");
        form[2].addBouton(new Bouton("Validation 2", new Validation()));
        liste[4].add(form[2].getOnPanel());


        //ligne 5

        texte.setText("");
        liste[5].add(texte);
        liste[5].add(new Bouton("Nouveau devis", new Pression()));
        //ligne 6
        liste[6].add(new Bouton("Voir le Catalogue", new Pression()));


        //ligne 7
        liste[7].add(new Ecran());

        liste[7].add(new Bouton("Nouveau Vehicule", new Pression()));
        //ligne 8
        liste[8].add(new Bouton("Retour Vehicule", new Pression()));

        //ligne 9

        //ligne 10
        liste[10].add(new Bouton("Deconnection", new Pression()));


    }






class Pression implements ActionListener {
    public void actionPerformed(ActionEvent arg0)
    {String press=arg0.getActionCommand();
    if      (press.equals("Emprunteur ID"))      {setIsopen(4);id=Integer.parseInt("0"+form[0].getContain());}
    else if(press.equals("Devis ID"))           {setIsopen(5);id=Integer.parseInt("0"+form[1].getContain());}
    else if(press.equals("Vehicule ID"))        {setIsopen(6);id=Integer.parseInt("0"+form[0].getContain());}

    else if(press.equals("Voir le Catalogue"))  {setIsopen(7);}
    else if(press.equals("Retour Vehicule"))    {System.out.println("Retour Vehicule a ajouter");}

    else if(press.equals("Nouveau Emprunteur")) {setIsopen(8);  System.out.println("Pression effectuer "+press);
            }
            else if(press.equals("Nouveau devis"))       {setIsopen(9);}
            else if(press.equals("Nouveau Vehicule"))    {setIsopen(10);}


            else if(press.equals("Deconnection"))   {setIsopen(2);}
        }
    }
    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {System.out.println("\npression validation");

            String chemin="";
            int test=0;
            String press=arg0.getActionCommand();
            if     (press.equals("Validation 0")) {chemin="./src/BDD/Emprunteur/";test=4;}
            else if(press.equals("Validation 1")) {chemin="./src/BDD/Devis/";     test=5;}
            else if(press.equals("Validation 2")) {chemin="./src/BDD/Vehicule/";  test=6;}
            else {System.out.println("§§ WARNING §§ Erreur Menu validation :|"+press+"| "+press.equals("Validation 0"));return;}

            int  id=Integer.parseInt("0"+form[test-4].getContain());


            if(test!=0  && Gestion_BDD.existe( chemin, id) )
            {   texte.setText("22");
                 Gestion_BDD.afficher(chemin,Integer.parseInt( form[test-4].getContain()));

                setIsopen(test);
            }
            else
            {texte.setText("L'entrer selectionner est incorecte où n'a pas ete trouver dans la bese de donnee ");}


        }
    }
//-----------------------------------------------------------------------------------------------------------------------
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
