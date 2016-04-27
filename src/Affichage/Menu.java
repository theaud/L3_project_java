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
        JPanel Panneau = new JPanel();
        Panneau.setPreferredSize(new Dimension(1000, 1000));
        Panneau.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();

        initialiser(4,0);

        setBackground(Color.red);
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        Panneau.add(initialisation_top(), gbc);
        //---------------------------------------------
        gbc.gridy = 1;
        gbc.gridheight = 0;
        Panneau. add(Center(), gbc);
        //---------------------------------------------

        //---------------------------------------------

        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        Panneau.add(initialisation_bot(), gbc);
        //---------------------------------------------

        add(Panneau);
    }


    private Fenetre Center()
    {   Ecran Center =new Ecran();
        Center.setPreferredSize(new Dimension(950, 750));
        Center.setLayout(new GridLayout(1, 0));
        Center.add(initialisation_menu_recherche());
        Center.add(initialisation_menu_creation());

        return(Center);
    }

    private Fenetre initialisation_menu_recherche()
    {        Fenetre container1 =new Fenetre();

        container1.setLayout(new GridLayout(10, 1));
        container1.setBackground(Color.cyan);
        container1.add(new JLabel("Recherche"));

        //ligne 1
        form[0].setTexteString("Emprunteur ID");
        form[0].addBouton(new Bouton("Validation 1", new Validation()));
        container1.add(form[0].getOnPanel());

        //ligne 0
        form[1].setTexteString("Devis ID");
        form[1].addBouton(new Bouton("Validation 0", new Validation()));
        container1.add(form[1].getOnPanel());

        //ligne 3.1
        form[2].setTexteString("Vehicule ID");
        form[2].addBouton(new Bouton("Validation 3", new Validation()));
        container1.add(form[2].getOnPanel());


        texte.setText("");
        container1.add(texte);

        //ligne 4
        container1.add(new Bouton("Voir le Catalogue", new Pression()));

        //ligne 5
        container1.add(new Bouton("Retour Vehicule", new Pression()));
        return(container1);
    }

    private Fenetre initialisation_menu_creation()
    {
        Fenetre container1 =new Fenetre();
        container1.setLayout(new GridLayout(10, 1));
        container1.setBackground(Color.red);

        container1.add(new JLabel("Nouveau"));

        container1.add(new Bouton("Nouveau Emprunteur", new Pression()));
        container1.add(new Bouton("Nouveau devis", new Pression()));
        container1.add(new Bouton("Nouveau Vehicule", new Pression()));

        return(container1);
    }

    private Fenetre initialisation_top()
    {   Fenetre Top =new Fenetre();
        Top.setPreferredSize(new Dimension(1000, 100));
        setName("Menu");

        Top.setBackground(Color.orange);
        return (Top);
    }
    private Fenetre initialisation_bot()
    {   Fenetre bottom =new Fenetre();
        bottom.setPreferredSize(new Dimension(1000, 100));
        bottom.setBackground(Color.BLACK);


        bottom.add(new Bouton("Deconnection", new Pression()));
        return(bottom);
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


            else if(press.equals("Deconnection"))   {setIsopen(0);}
        }
    }
    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {System.out.println("\npression validation");

            String chemin="";
            int test=0;
            String press=arg0.getActionCommand();
            if     (press.equals("Validation 1")) {chemin="./src/BDD/Emprunteur/";test=4;}
            else if(press.equals("Validation 0")) {chemin="./src/BDD/Devis/";     test=5;}
            else if(press.equals("Validation 3")) {chemin="./src/BDD/Vehicule/";  test=6;}
            else {System.out.println("Erreur Menu validation");}

            int  id=Integer.parseInt("0"+form[test-4].getContain());
            System.out.println("chemin ="+chemin+" id= "+id);
            System.out.println(Gestion_BDD.existe( chemin, id));

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
