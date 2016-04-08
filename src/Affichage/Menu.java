package Affichage;

import Graphique.Ecran;
import Graphique.Fenetre;
import Graphique.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends Ecran {





    public  Menu()
    {//----------------------------Creation de la fenetre global ---------------------------------------------------------
        name="Menu initialiser";
        setBackground(Color.green);

        //---------------------
        JPanel Panneau = new JPanel();
        Panneau.setPreferredSize(new Dimension(1000, 1000));
        Panneau.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        initialiser(5,2,2);

        setBackground(Color.red);
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        Panneau.add(initialisation_top(), gbc);
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        Panneau. add(Center(), gbc);
        //---------------------------------------------

        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        Panneau.add(initialisation_bot(), gbc);
        //---------------------------------------------

        add(Panneau);
    }


    private Fenetre Center()
    {
        Fenetre Center =new Fenetre();
        Center.setPreferredSize(new Dimension(950, 750));
        Center.setLayout(new GridLayout(1, 2));
        Center.add(initialisation_menu_recherche());
        Center.add(initialisation_menu_creation());

        return(Center);
    }

    private Fenetre initialisation_menu_recherche()
    {
        Fenetre container1 =new Fenetre();
        container1.setLayout(new GridLayout(10, 1));
        container1.setBackground(Color.cyan);
        container1.add(new JLabel("Recherche"));


        //ligne 1
        texte[1].setText("Client");
        container1.add(texte[1]);

        //ligne 2
        form[0].setTexteString("Nom");
        bouton[0].setBouton("Connection nom", new Pression());
        form[0].addBouton(bouton[0]);
        container1.add(form[0].getOnPanel());

        //ligne 3
        form[1].setTexteString("ID");
        bouton[1].setBouton("Connection Id", new Pression());
        form[1].addBouton(bouton[1]);
        // ,bouton[1]
        container1.add(form[1].getOnPanel());

        container1.add(new Form().getOnPanel());
        container1.add(new Form().getOnPanel());
        container1.add(new Form().getOnPanel());
        container1.add(new Form().getOnPanel());
        container1.add(new Form().getOnPanel());

        return(container1);
    }

    private Fenetre initialisation_menu_creation()
    {
        Fenetre container1 =new Fenetre();

        container1.setLayout(new GridLayout(10, 1));
        container1.setBackground(Color.red);
        container1.add(new JLabel("Ajout"));

        //ligne 4
        bouton[2].setBouton("Location", new Pression());
        container1.add(bouton[2]);

        //-------
        bouton[3].setBouton("Retour vehicule", new Pression());
        container1.add(bouton[3]);

        return(container1);
    }
    private Fenetre initialisation_top()
    {   Fenetre Top =new Fenetre();
        Top.setPreferredSize(new Dimension(1000, 100));
        texte[0].setText("Menu");
        Top.add(texte[0]);
        Top.setBackground(Color.orange);
        return (Top);
    }


    private Fenetre initialisation_bot()
    {   Fenetre bottom =new Fenetre();
        bottom.setPreferredSize(new Dimension(1000, 100));
        bottom.setBackground(Color.BLACK);
        bouton[4].setBouton("Deconnection", new Pression());
        bottom.add(bouton[4]);
        return(bottom);
    }



    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {String press=arg0.getActionCommand();
            if     (press.equals("Connection nom")) {setIsopen(3);}
            else if(press.equals("Connection Id"))  {setIsopen(4);}
            else if(press.equals("Retour vehicule")){setIsopen(5);}
            else if(press.equals("Location"))       {setIsopen(6);}
            else if(press.equals("Deconnection"))   {setIsopen(2);}
        }
    }



}
