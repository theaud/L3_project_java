package Graphique.aidedecision;

import java.util.LinkedList;

/**
 * Created by mathieu on 02/02/2017.
 */
public class Champ {

    public String Type;
    public int ID;
    public LinkedList<Integer> valeur=new LinkedList<>();


    public void afficher()
    {
        System.out.print(Type+" ");
        System.out.print(ID+" : ");
        for (Integer i: valeur)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
