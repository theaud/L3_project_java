package Affichage;

import Graphique.Bouton;
import Graphique.Fenetre;
import Graphique.Lign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Login extends JFrame {

    private static final int Width=250;
    private static final int Height=250;

    private Fenetre container    =new Fenetre();
    private Bouton[] bouton    =Bouton.Tableau_Bouton(1);
    private Form[]   form      =Form.Tableau_Form(2);
    private JLabel[] texte     =Fenetre.Tableau_JLabel(3);
    private Lign[] lign     =Lign.assemblage_ligne(4);
    private boolean ouvert=true;

    public Login() {
        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle(" Login ");
        this.setSize(Width, Height);
        setMinimumSize(new Dimension(Width,Height));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new MyWindowListener());//ecoute sur les fenetres

        container();
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void container()
    {
        //ligne 0
        texte[2].setText("Authentification");
        lign[0].add(texte[2]);

        //ligne 1
        texte[0].setText("Utilisateur");

        texte[0].setPreferredSize(new Dimension(getWidth()/3, 30));
        form[0].setPreferredSize(new Dimension(getWidth()/3, 30));

        lign[1].add(texte[0]);
        lign[1].add(form[0]);

        //ligne 2
        texte[1].setText("Mot de passe");

        texte[1].setPreferredSize(new Dimension(getWidth()/3, 30));
        form[1].setPreferredSize(new Dimension(getWidth()/3, 30));
        lign[2].add(texte[1]);
        lign[2].add(form[1]);
        //ligne 3

        bouton[0].setPreferredSize(new Dimension(getWidth()/2,25));
        bouton[0].addActionListener(new Validation());
        lign[3].add(bouton[0]);

// mise des lignes dans le container afin d'etre afficher
        container.add(lign,new Dimension(getWidth(), getHeight() / 5), 4);
    }

    public  boolean Authentification_utilisateur(String Utilisateur,String Mdp)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Test d'Authentification a faire return true actuelment ");
        System.out.println("Utilisateur :"+Utilisateur+"\nMdp: "+Mdp);

        if(Utilisateur.equals("u") && Mdp.equals("m"))
            {
                System.out.println("Correct utilisateur , mdp");
                Menu Menu=new Menu();
                setVisible(false);
                return false;
            }
        else
            {
                System.out.println("Mauvais utilisateu/mdp");
                return true;
            }
    }

    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            if(Authentification_utilisateur(""+form[0].getText(),""+form[1].getText()))
            {
                System.out.println("--------------------------------------------------");
            }

        }
    }

    class MyWindowListener implements WindowListener {
        public void windowActivated (WindowEvent e) {}
        public void windowClosed (WindowEvent e) {System.exit(0);}
        public void windowClosing (WindowEvent e) {

            ouvert=false;
            // code ajouté
            ((Frame)e.getSource()).dispose();
        }
        public void windowDeactivated (WindowEvent e) {}
        public void windowDeiconified (WindowEvent e) {}
        public void windowIconified (WindowEvent e) {}
        public void windowOpened (WindowEvent e) {}
    }

    public boolean isOuvert() {return ouvert;}
    public void setOuvert(boolean ouvert) {this.ouvert = ouvert;}
}
