
import util3.bdd;

import java.sql.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        Connection connection= bdd.InitialisationBDD("jdbc:postgresql://localhost/testdb?user=postgres&password=azertyuiop");
        LinkedList<String>argument=new LinkedList<>();
        argument.add("\"Titre     NOT NULL\"");

        //creationTable( connection,  "table41", argument);





    }



    }


