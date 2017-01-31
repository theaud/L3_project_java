package Graphique;

import java.util.LinkedList;

/**
 * Created by mathieu on 31/01/2017.
 */
public class arbreSolution {

   // public LinkedList<Integer> precedent;
    public int profondeur;
    public LinkedList<arbreSolution> suivant=new LinkedList<>();
    public int Valeur;




    public arbreSolution(int valeur,int profondeur)
    { Valeur=valeur;
        for(int i=0;i<5;i++)
        {
            if(profondeur<5)
            { suivant.add(new arbreSolution(i,++profondeur));}
            else
            {

              //  System.out.print(Valeur);

            }
        }



    }


    public void afficher(int profondeur,int max)
    {System.out.println("suivant size ="+suivant.size()+" profondeur"+profondeur);
        for (arbreSolution fille:  suivant)
        {
            if(profondeur==max)
            {
                System.out.print(fille.Valeur);
            }else
            {
                fille.afficher(++profondeur,max);
            }
            System.out.println();

        }



    }



    //----------------------------------------

    public boolean diponible(LinkedList<Integer> solution,int position)
    {int X,Y,x,y;
        X=position%8;
        Y=position/8;
        for(int i=0;i<solution.size();i++)
        { x=solution.get(i)%8;
            y=solution.get(i)/8;


            if(position==solution.get(i)){return false;}
            else if(X==x && Y!=y)  {return false;}
            else if(Y==y && X!=x)        {return false;}
            else if((X-x)==(Y-y))       {return false;}
            else if((X-x)==(y-Y))     {return false;}

        }



        return true;
    }
}
