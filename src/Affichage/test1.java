package Affichage;

import javax.swing.*;



public class test1 extends JFrame {

    public test1(){

        this.setTitle("Box Layout");
        this.setSize(300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel[] Ligne = new JPanel[10];
        JPanel total = new JPanel();
        total.setLayout(new BoxLayout(total, BoxLayout.PAGE_AXIS));
        for (int i=0;i<10;i++)
            {Ligne[i]=new JPanel();
             Ligne[i].setLayout(new BoxLayout(Ligne[i], BoxLayout.LINE_AXIS));
             Ligne[i].add(new JButton("Bouton "+i));
             Ligne[i].add(new JButton("Bouton "+i));
             Ligne[i].add(new JButton("Bouton "+i));
                Ligne[i].add(new JButton("Bouton "+i));
                Ligne[i].add(new JButton("Bouton "+i));
                Ligne[i].add(new JButton("Bouton "+i));


                total.add(Ligne[i]);
            }

        this.getContentPane().add(total);

        this.setVisible(true);
    }
}