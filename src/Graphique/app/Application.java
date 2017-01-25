package Graphique.app;

import Graphique.Jpanel.Jframeadd;
import util3.bdd;

import java.awt.*;
import java.sql.Connection;

import static util3.Util3.Tableau_String_to_Jlabel;


public class Application extends Jframeadd {



    public Application(){
           // this.setTitle("Application");

            content.setLayout(new GridBagLayout());


        }


    /**
     *
     * @param connection
     */
    public Application(Connection connection){

        this.setTitle(content.getName());
        content.setConfig(Color.lightGray,new GridBagLayout());


        content.add(Tableau_String_to_Jlabel(bdd.SELECT(connection,"*","temp",5)));



    }



}
