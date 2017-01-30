package Graphique.Jpanel;

import Graphique.aide.Form;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class Fenetre extends JPanel {

    protected LinkedList<Form> form= new LinkedList<>();
    protected LinkedList<JLabel> texte= new LinkedList<>();
    protected Dimension dim=new Dimension(500,500);
    protected static int compteur=0;
    protected String name="Fenetre autogeneration"+(compteur++);


    protected int isopen=0;

    public Fenetre(){
        setSize(dim);


    }

    public Fenetre(Color color){
       // name="Fenetre autogeneration"+(compteur++);
        setBackground(color);setSize(dim);


    }




    public void add(Fenetre[] list,int size)
    {
    for(int i=0;i<size;i++)
        {add(list[i]);}
    }


    public void setConfig(Color color,java.awt.GridBagLayout layout)
    {
        setBackground(color);
        setLayout(layout);
    }


    public static  JLabel[] Tableau_JLabel(int size)
    { JLabel[] label     =new JLabel[size];
        for(int i=0;i<size;i++)
        {label[i]=new JLabel();}
        return label;
    }

//----------------------------------------------------------------------------------------------------------------
//------------------------------------- Getter setter   ----------------------------------------------------------
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

    public int getIsopen() {return isopen;}
    public void setIsopen(int Isopen) {this.isopen = Isopen;}
    /** use to change the current window     */
    public void stopIsopen(){this.isopen=0;}

    public void add(Form formulaire) { add(formulaire.getOnPanel());}

}
