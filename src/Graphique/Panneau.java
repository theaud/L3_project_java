package Graphique;

/**
 * Created by mathieu on 01/04/2016.
 */
public class Panneau extends Fenetre {


    private String name;
    private static int compteur=0;



    public Panneau()
    {System.out.println(compteur);
        name="Fenetre "+compteur;
        compteur++;
    }

    public Panneau(String Name)
    {name=Name;

    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



}
