package util3;

import javax.swing.text.Utilities;
import java.io.*;
import java.util.Scanner;

/**
 * Created by mathieu on 18/03/2016.
 */
public class fichier {




    public static void ecrire(String nomFic, String texte)
    {
        //on va chercher le chemin et le nom du fichier et on me tout ca dans un String
        String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;
        texte+="\n";

        //on met try si jamais il y a une exception
        try
        {
            /**
             * BufferedWriter a besoin d un FileWriter,
             * les 2 vont ensemble, on donne comme argument le nom du fichier
             * true signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus

             */
            FileWriter fw = new FileWriter(adressedufichier, false);//on ecrase le fichier
            // FileWriter fw = new FileWriter(adressedufichier, true);//on ecrit a la suite du fichier
            // le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
            BufferedWriter output = new BufferedWriter(fw);

            //on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
            output.write(texte);
            //on peut utiliser plusieurs fois methode write

            output.flush();

            output.close();

        }
        catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }

    }

    private static void write(BufferedWriter output,String texte)
    {try{output.write(texte);}  catch(IOException ioe){
        System.out.print("Erreur : "); ioe.printStackTrace();}
    }
    private static void writeln(BufferedWriter output,String texte)
    {try{output.write(texte+"\n");}  catch(IOException ioe){
        System.out.print("Erreur : "); ioe.printStackTrace();}
    }

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

    public static boolean ajout_Eprunteur(String nomFic, int ID,String Nom,String Prenom,String Adress,boolean Assurance,int Nb_devis,int[]devis)
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



            writeln(output,"ligne 1");
            writeln(output,"ligne 2");
            writeln(output,"ligne 3");

                /*

    ID        int
Nom       string
Prenom    string
Adresse   string
Assurance boolean
Nb_devis  int
     */




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

//------------------------------------------------------------------------------------------------------------------------
public static void writeFile(String fileContent, String filePathOutput) {
    try {

        // BufferedWriter a besoin d'un FileWriter, les 2 vont ensemble, on
        // donne comme argument le nom du fichier et false signifie qu'on
        // écrase le contenu du fichier et qu'on ne fait pas d'append sur le
        // contenu.
        FileWriter fileWriter = new FileWriter(filePathOutput, false);

        // Le BufferedWriter output auquel on donne comme argument le
        // fileWriter écrase le contenu déjà présent dans le fichier.
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // On écrit dans le fichier ou plutot dans le bufferedWriter qui
        // sert de tampon(stream)
        bufferedWriter.write(fileContent);

        bufferedWriter.flush();
        bufferedWriter.close();
        System.out.println("Fichier créé");
    } catch (IOException ioe) {
        System.err
                .println("Erreur levée de type IOException au niveau de la méthode "
                        + "writeFile(...) : ");
        ioe.printStackTrace();
    }
}

    public static void dupliquerfichier(String Fichier_entrer, String Fichier_sortie) {

    Scanner scanner = null;
    String line = null;
    StringBuffer str = new StringBuffer();
    try {
        scanner = new Scanner(new File(Fichier_entrer));

        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            System.out.println(line);

            if (line != null)
                str.append(line + "\r\n");
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("Erreur levée de type FileNotFoundException"
                + " au niveau de la méthode " + "readFile(...) : ");
        e.printStackTrace();
    }

    writeFile(str.toString(), Fichier_sortie);
}

    public static void formatSQLFileContentToIntegrateThisInTheJAVACode(
            String filePathInput, String filePathOutput) {

        Scanner scanner = null;
        String line = null;
        StringBuffer str = new StringBuffer();
        try {
            scanner = new Scanner(new File(filePathInput));

            // On boucle sur chaque champ detecté
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line != null)
                    str.append(".append(\"" + line + " \")\r\n");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err
                    .println("Erreur levée de type FileNotFoundException"
                            + " au niveau de la méthode "
                            + "formatSQLFileContentToIntegrateThisInTheJAVACode(...) : ");
            e.printStackTrace();
        }

       writeFile(str.toString(), filePathOutput);
    }
}





