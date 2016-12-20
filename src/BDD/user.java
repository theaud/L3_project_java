package BDD;


public class user {

    public static int compteur =0;
    public int  ID;
    public String nom;
    public String prenom;

    public user()
    {   compteur++;
        ID=compteur;
        nom="nom";
        prenom="prenom";
    }


    public String afficher()
    {String text=ID+" "+nom+" "+prenom;
     System.out.println(text);
     return text;

    }







}
