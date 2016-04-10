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
        System.out.println("§§§ =>Changement_Ecran        "+Ecran_actif.getName());
    }

    public void retour_Menu()
    {   Ecran_actif=Ecran_menu; getEcran_actif().setIsopen(0);
        System.out.println("§§§ =>retour_Menu       "+Ecran_actif.getName());
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

            if(getEcran_actif().getIsopen()!=0){
                System.out.println("valeur =" +getEcran_actif().getIsopen());
            }
            switch (getEcran_actif().getIsopen())
            {case 0://No move
                break;

            case 2://Login
                System.out.println("Login");
                getEcran_actif().setIsopen(3);stopIsopen();
                changement_Ecran(new Login());
                break;
            case 3://Menu
                System.out.println("Menu");
                getEcran_actif().setIsopen(2);stopIsopen();
                retour_Menu();
                break;
            case 4://Emprunteur
                stopIsopen();
                    break;
            case 5://Devis
                System.out.println("Devis");
                changement_Ecran(new Fenetre_ajout(2,2));// a verif si au bon endroit 2,2 mauvais
                stopIsopen();
                    break;
            case 6://Vehicule
                stopIsopen();
                    break;
            case 7://Catalogue
                stopIsopen();
                    break;
            case 8://Formulmaire Emprunteur
                Ecran test=new Fenetre_ajout(1,2);// a verif si au bon endroit
                changement_Ecran(test);
                System.out.println("bouton location");
                stopIsopen();
                    break;
            case 9://Formulmaire Vehicule
                stopIsopen();
                    break;
            case 10://Formulmaire Devis
                stopIsopen();
                    break;
                default:  System.out.println("default");  stopIsopen();
                    break;
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
