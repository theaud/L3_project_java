package util3;


import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class fichier {



    //------------------------------------------------------------------------------------------------------------------------
    public static void ecrire(String nomFic, LinkedList<String> texte)
    {
String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;

        try
        {FileWriter fw = new FileWriter(adressedufichier, false);//on ecrase le fichier
         // FileWriter fw = new FileWriter(adressedufichier, true);//on ecrit a la suite du fichier

         BufferedWriter output = new BufferedWriter(fw);

            for(int i=0;i<texte.size();i++)
                {
                    write(output,texte.get(i)+"\n");
                }

            output.flush();
            output.close();

        }
        catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }
    }


    public static void ecrire(String nomFic, String texte)
    {String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;

        try
        {FileWriter fw = new FileWriter(adressedufichier, false);//on ecrase le fichier

            BufferedWriter output = new BufferedWriter(fw);

            write(output,texte);
            output.flush();
            output.close();

        }
        catch(IOException ioe){
            System.out.print("Erreur : ");
            ioe.printStackTrace();
        }
    }

    public static void write(BufferedWriter output,String texte)
    {try{output.write(texte);}  catch(IOException ioe){
        System.out.print("Erreur : "); ioe.printStackTrace();}
    }
    public static void writeln(BufferedWriter output,String texte)
    {try{output.write(texte+"\n");}  catch(IOException ioe){
        System.out.print("Erreur : "); ioe.printStackTrace();}
    }


//------------------------------------------------------------------------------------------------------------------------
public static void writeFile(String fileContent, String filePathOutput) {
    try {
        FileWriter fileWriter = new FileWriter(filePathOutput, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(fileContent);
        bufferedWriter.flush();
        bufferedWriter.close();

    } catch (IOException ioe) {
        System.err
                .println("Erreur levée de type IOException au niveau de la méthode "
                        + "writeFile(...) : ");
        ioe.printStackTrace();
    }
}
//------------------------------------------------------------------------------------------------------------------------
    public static LinkedList<String> lectureFichier(String Fichier_entrer) {
    LinkedList<String> listLign=new  LinkedList<String>();
    Scanner scanner = null;
    String line = null;
    StringBuffer str = new StringBuffer();
    try {
        scanner = new Scanner(new File(Fichier_entrer));

        // On boucle sur chaque champ detecté
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            listLign.add(line);
            if (line != null)
                str.append(line + "\r\n");
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("Erreur levée de type FileNotFoundException"
                + " au niveau de la méthode " + "readFile(...) : ");
        e.printStackTrace();
    }

    return listLign;
}



}





