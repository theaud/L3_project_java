package Graphique.aidedecision;

import java.util.LinkedList;

public class contrainte {

    //syntaxe
    //ID cible Type (valeur) application->

    public int Id=0;
    public String cible;
    public String Type;
    public LinkedList<Integer> application=new LinkedList<>();
    public int valeur=0;


  //  public boolean principale;//contrainte principale => necessaire pour ressourdre , sinon contrainte utiliser par les autre contrainte

    public contrainte(String contrainte)
    {
        tmp2=new contrainte(fichier.get(curseur+i));
        temporaire=util3.Util3.separer(contrainte," ");
//!!!!!!!!!!!!!!!!!!!!!
        tmp2.Id=Integer.parseInt(contrainte));
        tmp2.Type=temporaire.get(1);

        for (int valeur=2;valeur<temporaire.size();valeur++)
        {
            tmp2.application.add(Integer.parseInt(contrainte));
        }


    }

    public contrainte(String type,LinkedList<Integer> Application)
    {
        Type=type;
        application=Application;
    }

    public contrainte(String type,int Valeur,LinkedList<Integer> Application)
    {
        Type=type;
        application=Application;
        valeur=Valeur;
    }


    public void afficher()
    {
        System.out.print(Id+" : "+Type+" : ");

        for (Integer i: application)
        {
            System.out.print(i+" ");
        }
        System.out.println();

    }

    public boolean resolution(LinkedList<Integer> valeur)
    {


        if(Type.equals("=")){return eguale( valeur);}
        else if(Type.equals("=!")){return  different(valeur); }
        else        {System.out.println("Contrainte non definie");}




        return true;
    }


    private boolean eguale(LinkedList<Integer> valeur)
    {System.out.print("\nTest l'egualiter ");affichage_valeur_tester( valeur);


        if(application.size()==2)
            {return (valeur.get(application.get(0)))==valeur.get(application.get(1));}
        else
            {for(int i=0;i<application.size()-1;i++)
                { for(int j=i+1;i<application.size();i++)
                    {
                        if(valeur.get(i)!=valeur.get(j))
                        {return false;}
                        System.out.print("");//enleve la duplication de code ^^
                    }
                }
            }
        return true;
    }
    private boolean different(LinkedList<Integer> valeur)
    {System.out.print("\nTest la diference ");affichage_valeur_tester( valeur);
        if(application.size()==2){return (valeur.get(application.get(0)))!=valeur.get(application.get(1));}
        else
        {for(int i=0;i<application.size()-1;i++)
            {for(int j=i+1;j<application.size();j++)
                {if(valeur.get(i)==valeur.get(j))
                    {return false;}
                }
            }
        }
        return true;
    }

    private void affichage_valeur_tester(LinkedList<Integer> valeur)
    {System.out.print("{");
        for(Integer tester:application)
        {
            System.out.print(valeur.get(tester)+" ");
        }
        System.out.print("}");

    }


}
