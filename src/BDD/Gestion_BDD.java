package BDD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;


public class Gestion_BDD extends util3.fichier {



  private static int actualisation_annuaire_ajout(String chemin)
  {
      LinkedList<String> listLign=lectureFichier(chemin);

      int rang=parseInt(listLign.getFirst())+1;
      int Id_nouveau=parseInt(listLign.getLast())+1;
      listLign.set(0,""+rang);
      System.out.println("ligne 1="+rang+"  nouveau ="+Id_nouveau );

      listLign.add(""+Id_nouveau);

      ecrire(chemin,listLign);
      return Id_nouveau;
  }








    public static boolean ajout_vehicule(String nomFic, String texte)
    {String Fichier="./src/BDD/vehicule/"+nomFic;

        try
        { FileWriter fw = new FileWriter(Fichier, false);//on ecrase le fichier
            BufferedWriter output = new BufferedWriter(fw);
            /* version a mettre a jour avec variable de vehicule
            writeln(output,""+ID);
            writeln(output,Nom);
            writeln(output,Prenom);
            writeln(output,Adresse);
            writeln(output,""+Assurance);
            writeln(output,""+Nb_devis);
            for(int i=0;i<Nb_devis;i++)
            {writeln(output,""+devis[i]);}
            */

            output.flush();
            output.close();
        }
        catch(IOException ioe){ System.out.print("Erreur : ");   ioe.printStackTrace();}

        return true;
    }



    public static boolean ajout_Eprunteur(String Nom,String Prenom,String Adresse,boolean Assurance)
    {   int Id=actualisation_annuaire_ajout("./src/BDD/Emprunteur/Annuaire");
        return ajout_Eprunteur(Id, Nom, Prenom, Adresse, Assurance);
    }

    private static boolean ajout_Eprunteur( int ID,String Nom,String Prenom,String Adresse,boolean Assurance)
    {
        String Fichier="./src/BDD/Emprunteur/"+ID+"";
        try
        { FileWriter fw = new FileWriter(Fichier, false);//on ecrase le fichier
          BufferedWriter output = new BufferedWriter(fw);

            writeln(output,""+ID);
            writeln(output,Nom);
            writeln(output,Prenom);
            writeln(output,Adresse);
            writeln(output,""+Assurance);
            writeln(output,""+0);// = Nb_devis soit 0 a la creation

            output.flush();
            output.close();
        }
        catch(IOException ioe){ System.out.print("Erreur : ");   ioe.printStackTrace();}

        return true;
    }



}
