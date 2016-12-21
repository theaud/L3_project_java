
import util3.bdd;

import java.sql.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        Connection connection= bdd.InitialisationBDD("jdbc:postgresql://localhost/testdb?user=postgres&password=azertyuiop");

        inserTemp( connection);


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
        String donne="'San Francisco', 46, 50, 0.25, '1994-11-27'";
        bdd.INSERT( connection,"temp",donne);
    }


    }


