package Graphique.aidedecision;

import java.util.LinkedList;

/**
 * Created by mathieu on 02/02/2017.
 */
public class Champ {


    public int ID;
    public LinkedList<Integer> valeur=new LinkedList<>();





    public static LinkedList<Champ> genere_champ_dame8()
    {
        LinkedList<Champ> Case=new LinkedList<>();

        int x,y,X,Y;
        for(int j=0;j<64;j++)
        { Case.add(new  Champ());
            Case.get(j).ID=j;
            Case.get(j).valeur=new LinkedList<>();
            Case.get(j).valeur.add(j);
            for(int i=j;i<64;i++)
            {   x=j%8;y=j/8;X=i%8;Y=i/8;


                if(i==j)  {}
                else if(X==x && Y!=y){}
                else if(Y==y && X!=x){}
                else if((X-x)==(Y-y)) { }
                else if((X-x)==(y-Y)){ }
                else  {Case.get(j).valeur.add(i);}

            }
        }

    return Case;


    }

    public  boolean appartient(int champ){ for(int i:valeur){if(champ==i){return true;} } return false;}



    public static void afficher(LinkedList<Champ> Case)
    {
        for (Champ ligne:Case)
        {System.out.print(ligne.ID+" : ");
            for(int valeur:ligne.valeur)
            {System.out.print(valeur+" ");}
            System.out.println();
        }
    }

    public void afficher()
    {

        System.out.print(ID+" : ");
        for (Integer i: valeur)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
