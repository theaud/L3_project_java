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
        String adressedufichier = System.getProperty("user.dir") + "\\"+"src\\test";
        LinkedList<String> fichier=util3.fichier.lectureFichier(adressedufichier);afficher(fichier);

//---------------------------------------------------------------------------------------------
       LinkedList<String>temporaire=util3.Util3.separer(fichier.get(0)," ");
        nbChamp=Integer.parseInt(temporaire.get(0));
        nbReble=fichier.size()-Integer.parseInt(temporaire.get(0))-1;

 //---------------------------------------------------------------------------------------------

//dimension


//---------------------------------------------------------------------------------------------
//------------------------------- Champ        ------------------------------------------------
//---------------------------------------------------------------------------------------------
        Champ tmp;

        int curseur=1;

        for(int i=0;i<nbChamp;i++)
        {tmp=new Champ();
            temporaire=util3.Util3.separer(fichier.get(curseur+i)," ");

            tmp.ID=Integer.parseInt(temporaire.get(0));


            for (int valeur=2;valeur<temporaire.size();valeur++)
            {
                tmp.valeur.add(Integer.parseInt(temporaire.get(valeur)));
            }
            Champ.add(tmp) ;
            tmp.afficher();
        }
        System.out.println();
//---------------------------------------------------------------------------------------------
//------------------------------- Contrainte   ------------------------------------------------
//---------------------------------------------------------------------------------------------
            contrainte tmp2;
         curseur=1+nbChamp;


        for(int i=0;i<nbReble;i++)
        {tmp2=new contrainte(fichier.get(curseur+i));
            temporaire=util3.Util3.separer(fichier.get(curseur+i)," ");
//!!!!!!!!!!!!!!!!!!!!!
            tmp2.Id=Integer.parseInt(temporaire.get(0));
            tmp2.Type=temporaire.get(1);

            for (int valeur=2;valeur<temporaire.size();valeur++)
            {
                tmp2.application.add(Integer.parseInt(temporaire.get(valeur)));
            }
            contrainte.add(new contrainte(fichier.get(curseur+i))) ;
            tmp2.afficher();
        }







    }



    public LinkedList<String> methode_triviale()
    {LinkedList<String> Solution=new LinkedList<>();



        LinkedList<Integer> valeur=new LinkedList<>();
        valeur.add(Champ.get(0).valeur.get(0));
        valeur.add(Champ.get(1).valeur.get(0));
        valeur.add(Champ.get(2).valeur.get(0));

        System.out.println("TEST == "+test(valeur));


        System.out.println("test");
    return Solution;
    }


    public boolean test(LinkedList<Integer> valeur)
    {System.out.println("\n------------------------------------");
        int i=0;
        for(contrainte courante:contrainte)
        {
            if(!courante.resolution(valeur))
            {
                System.out.println(" contrainte "+i+":"+courante.resolution(valeur));
                return false;
            }
            i++;
        }
        System.out.println("\nTest correct pour cette ensemble de valeur");
        System.out.println("\n------------------------------------");
        return true;
    }

    private void afficher_valeur_tester(LinkedList<Integer> valeur)
    {
        System.out.print("Valeur tester : ");
        for (Integer a:valeur) {System.out.print(a+" ");}
        System.out.println();
    }



    public void afficher()
    {
        System.out.println("nbChamp= "+nbChamp+" nbregle= "+nbReble);
        System.out.println("dimension a faire");
        line(1);

        for (Champ donne:Champ) {donne.afficher();}
        line(1);

    }
    public void afficher(LinkedList<String> text)
    {
        for (String donne:text) {System.out.println(donne);}
        line(1);

    }


}
