
import Graphique.Panneau;


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
