import Affichage.Login;
import BDD.Gestion_BDD;
import Location.*;
import util3.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


        Gestion_BDD.actualisation_annuaire_ajout("./src/BDD/test.txt",11);

        Scan scan=new Scan();

        int a=scan.scanINT();
        System.out.println(a);

       /* Login Initiation=new Login();

        if(!Initiation.isOuvert())
        {
            System.out.println("Hello ddd");
        }

    */

    }
}
