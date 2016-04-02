package Graphique;

import Affichage.Form;
import Graphique.*;

import javax.swing.*;
import java.awt.*;


public class Menu extends Ecran {





    public  Menu()
    {//----------------------------Creation de la fenetre global ---------------------------------------------------------

        name="Menu initialiser";
        setBackground(Color.WHITE);


        //---------------------------------------------------


        //-------------------------------------------------------------------------------------------------------------------
        // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
        // -------------------------------------------------------------------------------------------------------------------

          initialisation();


    }



    private void initialisation()
    {bouton    =Bouton.Tableau_Bouton(10);
        form      = Form.Tableau_Form(10);
        texte     = Fenetre.Tableau_JLabel(10);
        lign      =Lign.assemblage_ligne(10);

        for(int i=0;i<10;i++)
        {   texte[i].setText("Yolo 3"+i);
            lign[i].setSize(500,33);


            lign[i].add(texte[i]);

            lign[i].setBackground(Color.lightGray);
           // add(lign[i]);
            add(texte[i]);

        }



    }





}
