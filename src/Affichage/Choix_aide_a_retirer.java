package Affichage;

import Graphique.Bouton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Choix_aide_a_retirer extends JFrame {

    private JPanel container = new JPanel();
    private Bouton[] Lbouton = new Bouton[7];

    public Choix_aide_a_retirer() {
        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle("Choix_aide_a_retirer de l'exercice et de la fenetre assimiler");
        this.setSize(400, 200);
        setMinimumSize(new Dimension(350, 350));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//-----------------------Definir pan comme fond et l'afficher--------------------------------------


//---------------------------------------------------------------------------------------------

        container();
        this.setContentPane(container);
        this.setVisible(true);
    }

    public void container() {
        JPanel[] LJpanel = new JPanel[7];


        for (int i = 0; i < 7; i++) {
            Lbouton[i] = new Bouton("Exercice " + (1 + i));


            Lbouton[i].setPreferredSize(new Dimension(getWidth(), getHeight() / 9));
            Lbouton[i].addActionListener(new choix());

            container.add(Lbouton[i]);
        }


    }

    class choix implements ActionListener {
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent arg0) {

        }
    }
}


