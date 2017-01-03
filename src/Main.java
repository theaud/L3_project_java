
import Graphique.app.Application;
import util3.bdd;

import java.sql.*;
import java.util.LinkedList;

import static util3.Util3.afficher;
import static util3.Util3.rand;

public class Main {


    public static void main(String[] args) {

        Connection connection= bdd.InitialisationBDD("jdbc:postgresql://localhost/testdb?user=postgres&password=azertyuiop");


        inserTemp(connection);


        Application pricipale=new Application();

       LinkedList<String> a= bdd.select(connection,"select * from temp",5);
        afficher(a);



    }
/*
CREATE TABLE temps (
    ville           varchar(80),
    t_basse         int,           -- température basse
    t_haute         int,           -- température haute
    prcp            real,          -- précipitation
    date            date
);


 */
    static void tableVille(Connection connection)
    {
        LinkedList<String>argument=new LinkedList<>();
        argument.add("nom            varchar(80)");
        argument.add(" emplacement    point");
        bdd.CREATE_TABLE( connection,  "ville", argument);
    }

    static void tableTemp(Connection connection)
    {
        LinkedList<String>argument=new LinkedList<>();
        argument.add("ville           varchar(80)");
        argument.add("t_basse         int");
        argument.add("t_haute         int");
        argument.add("prcp            real");
        argument.add("date            date");


        bdd.CREATE_TABLE( connection,  "Temp", argument);
    }

    static void inserTemp(Connection connection)
    {
        String donne="'San Francisco', "+(double)rand(1,1000)*0.01+","+rand(1,50)+", 0.25, '1994-11-27'";
        bdd.INSERT( connection,"temp",donne);
    }


    }


