package BDD;

import Graphique.Lign;
import Location.Emprunteur;
import util3.Util3;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
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
      listLign.add(""+Id_nouveau);
      ecrire(chemin,listLign);
      return Id_nouveau;
  }

    public static void clear_bdd(String chemin)
    {
        LinkedList<String> texte=lectureFichier(chemin+"Annuaire");
        for (int i=1;i<texte.size();i++)
            {suppression(chemin,i);}
        try
        {String Fichier=chemin+"Annuaire";
        FileWriter fw = new FileWriter(Fichier, false);//on ecrase le fichier
        BufferedWriter output = new BufferedWriter(fw);

        writeln(output,""+0);
            output.flush();
            output.close();
        }
        catch(IOException ioe){    ioe.printStackTrace();}

    }


    public static void ajout(String chemin, LinkedList<String> texte)
    {
        int id=actualisation_annuaire_ajout(chemin+"Annuaire");
        String Fichier=chemin+id+"";// exemple chemin = "./src/BDD/Emprunteur/"

        try
        { FileWriter fw = new FileWriter(Fichier, false);//on ecrase le fichier
            BufferedWriter output = new BufferedWriter(fw);

            writeln(output,""+id);
            for(int i=0;i<texte.size();i++)
                {writeln(output,texte.get(i));}

            output.flush();
            output.close();
        }
        catch(IOException ioe){  ioe.printStackTrace();}
    }
    public static void suppression(String chemin,int id)
    {  if(id>=0 )
        {   LinkedList<String> listLign=lectureFichier(chemin+"Annuaire");
            int compteur=0;

            for(int i=0;i<listLign.size();i++)
            {if(listLign.get(i).equals(""+id))
                {compteur++;
                listLign.remove();
                i--;
                }
            }

            //------------------------------------
            int rang=parseInt(listLign.getFirst())-compteur;
            listLign.set(0,""+rang);

            ecrire(chemin+"/Annuaire",listLign);

    //------------------------------------------------------
            File MyFile = new File(chemin+id);
            MyFile.delete();
        }
    }

    public static  boolean existe(String chemin,int id)
    { LinkedList<String> listLign=lectureFichier(chemin+"Annuaire");
        for(int i=1;i<listLign.size();i++)
            {if(listLign.get(i).equals(""+id))
                {return true;}
            }
        return false;
    }


    public static  LinkedList<String> lecture(String chemin,int id)
    {  if(id>=0 && existe( chemin, id))
        {return lectureFichier(chemin+id);}
      return new LinkedList<String>();
    }


    public static  LinkedList<LinkedList<String>> CopieBdd(String chemin)
    {
        LinkedList<LinkedList<String>> Base_donner=new LinkedList<LinkedList<String>>();


        LinkedList<String> Annuaire=lectureFichier(chemin+"Annuaire");

        for (int i=1;i<Annuaire.size();i++)
        {
            Base_donner.add(lecture( chemin, Integer.parseInt(Annuaire.get(i))));
        }

        return Base_donner;
    }




    public static String affichage_Bdd_entete(String chemin,int max)
    {
        LinkedList<String> annuaire=lectureFichier(chemin+"modele");
        String tableau="";
        tableau+="<tr>";
        for(int j=0;j<annuaire.size() &&j<max;j++)
        {
            tableau+="<th>"+annuaire.get(j)+"</th>";
        }
        tableau+="</tr>";
        return tableau;
    }


    public static JLabel affichage_Bdd(String chemin,int max,LinkedList<String> contrainte)
    {
        LinkedList<LinkedList<String>> CopieBdd=CopieBdd(chemin);
        String tableau="<html><table>";
        tableau+=affichage_Bdd_entete(chemin, max);

        for(int i=0;i<CopieBdd.size() ;i++)
        {
            if(contrainte(CopieBdd.get(i) , contrainte))
            {
                tableau+="<tr>";
                for(int j=0;j<CopieBdd.get(i).size()&&j<max;j++)
                    {tableau+="<td>"+CopieBdd.get(i).get(j)+"</td>"; }
                tableau+="</tr>";
            }
        }
        tableau+="</table><span></html>";

        JLabel returned= new JLabel(tableau);
        returned.setForeground(Color.RED);
        return returned;
    }

    public static  void afficher(String chemin,int id)
    {Util3.afficher(lecture(chemin,id));
    }


    public static  boolean contrainte(LinkedList<String> entrer ,LinkedList<String> contrainte)
    {for(int j=0;j<entrer.size();j++) {
        for (int i = 0; i < contrainte.size(); i++) {
            if (entrer.get(j).equals(contrainte.get(i))) {
                return true;
            }
        }
    }
        return false;
    }




//----------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------    fonction a deplacer              ------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------








    public static JLabel afficher_Devis_console(int id)
    {String chemin="./src/BDD/Devis/";

        LinkedList<String> texte=lecture(chemin,id);
        LinkedList<String> texte_ajout=new LinkedList<String>();

        texte_ajout.add("--------------------------------------------------");
        texte_ajout.add("Fiche Devis");
        texte_ajout.add("Id du Devis :"+texte.get(0));
        texte_ajout.add("Id_emprunteur  :"+texte.get(1));
        texte_ajout.add("Id_vehicule :"+texte.get(2));
        texte_ajout.add("Date_debut :"+texte.get(3));
        texte_ajout.add("Date_fin"+texte.get(4));
        texte_ajout.add("Tarif"+texte.get(5));
        texte_ajout.add("--------------------------------------------------");

        return Lign.mise_en_forme_ligne_jpanel(texte_ajout);
    }

    /*
    public static LinkedList<JLabel> lecture_ecran(String chemin, int id)
    {   LinkedList<String> texte= lecture(chemin,id);
        LinkedList<JLabel> returned=new LinkedList<JLabel>();

        for(int i=0;i<texte.size();i++)
            {returned.add(new JLabel());
            returned.getLast().setText(texte.get(i));}

        return returned;
    }
*/

}
