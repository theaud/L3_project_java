
import BDD.Gestion_BDD;
import Graphique.Panneau;



public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


        //Gestion_BDD.actualisation_annuaire_ajout("./src/BDD/test.txt",11);




        //Gestion_BDD.afficher_utilisateur_console(3);

        Gestion_BDD.clear_bdd("src/BDD/Emprunteur/");
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
