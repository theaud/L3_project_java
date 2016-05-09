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
    {setLayout(new BorderLayout());



        add(Fenetre_ajout.titre("Authentification",true),BorderLayout.NORTH);
        //ligne 1

        JPanel centre=new JPanel();
        centre.setLayout(new GridLayout(3,1));
        form[0].setTexteString("Utilisateur");
        centre.add(form[0].getOnPanel());

        //ligne 0
        form[1].setTexteString("Mot de passe");
        centre.add(form[1].getOnPanel());

        //ligne 3
        centre.add(new JLabel("<html><p>utilisateur ='u' <br> mdp='m'<p><html>"));

        add(centre,BorderLayout.CENTER);




        //ligne 4
        add(new Bouton("Log in",new Validation()),BorderLayout.SOUTH);

    }


    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public  boolean Authentification_utilisateur(String Utilisateur,String Mdp)
    {
    //on contourne pour pas remettrele mdp

        isopen=3;
        return true;
        /*
        if(Utilisateur.equals("u") && Mdp.equals("m"))
            {

                isopen=1;

                return true;
            }
        else
            {
             JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Mauvais utilisateu/mdp", "Information", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            */
    }

    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            if(Authentification_utilisateur(""+form[0].getContain(),""+form[1].getContain())) {}}}
}