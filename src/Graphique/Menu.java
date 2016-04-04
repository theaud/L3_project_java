package Graphique;

import Affichage.Form;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends Ecran {





    public  Menu()
    {//----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));


        name="Menu initialiser";
        setBackground(Color.WHITE);


        //---------------------------------------------------


        //-------------------------------------------------------------------------------------------------------------------
        // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
        // -------------------------------------------------------------------------------------------------------------------

        initialiser(5,2,4,6);

        initialisation_menu();
    }



    private void initialisation_menu()
    {int largeur=500;

        for(int i=0;i<2;i++) {  form[i].setPreferredSize(new Dimension(largeur/4, 30));}

//----------------------------------------------------------------------------------------------------

        //ligne 0
        texte[0].setText("Menu");
        lign[0].add(texte[0]);

        //ligne 1
        texte[1].setText("Client");
        lign[1].add(texte[1]);

        //ligne 2
        texte[2].setText("Nom");
        lign[2].add(texte[2]);

        lign[2].add(form[0]);

        bouton[0].setName("Connection nom");
        bouton[0].setText("Nom");
        bouton[0].setPreferredSize(new Dimension(largeur/3, 30));
        bouton[0].addActionListener(new Pression());
        lign[2].add(bouton[0]);

        //ligne 3
        texte[3].setText("ID");
        lign[3].add(texte[3]);

        lign[3].add(form[1]);

        bouton[1].setName("Connection Id");
        bouton[1].setText("Id");
        bouton[1].setPreferredSize(new Dimension(largeur/3, 30));
        bouton[1].addActionListener(new Pression());
        lign[3].add(bouton[1]);


        //ligne 4
        bouton[2].setName("Location");
        bouton[2].setText("Location");
        bouton[2].setPreferredSize(new Dimension(largeur/3, 30));
        bouton[2].addActionListener(new Pression());
        lign[4].add(bouton[2]);

        bouton[3].setName("Retour vehicule");
        bouton[3].setText("vehicule");
        bouton[3].setPreferredSize(new Dimension(largeur/3, 30));
        bouton[3].addActionListener(new Pression());
        lign[4].add(bouton[3]);

        //ligne 5

        bouton[4].setName("Deconnection");
        bouton[4].setText("Deconnection");
        bouton[4].setPreferredSize(new Dimension(largeur/3, 30));
        bouton[4].addActionListener(new Pression());
        lign[5].add(bouton[4]);





//----------------------------------------------------------------------------------------------------
            for(int i=0;i<6;i++) {add(lign[i]);}




    }

    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {String press=arg0.getActionCommand();
            if     (press.equals("Nom"))         {setIsopen(2);}
            else if(press.equals("Id"))          {setIsopen(3);}
            else if(press.equals("vehicule"))    {setIsopen(4);}
            else if(press.equals("Location"))    {setIsopen(5);}
            else if(press.equals("Deconnection")){setIsopen(1);}
        }
    }



}
