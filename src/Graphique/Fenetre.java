package Graphique;

import javax.swing.*;
import java.awt.*;


public class Fenetre extends JPanel {





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
