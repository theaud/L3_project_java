
import Graphique.Panneau;
import util3.Temp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


        Panneau Panneau=new Panneau();
        //boucle principale
        Panneau.gestion_fenetre();

    }







    public static void wait(int a)
    {

        long start=System.nanoTime();

        while((System.nanoTime()-start)<a);
        System.out.println("----------------");
    }





}
