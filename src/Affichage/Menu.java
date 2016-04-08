package Affichage;

import Graphique.Ecran;

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

        initialiser(5,2,2,6);

        initialisation_menu();
    }



    private void initialisation_menu()
    {


//----------------------------------------------------------------------------------------------------

        //ligne 0

        texte[0].setText("Menu");
        lign[0].add(texte[0]);

        //ligne 1
        texte[1].setText("Client");
        lign[1].add(texte[1]);

        //ligne 2
        form[0].setTexteString("Nom");
        bouton[0].setBouton("Connection nom", new Pression());
        //lign[2].add(texte[2],form[0],bouton[0]);texte[2],

        lign[2].add(form[0],bouton[0]);


        //ligne 3
        form[1].setTexteString("ID");
        bouton[1].setBouton("Connection Id", new Pression());
      //  texte[3]
       lign[3].add(form[1],bouton[1]);


        //ligne 4
        bouton[2].setBouton("Location", new Pression());
        lign[4].add(bouton[2]);

        //-------
        bouton[3].setBouton("Retour vehicule", new Pression());
        lign[4].add(bouton[3]);

        //ligne 5
        bouton[4].setBouton("Deconnection", new Pression());
        lign[5].add(bouton[4]);

        //on met les differentes lignes dans la fenetre
        add(lign,6);


    }

    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {String press=arg0.getActionCommand();
            if     (press.equals("Connection nom"))            {setIsopen(3);}
            else if(press.equals("Connection Id"))  {setIsopen(4);}
            else if(press.equals("Retour vehicule")){setIsopen(5);}
            else if(press.equals("Location"))       {setIsopen(6);}
            else if(press.equals("Deconnection"))   {setIsopen(2);}
        }
    }



}
