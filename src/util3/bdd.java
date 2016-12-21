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

        Connection connection = null;



        try
        {
            // String url = "jdbc:postgresql://localhost/testdb?user=postgres&password=azertyuiop";
            connection = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }
        if (connection == null) {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public static void CREATE_TABLE(Connection connection, String nomTable, LinkedList<String> argument)
    {

        try{String requete="CREATE TABLE "+nomTable+"(";
            int i=0;
            for(String ligne:argument)
            {
                requete+=ligne;

                if(argument.size()!=++i)
                {
                    requete+=",\n";
                }


            }
            requete+="); ";

            Statement state = connection.createStatement();

            System.out.println(requete);
            state.executeUpdate(requete);


        }catch (SQLException e){
            System.out.println("creationTable:Requete Failed! Check output console");
            e.printStackTrace();

        }

    }
    public static boolean DROP_TABLE(Connection connection, String nomTable)
    {try{String requete="DROP TABLE "+nomTable;
        Statement state = connection.createStatement();
        state.executeUpdate(requete);

    }catch (SQLException e){
        System.out.println("SuppressionTable:Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }


    public static boolean INSERT(Connection connection,String emplacement,String donne)
    {try{String requete = "INSERT  INTO "+emplacement+" VALUES("+donne+");";

        Statement state = connection.createStatement();
        state.executeUpdate(requete);

    }catch (SQLException e){
        System.out.println("ajoutBDD:Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }









}
