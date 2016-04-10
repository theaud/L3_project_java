package Graphique;

import Affichage.*;
import BDD.Gestion_BDD;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JFrame {

    protected Affichage.Menu Ecran_menu    =new Affichage.Menu();
    protected Ecran Ecran_actif  ;

    public Panneau() {   Ecran_actif = Ecran_menu;

        this.setSize(1000, 1000);
        setMinimumSize(new Dimension(1000, 1000));

        this.setTitle(Ecran_actif.getName());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------

        Ecran_menu.setBackground(Color.LIGHT_GRAY);

//--------------------------------------------
        changement_Ecran(new Login());//on se place a la connection sur la page login

        this.setContentPane(Ecran_actif);
        setVisible(true);
    }

    public void changement_Ecran(Ecran nouveau_Ecran)
    {   Ecran_actif=nouveau_Ecran;
        actualisation();
        System.out.println("changement_Ecran        "+Ecran_actif.getName());
    }

    public void retour_Menu()
    {   Ecran_actif=Ecran_menu; getEcran_actif().setIsopen(0);
        System.out.println("retour_Menu       "+Ecran_actif.getName());
        actualisation();
    }


    public void actualisation()
    {   stopIsopen();
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
            {case 1:getEcran_actif().setIsopen(1);stopIsopen();
                    retour_Menu();                   //retour menu   0
                break;
            case 2: getEcran_actif().setIsopen(1);stopIsopen();
                    changement_Ecran(new Login());  //deconnection  1

                break;
            case 3: System.out.println("bouton nom");stopIsopen();
                break;
            case 4: System.out.println("bouton id");stopIsopen();
                break;
            case 5: System.out.println("(bouton vehicule)=test");
                changement_Ecran(new Fenetre_ajout(0));
                stopIsopen();
                break;
            case 6:   Ecran test=new Fenetre_ajout(3);
                         changement_Ecran(test);

                System.out.println("bouton location");stopIsopen();
                break;
            case 7:stopIsopen();
                break;
            default:break;
            }
        }
    }






//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


    public Ecran getEcran_actif() {        return Ecran_actif;    }
    public void setEcran_actif(Ecran ecran_actif) {        Ecran_actif = ecran_actif;    }

    public Affichage.Menu getEcran_menu() {        return Ecran_menu;    }
    public void setEcran_menu(Affichage.Menu ecran_menu) {        Ecran_menu = ecran_menu;    }

    public void stopIsopen(){Ecran_actif.isopen=0;}


}
