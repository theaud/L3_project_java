package Graphique;

import Affichage.Form;

import javax.swing.*;
import java.awt.*;

public class Panneau extends Fenetre {


    protected Fenetre Fenetre_menu    =new Fenetre();
    protected Fenetre Fenetre_active  ;

    protected String name;
    protected static int compteur=0;

    protected Bouton[] bouton    ;
    protected Form[]   form      ;
    protected JLabel[] texte    ;
    protected Lign[] lign        ;





    public Panneau()
    {

        this.setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));


        System.out.println(compteur);
        name="Fenetre "+compteur;
        compteur++;
    }

    public Panneau(String Name)
    {name=Name;

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


    public void actualisation()
    {System.out.println("Actualisation");
        System.out.println(Fenetre_active.getName());


        this.setVisible(true);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



}
