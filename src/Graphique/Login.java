package Graphique;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Login extends Ecran {



    public Login() {

        name="Login initialiser";
        setBackground(Color.pink);


        initialiser(1,2,3,4);
        Login_initialisation();

    }


    private void Login_initialisation()
    {int largeur=500;

        //ligne 0
        texte[2].setText("Authentification");
        lign[0].add(texte[2]);

        //ligne 1
        texte[0].setText("Utilisateur");

        form[0].setPreferredSize(new Dimension(largeur/3, 30));

        lign[1].add(texte[0]);
        lign[1].add(form[0]);

        //ligne 2
        texte[1].setText("Mot de passe");

        form[1].setPreferredSize(new Dimension(largeur/3, 30));
        lign[2].add(texte[1]);
        lign[2].add(form[1]);

        //ligne 3
        bouton[0].addActionListener(new Validation());
        lign[3].add(bouton[0]);


        for(int i=0;i<4;i++) {add(lign[i]);}

    }




















    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public  boolean Authentification_utilisateur(String Utilisateur,String Mdp)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Test d'Authentification a faire return true actuelment ");
        System.out.println("Utilisateur :|"+Utilisateur+"|\nMdp: |"+Mdp+"|");

        if(Utilisateur.equals("u") && Mdp.equals("m"))
            {
                System.out.println("Correct utilisateur , mdp");
                isopen=0;

                return true;
            }
        else
            {
                System.out.println("Mauvais utilisateu/mdp");
                return false;
            }
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
