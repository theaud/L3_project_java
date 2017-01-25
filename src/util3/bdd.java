package util3;

import java.sql.*;
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
                {requete+=ligne;
                 if(argument.size()!=++i)   { requete+=",\n";}
                }
            requete+="); ";

            Statement state = connection.createStatement();
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

    public static boolean DELETE(Connection connection,String emplacement,String donne,String valeur)
    {try{String requete = "DELETE FROM "+emplacement+" WHERE "+donne+"="+valeur+";";

        Statement state = connection.createStatement();
        state.executeUpdate(requete);

    }catch (SQLException e){
        System.out.println("DELETE:Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }

    public static boolean CLEAR(Connection connection,String emplacement)
    {try{String requete = "DELETE FROM "+emplacement+";";

        Statement state = connection.createStatement();
        state.executeUpdate(requete);

    }catch (SQLException e){
        System.out.println("DELETE:Requete Failed! Check output console");
        e.printStackTrace();
        return false;
    }return true;
    }


    public static LinkedList<LinkedList<String>> SELECT(Connection connection,String filtre,String from,int nb_argument)
    {
        String requete="select "+filtre+" from "+from;

        LinkedList<LinkedList<String>> returned=new LinkedList<LinkedList<String>>();
        //--------------------------------------------------------------------------------------------
        //---------------------------    intituler    -------------------------------------------------
        // --------------------------------------------------------------------------------------------
        if(filtre=="*")
        {try{
            ResultSet rs;
            Statement state = connection.createStatement();
            rs=state.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='"+from+"' ");
          //  System.out.println(rs);
            LinkedList<String> tmp=new LinkedList<>();
            while ( rs.next() )
            {

                /*for (int i=1;i<=nb_argument;i++)
                {tmp.add(rs.getString(i));}*/
                tmp.add(rs.getString(1));

            }
            returned.add(tmp);
        }catch (SQLException e){
                System.out.println("select:Requete Failed! Check output console");
                e.printStackTrace();
            }

        }
        else
        {
           // SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS  WHERE TABLE_NAME='NomDeLaTable'
        }

        //--------------------------------------------------------------------------------------------
        //---------------------------    contenu    -------------------------------------------------
        // --------------------------------------------------------------------------------------------





        try{ResultSet rs;
            Statement state = connection.createStatement();
            rs=state.executeQuery(requete);

            while ( rs.next() )
            {LinkedList<String> tmp=new LinkedList<>();
                for (int i=1;i<=nb_argument;i++)
                {tmp.add(rs.getString(i));}
                returned.add(tmp);
            }


        }catch (SQLException e){
            System.out.println("select:Requete Failed! Check output console");
            e.printStackTrace();
        }




        return returned;

    }


}
