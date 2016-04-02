package Graphique;

import Affichage.Form;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends Ecran {





    public  Menu()
    {//----------------------------Creation de la fenetre global ---------------------------------------------------------

        name="Menu initialiser";
        setBackground(Color.WHITE);


        //---------------------------------------------------


        //-------------------------------------------------------------------------------------------------------------------
        // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
        // -------------------------------------------------------------------------------------------------------------------

        initialiser(10,10,10,10);

        initialisation_menu();
    }



    private void initialisation_menu()
    {int largeur=500;

        for(int i=0;i<10;i++) {  form[i].setPreferredSize(new Dimension(largeur/4, 30));}

//----------------------------------------------------------------------------------------------------
        //ligne 0
        for(int i=0;i<10;i++)
        {   texte[i].setText("Ligne 1 blabla");
            lign[i].add(texte[i]);

            lign[i].add(form[i]);

            bouton[i].setName("Je met un texte "+i);
            bouton[i].setText(""+i);
            bouton[i].setPreferredSize(new Dimension(largeur/3, 30));
            bouton[i].addActionListener(new Pression());
            lign[i].add(bouton[i]);
        }





//----------------------------------------------------------------------------------------------------
            for(int i=0;i<10;i++) {add(lign[i]);}




    }

    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

                System.out.println(arg0);


        }
    }



}
