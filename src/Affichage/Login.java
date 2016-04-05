package Affichage;


import Graphique.Ecran;
import Graphique.Lign;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends Ecran {



    public Login() {
        setSize(500, 300);
        setMinimumSize(new Dimension(500, 300));


        name="Login initialiser";
        setBackground(Color.pink);


        initialiser(1,2,4,5);
        Login_initialisation();

    }


    private void Login_initialisation()
    {
        //on modifie la taille des ligne
        lign= Lign.assemblage_ligne(lign,4,60);
//--------------------------------------------------------------------------------------------------------------

        //ligne 0
        texte[2].setText("Authentification");
        lign[0].add(texte[2]);

        //ligne 1
        texte[0].setText("Utilisateur");

        lign[1].add(texte[0]);
        lign[1].add(form[0]);

        //ligne 2
        texte[1].setText("Mot de passe");

        lign[2].add(texte[1]);
        lign[2].add(form[1]);


        //ligne 3
        texte[3].setText("");
        lign[3].add(texte[3]);

        //ligne 4
        bouton[0].addActionListener(new Validation());
        lign[4].add(bouton[0]);


        //on met les differentes lignes dans la fenetre
        add(lign,5);

    }












    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public  boolean Authentification_utilisateur(String Utilisateur,String Mdp)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Test d'Authentification a faire return true actuelment ");
        System.out.println("--------------------------------------------------");
        //on contourne pour pas remettrele mdp

        isopen=1;
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
            if(Authentification_utilisateur(""+form[0].getText(),""+form[1].getText()))
            {
                System.out.println("---------------yolo--------------------------");
            }

        }
    }




}
