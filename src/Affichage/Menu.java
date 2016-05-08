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
        initialiser(4,0);

        setBackground(Color.red);
        setLayout(new BorderLayout());




        //haut ------------------------------------------------------------------v
        add(new JLabel("Menu"),BorderLayout.NORTH);



        //gauche -----------------------------------------------------------------------------
        Ecran centre=new Ecran();
        centre.setLayout( new GridLayout(1,2));
        add(centre,BorderLayout.CENTER);

        Ecran gauche=new Ecran();
        gauche.setLayout( new GridLayout(6,1));
            gauche.add(new JLabel("Recherche"));

            form[0].setTexteString("Emprunteur ID");
            form[0].addBouton(new Bouton("Validation 0", new Validation()));
            gauche.add(form[0].getOnPanel());

            form[1].setTexteString("Devis ID");
            form[1].addBouton(new Bouton("Validation 1", new Validation()));
            gauche.add(form[1].getOnPanel());

            form[2].setTexteString("Vehicule ID");
            form[2].addBouton(new Bouton("Validation 2", new Validation()));
            gauche.add(form[2].getOnPanel());



            gauche.add(new Bouton("Voir le Catalogue", new Pression()));
            gauche.add(new Bouton("Retour Vehicule", new Pression()));
        centre.add(gauche);

        //droite ---------------------------------------------------------------------------------------------------
        Ecran droite=new Ecran();
         droite.setLayout( new GridLayout(4,1));
            droite.add(new JLabel("Nouveau"));

            droite.add(new Bouton("Nouveau Emprunteur", new Pression()));
            droite.add(new Bouton("Nouveau devis", new Pression()));
            droite.add(new Bouton("Nouveau Vehicule", new Pression()));

        centre.add(droite);

        //bas ---------------------------------------------------------------------------------------------------

        add(new Bouton("Deconnection", new Pression()),BorderLayout.SOUTH);


    }





class Pression implements ActionListener {
    public void actionPerformed(ActionEvent arg0)
    {String press=arg0.getActionCommand();
    if      (press.equals("Emprunteur ID"))      {setIsopen(4);id=Integer.parseInt("0"+form[0].getContain());}
    else if(press.equals("Devis ID"))           {setIsopen(5);id=Integer.parseInt("0"+form[1].getContain());}
    else if(press.equals("Vehicule ID"))        {setIsopen(6);id=Integer.parseInt("0"+form[2].getContain());}

    else if(press.equals("Voir le Catalogue"))  {setIsopen(7);}
    else if(press.equals("Retour Vehicule"))    {setIsopen(11);}

    else if(press.equals("Nouveau Emprunteur")) {setIsopen(8);}
    else if(press.equals("Nouveau devis"))       {setIsopen(9);}
    else if(press.equals("Nouveau Vehicule"))    {setIsopen(10);}

     else if(press.equals("Deconnection"))   {setIsopen(2);}
        }
    }
    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {

            String chemin="";
            int test=0;
            String press=arg0.getActionCommand();
            if     (press.equals("Validation 0")) {chemin="./src/BDD/Emprunteur/";test=4;}
            else if(press.equals("Validation 1")) {chemin="./src/BDD/Devis/";     test=5;}
            else if(press.equals("Validation 2")) {chemin="./src/BDD/Vehicule/";  test=6;}
            else {JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "§§ WARNING §§ Erreur Menu validation :|"+press+"| "+press.equals("Validation 0"), "Erreur", JOptionPane.ERROR_MESSAGE);
                return;}

            int  id=Integer.parseInt("0"+form[test-4].getContain());


            if(test!=0  && Gestion_BDD.existe( chemin, id) )
            {   texte.setText("22");
                 Gestion_BDD.afficher(chemin,Integer.parseInt( form[test-4].getContain()));

                setIsopen(test);
            }
            else
            {texte.setText("L'entree selectionnee est incorrecte ou n'a pas ete trouvee dans la base de donnees ");}


        }
    }
//-----------------------------------------------------------------------------------------------------------------------
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
