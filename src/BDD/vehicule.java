package BDD;


public class vehicule {
    public static int compteur =0;
    public int  ID;
    public String _marque;



    public vehicule()
    {    compteur++;
        ID=compteur;
        _marque="marque";
    }


    public String afficher()
    {String text=ID+" "+_marque;
        System.out.println(text);
        return text;

    }
}
