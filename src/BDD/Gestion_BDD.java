package BDD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mathieu on 18/03/2016.
 */
public class Gestion_BDD extends util3.fichier {

    public static boolean ajout_vehicule(String nomFic, String texte)
    {
        //on va chercher le chemin et le nom du fichier et on me tout ca dans un String
        //String adressedufichier = System.getProperty("user.dir") +"/src/BDD/vehicule/"+ nomFic;

        String Fichier="/src/BDD/vehicule/"+nomFic;
        String adressedufichier = System.getProperty("user.dir") +Fichier;

        String ddd = System.getProperty("user.dir") + "/"+ nomFic;
        System.out.print(ddd);


        ecrire(Fichier,"ligne 1"+"\n");
        ecrire(Fichier,"ligne 2"+"\n");
        ecrire(Fichier,"ligne 3"+"\n");

        return true;
    }

    public static boolean ajout_Eprunteur(String nomFic, int ID,String Nom,String Prenom,String Adresse,boolean Assurance,int Nb_devis,int[]devis)
    {

        String Fichier="/src/BDD/Emprunteur/"+nomFic;
        String adressedufichier = System.getProperty("user.dir") +Fichier;


        //on met try si jamais il y a une exception
        try
        {
            FileWriter fw = new FileWriter(adressedufichier, false);//on ecrase le fichier
            // FileWriter fw = new FileWriter(adressedufichier, true);//on ecrit a la suite du fichier
            BufferedWriter output = new BufferedWriter(fw);

            //on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)

            //----------ecriture--------------------------------------------------



            writeln(output,""+ID);
            writeln(output,Nom);
            writeln(output,Prenom);
            writeln(output,Adresse);
            writeln(output,""+Assurance);
            writeln(output,""+Nb_devis);
            for(int i=0;i<Nb_devis;i++)
            {
                writeln(output,""+devis[i]);
            }





            //-----------------------------------------------------------------------------



            output.flush();

            output.close();

        }
        catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }




        return true;
    }



}
