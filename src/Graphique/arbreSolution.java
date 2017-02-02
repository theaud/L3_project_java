package Graphique;

import java.util.LinkedList;

/**
 * Created by mathieu on 31/01/2017.
 */
public class arbreSolution {

    public LinkedList<Integer> solution=new LinkedList<>();

    public int curseur=8;

    public static int profondeurMax=3;



    public arbreSolution()
    {// faire des test en arbre , si aucune erreur jusqu'a un point continuer si erreur remonter
        for(int i=0;i<8;i++){solution.add(1);}
    }


    public boolean resolution()
    {
        int pronfondeur=0;
        while(diponible(solution,0)==false && solution.get(0)<36)
        {



            solution.set(0,solution.get(0)+1);
        }


        afficher_solution();


    if(diponible(solution,8))
    {System.out.println(" Correct");
        afficher_solution();
    }


        return false;
    }


    public  void afficher_solution()
    {System.out.println();
        for (int valeur:solution) {
            System.out.print(valeur+" ");

        }
        System.out.println();
    }


    public boolean test()
    {
        if(solution.size()==8)
        {
            for(int valeur:solution)
            {
                if(valeur%2==1)
                {return false; }

            }
            return true;
        }
     return false;
    }

    //----------------------------------------

    public boolean diponible(LinkedList<Integer> solution,int position)
    {

        int X,Y,x,y;
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


    public static void bourin()
    {

    }
}
