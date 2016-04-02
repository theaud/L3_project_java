package Graphique;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JFrame {

    protected Menu Ecran_menu    =new  Menu();
    protected Ecran Ecran_actif  ;

    public Panneau() {   Ecran_actif = Ecran_menu;

        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));

        this.setTitle(Ecran_actif.getName());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------

        Ecran_menu.setBackground(Color.LIGHT_GRAY);

//--------------------------------------------

        this.setContentPane(Ecran_actif);
        setVisible(true);
    }

    public void changement_Ecran(Ecran nouveau_Ecran)
    {   Ecran_actif=nouveau_Ecran;
        actualisation();
        System.out.println("changement_Ecran        "+Ecran_actif.getName());
    }

    public void retour_Menu()
    {   Ecran_actif=Ecran_menu;
        System.out.println("retour_Menu       "+Ecran_actif.getName());
        actualisation();
    }


    public void actualisation()
    {
        this.setContentPane(Ecran_actif);
        this.setTitle(Ecran_actif.getName());
        repaint();
        revalidate();
    }
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

    public void gestion_fenetre()
    {
        //on reste dans la boucle en permanence , on peut tout de meme quitter le programme par la croix rouge
        while(true)
        {

            switch (getEcran_actif().getIsopen())
            {case 0:retour_Menu();
                //on ferme la fenettre active et on retourne menu
                break;
                case 1://la fenetttre active reste ouverte a l'etat actuel
                    break;
                case 2:break;
                case 3:break;
                default:break;
            }


        }


    }



//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


    public Ecran getEcran_actif() {        return Ecran_actif;    }
    public void setEcran_actif(Ecran ecran_actif) {        Ecran_actif = ecran_actif;    }

    public Menu getEcran_menu() {        return Ecran_menu;    }
    public void setEcran_menu(Menu ecran_menu) {        Ecran_menu = ecran_menu;    }
}
