package Affichage;


import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends Ecran {

    public Login() {name="Login initialiser";
        setBackground(Color.pink);

        initialiser(2,2);
        Login_initialisation();
    }


    private void Login_initialisation()
    {setLayout(new GridLayout(10, 0));

        //ligne 0
        texte[0].setText("Authentification");
        add(texte[0]);

        //ligne 1
        form[0].setTexteString("Utilisateur");
        add(form[0].getOnPanel());

        //ligne 0
        form[1].setTexteString("Mot de passe");
        add(form[1].getOnPanel());

        //ligne 3
        texte[1].setText("");
        add(texte[1]);






        //ligne 4
        add(new Bouton("Log in",new Validation()));

    }


    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public  boolean Authentification_utilisateur(String Utilisateur,String Mdp)
    {System.out.println("-------------Test d'Authentification a faire return true actuelment------------- ");
    //on contourne pour pas remettrele mdp

        isopen=3;
        return true;
        /*
        if(Utilisateur.equals("u") && Mdp.equals("m"))
            {
                System.out.println("Correct utilisateur , mdp");
                isopen=1;

                return true;
            }
        else
            {
                texte[3].setText("Mauvais utilisateu/mdp");
                System.out.println("Mauvais utilisateu/mdp");
                return false;
            }
            */
    }

    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            if(Authentification_utilisateur(""+form[0].getContain(),""+form[1].getContain()))
            {System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§-----connection faite ---------§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");}}
    }
}