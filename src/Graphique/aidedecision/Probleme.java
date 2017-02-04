package Graphique.aidedecision;

import java.util.LinkedList;

import static util3.Util3.line;

/**
 * Created by mathieu on 02/02/2017.
 */
public class Probleme {

    public int nbReble;
    public int nbChamp;
    LinkedList<Champ> Champ=new LinkedList<>();
    LinkedList<contrainte> contrainte=new LinkedList<>();

    public Probleme()
    {
        String adressedufichier = System.getProperty("user.dir") + "\\"+"src\\dame8";
        LinkedList<String> fichier=util3.fichier.lectureFichier(adressedufichier);

//---------------------------------------------------------------------------------------------
       LinkedList<String>temporaire;

        temporaire=util3.Util3.separer(fichier.get(0)," ");
        nbChamp=Integer.parseInt(temporaire.get(0));
        nbReble=Integer.parseInt(temporaire.get(1));



 //---------------------------------------------------------------------------------------------

//dimension


//---------------------------------------------------------------------------------------------
//------------------------------- Champ        ------------------------------------------------
//---------------------------------------------------------------------------------------------


        Champ tmp;

        int curseur=3;

        for(int i=0;i<nbChamp;i++)
        {tmp=new Champ();
            temporaire=util3.Util3.separer(fichier.get(curseur+i)," ");


            tmp.ID=Integer.parseInt(temporaire.get(0));


            for (int valeur=2;valeur<temporaire.size();valeur++)
            {
                tmp.valeur.add(Integer.parseInt(temporaire.get(valeur)));
            }
            Champ.add(tmp) ;
        }


//---------------------------------------------------------------------------------------------
//------------------------------- Contrainte   ------------------------------------------------
//---------------------------------------------------------------------------------------------





    }



    public void afficher()
    {
        System.out.println("nbChamp= "+nbChamp+" nbregle= "+nbReble);
        System.out.println("dimension a faire");
        line(1);

        for (Champ donne:Champ) {donne.afficher();}
        line(1);

    }

}
