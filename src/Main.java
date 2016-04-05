
import Affichage.Login;
import Graphique.Panneau;


public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


        //Gestion_BDD.actualisation_annuaire_ajout("./src/BDD/test.txt",11);


        Panneau Panneau=new Panneau();
        Panneau.changement_Ecran(new Login());


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
