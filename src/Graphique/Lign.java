package Graphique;


import java.awt.*;

public class Lign extends Fenetre {

    public Lign()
    {
        dim=new Dimension(10000,30);
    }



    public static  Lign[] assemblage_ligne(int size)
    { Lign[] lign     =new Lign[size];
        for(int i=0;i<size;i++)
        {lign[i]=new Lign();
         lign[i].setPreferredSize(new Dimension(5000, 30));

        }
        return lign;
    }

    public static  Lign[] assemblage_ligne(Lign[] lign,int size,int height)
    {
        for(int i=0;i<size;i++)
        {lign[i].setPreferredSize(new Dimension(5000, height));}
        return lign;
    }







}
