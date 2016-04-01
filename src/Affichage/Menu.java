package Affichage;

import Graphique.Bouton;
import Graphique.Fenetre;
import Graphique.Lign;
import Graphique.Panneau;

import javax.swing.*;
import java.awt.*;


public class Menu extends Panneau {






    public Menu()
    { //----------------------------Creation de la fenetre global ---------------------------------------------------------






    //---------------------------------------------------
        bouton    =Bouton.Tableau_Bouton(10);
        form      =Form.Tableau_Form(10);
        texte     = Fenetre.Tableau_JLabel(10);
        lign      =Lign.assemblage_ligne(10);

   //-------------------------------------------------------------------------------------------------------------------
   // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
   // -------------------------------------------------------------------------------------------------------------------
        Creation_menu();
        retour_Menu();

    }





    private void Creation_menu()
    {
        for(int i=0;i<10;i++)
        {   texte[i].setText("Yolo "+i);
            lign[i].setSize(getWidth(),33);

            lign[i].add(texte[i]);

            lign[i].setBackground(Color.lightGray);
            Fenetre_menu.add(lign[i]);
        }
    }
}
