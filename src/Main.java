import Affichage.Login;
import Location.*;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");


    int []a=new int [2];a[0]=1;a[1]=2;
        BDD.Gestion_BDD.ajout_Eprunteur("test1.txt",1,"nom","Prenom","Adresse",true,2,a);
        BDD.Gestion_BDD.ajout_Eprunteur("test2.txt",1,"nom","Prenom","Adre4sse",true,2,a);
        BDD.Gestion_BDD.ajout_Eprunteur("test3.txt",1,"nom","Prenom","Adresse",true,2,a);
       /* Login Initiation=new Login();

        if(!Initiation.isOuvert())
        {
            System.out.println("Hello ddd");
        }

    */

    }
}
