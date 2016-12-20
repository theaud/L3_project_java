package Graphique.general;

import Graphique.aide.Form;

import javax.swing.*;
import java.awt.*;


public class Fenetre extends JPanel {

    protected Dimension dim;
    protected String name;
    protected static int compteur=0;
    protected int isopen=0;

    public Fenetre(){
        name="fenetre initialiser";

        name=""+compteur;
        compteur++;
    }

    public Fenetre(Color color){
    setBackground(color);
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
    public void setIsopen(int Isopen) {        this.isopen = Isopen;    }
    public void stopIsopen(){this.isopen=0;}

    public void add(Form formulaire)                { add(formulaire.getOnPanel());}

}
