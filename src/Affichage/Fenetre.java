package Affichage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Fenetre extends JPanel {

    Fenetre()
    {

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


    public static  Fenetre[] Tableau_Fenetre(int size)
    { Fenetre[] lign     =new Fenetre[size];
        for(int i=0;i<size;i++)
        {lign[i]=new Fenetre();

        }
        return lign;
    }



    public void add(Fenetre[] list,Dimension dim,int size)
    {
        for(int i=0;i<size;i++)
        {list[i].setPreferredSize(dim);
         add(list[i]);
        }

    }
    public static Fenetre[] setsize(Fenetre[]list , Dimension dim,int size)
    {
        for(int i=0;i<4;i++)
        {list[i].setPreferredSize(dim);}
        return list;
    }



}
