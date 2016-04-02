package Graphique;


import java.awt.*;

public class Lign extends Fenetre {

    public Lign()
    {
        dim=new Dimension(500,30);
    }



    public static  Lign[] assemblage_ligne(int size)
    { Lign[] lign     =new Lign[size];
        for(int i=0;i<size;i++)
        {lign[i]=new Lign();
         lign[i].setPreferredSize(new Dimension(500, 30));

        }
        return lign;
    }







}
