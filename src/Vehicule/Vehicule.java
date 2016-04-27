package Vehicule;

import BDD.Gestion_BDD;
import util3.Util3;

import java.util.LinkedList;


public class Vehicule
{
    private int     ID=0;
    private String  Nom="Nom";
    private String  Marque="marque";
    private String  Constructeur="";
    private String  Couleur="";
    private double  Kilometrage=0.0;
    private boolean Type1=true;
    private boolean Type2=true;
    private double  tarif=0.0;
    private int     nbStock=0;
    private int     nblouer=0;
    private int [][]location;

    public Vehicule() {}


    public Vehicule(int id)
    {
        LinkedList<String> texte=Gestion_BDD.lecture("./src/BDD/Vehicule/",id);
        Util3.afficher(texte);

        //warning prendre en compte moto auto apres
        ID=Integer.parseInt("0"+texte.get(0));
        Marque=texte.get(1);
        Constructeur=texte.get(2);
        Constructeur=texte.get(3);
        Couleur=texte.get(5);
        Kilometrage=Double.parseDouble("0"+texte.get(6));
        Type1=texte.get(7).equals("true");
        Type2=texte.get(8).equals("true");
        tarif=Double.parseDouble("0"+texte.get(9));
        nbStock=Integer.parseInt("0"+texte.get(10));
        nblouer=Integer.parseInt("0"+texte.get(11));

        if(nblouer>0)
        {
            location=new int[2][nblouer];

            for(int i=12;i<12+nblouer;i++)
            {String []tampon=texte.get(i).split(" ");
                location[0][i]=Integer.parseInt("0"+tampon[0]);
                location[1][i]=Integer.parseInt("0"+tampon[1]);
                System.out.println( location[0][i]+"   "+"   ");
            }
        }

    }










    public String getMarque() {return Marque;}
    public void setMarque(String marque) {Marque = marque;}
}
