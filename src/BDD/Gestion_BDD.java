package BDD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;


public class Gestion_BDD extends util3.fichier {



  public static boolean actualisation_annuaire_ajout(String chemin,int Id_nouveau)
  {
      LinkedList<String> listLign=lectureFichier(chemin);

      int rang=parseInt(listLign.getFirst())+1;
      listLign.set(0,""+rang);
      System.out.println("ligne 1="+rang);
      listLign.add(""+Id_nouveau);

      ecrire(chemin,listLign);


      return true;
  }








    public static boolean ajout_vehicule(String nomFic, String texte)
    {String Fichier="/src/BDD/vehicule/"+nomFic;

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

    public static boolean ajout_Eprunteur(String nomFic, int ID,String Nom,String Prenom,String Adresse,boolean Assurance,int Nb_devis,int[]devis)
    {
        String Fichier="/src/BDD/Emprunteur/"+nomFic;

        try
        { FileWriter fw = new FileWriter(Fichier, false);//on ecrase le fichier
          BufferedWriter output = new BufferedWriter(fw);

            writeln(output,""+ID);
            writeln(output,Nom);
            writeln(output,Prenom);
            writeln(output,Adresse);
            writeln(output,""+Assurance);
            writeln(output,""+Nb_devis);
            for(int i=0;i<Nb_devis;i++)
                {writeln(output,""+devis[i]);}


            output.flush();
            output.close();
        }
        catch(IOException ioe){ System.out.print("Erreur : ");   ioe.printStackTrace();}

        return true;
    }



}
