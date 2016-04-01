package Affichage;

import Graphique.Bouton;
import Graphique.Fenetre;
import Graphique.Lign;
import Graphique.Panneau;

import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame {

    private static final int Width=500;
    private static final int Height=500;

    private Panneau Fenetre_menu    =new Panneau("Menu");
    private Panneau Fenetre_active  ;

    private Bouton[]  bouton    =Bouton.Tableau_Bouton(10);
    private Form[]    form      =Form.Tableau_Form(10);
    private JLabel[]  texte     = Fenetre.Tableau_JLabel(10);
    private Lign[] lign      =Lign.assemblage_ligne(10);

    public Menu()
    { //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setSize(Width, Height);
        setMinimumSize(new Dimension(Width, Height));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   //-------------------------------------------------------------------------------------------------------------------
   // --------------------------       on cree et on se place sur le menu  ---------------------------------------------
   // -------------------------------------------------------------------------------------------------------------------
        Creation_menu();
        retour_Menu();

    }

    public void actualisation()
    {System.out.println("Actualisation");
     System.out.println(Fenetre_active.getName());
        this.setTitle(Fenetre_active.getName());
        this.setContentPane(Fenetre_active);
        this.setVisible(true);
    }


    public void changement_fenetre(Panneau nouvelle_fenettre)
    {
        Fenetre_active=nouvelle_fenettre;
        actualisation();

    }

    public void retour_Menu()
    {
        Fenetre_active=Fenetre_menu;
        actualisation();
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
