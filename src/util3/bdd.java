package util3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class bdd {


    public static Connection InitialisationBDD(String url)
    {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");
        Connection connection = null;



        try
        {
            // String url = "jdbc:postgresql://localhost/testdb?user=postgres&password=azertyuiop";
            connection = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public static void creationTable(Connection connection, String nomTable, LinkedList<String> argument)
    {

        try{String requete="CREATE TABLE "+nomTable+"(";

            for(String ligne:argument)
            {
                requete+=ligne+"\n";

            }
            requete+="COMPANY"+('a')+"  CHAR(50) NOT NULL";
            requete+="); ";

            Statement state = connection.createStatement();


            state.executeUpdate(requete);


        }catch (SQLException e){
            System.out.println("Requete Failed! Check output console");
            e.printStackTrace();

        }

    }
    public static boolean SuppressionTable(Connection connection, String nomTable)
    {try{String requete="DROP TABLE "+nomTable;
        Statement state = connection.createStatement();
        state.executeUpdate(requete);

    }catch (SQLException e){
        System.out.println("Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }


    public static boolean ajoutBDD(Connection connection,String emplacement)
    {try{String requete = "INSERT  INTO aaa VALUES('valeur 1');";

        Statement state = connection.createStatement();
        state.executeQuery(requete);

    }catch (SQLException e){
        System.out.println("Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }





}
