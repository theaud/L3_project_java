import Affichage.*;
import Graphique.Panneau;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


        //Gestion_BDD.actualisation_annuaire_ajout("./src/BDD/test.txt",11);




       Menu menu=new Menu();
        System.out.println("-----------------------------------------------");
        wait(2000000000);
        menu.changement_fenetre(new Panneau());

        wait(2000000000);

        wait(2000000000);
        menu.changement_fenetre(new Panneau());

        wait(2000000000);

        wait(2000000000);
        menu.changement_fenetre(new Panneau());

        wait(2000000000);
        menu.retour_Menu();

    }


    public static void wait(int a)
    {

        long start=System.nanoTime();

        while((System.nanoTime()-start)<a);
        System.out.println("----------------");
    }





}
