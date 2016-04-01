package Graphique;


public class Lign extends Fenetre {

    public Lign()
    {

    }



    public static  Lign[] assemblage_ligne(int size)
    { Lign[] lign     =new Lign[size];
        for(int i=0;i<size;i++)
        {lign[i]=new Lign();

        }
        return lign;
    }







}
