package Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Login extends JFrame {


    private Fenetre container    =new Fenetre();
    private Bouton[] Bouton     =new Bouton[1];
    private Form[]   Form       =new Form[2];
    private JLabel[] Texte      =new JLabel[3];
    private Fenetre[] Lign       =new  Fenetre[4];
    private boolean ouvert=true;

    public Login() {
        //---------------------------initiation des tableaux  ---------------------------------------------------------------
        for(int i=0;i<1;i++){Bouton[i]=new Bouton("Valider");}
        for(int i=0;i<2;i++){Form[i]=new Form();}
        for(int i=0;i<3;i++){Texte[i]=new JLabel("texte");}
        for(int i=0;i<4;i++){Lign[i]=new Fenetre();}

        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle(" Login ");
        this.setSize(250, 250);
        setMinimumSize(new Dimension(250, 250));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new MyWindowListener());//ecoute sur les fenetres


//-----------------------Definir pan comme fond et l'afficher--------------------------------------


//---------------------------------------------------------------------------------------------

        container();
        this.setContentPane(container);
        this.setVisible(true);
    }


    private void container()
    {
        //ligne 0
        Texte[2].setText("Authentification");
        Lign[0].add(Texte[2]);

        //ligne 1
        Texte[0].setText("Utilisateur");

        Texte[0].setPreferredSize(new Dimension(getWidth()/3, 30));
        Form[0].setPreferredSize(new Dimension(getWidth()/3, 30));

        Lign[1].add(Texte[0]);
        Lign[1].add(Form[0]);

        //ligne 2
        Texte[1].setText("Mot de passe");

        Texte[1].setPreferredSize(new Dimension(getWidth()/3, 30));
        Form[1].setPreferredSize(new Dimension(getWidth()/3, 30));
        Lign[2].add(Texte[1]);
        Lign[2].add(Form[1]);
        //ligne 3

        Bouton[0].setPreferredSize(new Dimension(getWidth()/2,25));
        Lign[3].add(Bouton[0]);

// mise des lignes dans le container afin d'etre afficher
        container.add(Lign,new Dimension(getWidth(), getHeight() / 5), 4);



    }




    class MyWindowListener implements WindowListener {
        public void windowActivated (WindowEvent e) {}
        public void windowClosed (WindowEvent e) {System.exit(0);}
        public void windowClosing (WindowEvent e) {
            System.out.println("On ferme la fenetre");
            ouvert=false;
            // code ajouté
            ((Frame)e.getSource()).dispose();
        }
        public void windowDeactivated (WindowEvent e) {}
        public void windowDeiconified (WindowEvent e) {}
        public void windowIconified (WindowEvent e) {}
        public void windowOpened (WindowEvent e) {}
    }


    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
}
