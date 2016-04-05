package Graphique;

import Affichage.Form;

import javax.swing.*;
import java.awt.*;


public class Fenetre extends JPanel {

    protected Dimension dim;
    protected String name;
    protected static int compteur=0;

    protected int isopen=0;

    public Fenetre(){
        name="fenetre initialiser";







        //----------- detail ---------------------
        name=""+compteur;
        compteur++;
    }



    public void add(Fenetre[] list,int size)
    {
    for(int i=0;i<size;i++)
        {add(list[i]);}

    }



    public static  JLabel[] Tableau_JLabel(int size)
    { JLabel[] label     =new JLabel[size];
        for(int i=0;i<size;i++)
        {label[i]=new JLabel();}
        return label;
    }

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public Dimension getDim() {   return dim;    }
    public void setDim(Dimension dim) {        this.dim = dim;    }

    public static int getCompteur() {        return compteur;    }
    public static void setCompteur(int compteur) {        Fenetre.compteur = compteur;    }

    public int getIsopen() {return isopen;    }
    public void setIsopen(int isopen) {        this.isopen = isopen;    }
    public void stopIsopen(){this.isopen=0;}



    public void add(JLabel text,Form formulaire)                {add(text); add(formulaire);}
    public void add(JLabel text,Form formulaire,Bouton bouton)  {add(text); add(formulaire);    add(bouton);}




}
