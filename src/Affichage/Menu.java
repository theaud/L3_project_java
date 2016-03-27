package Affichage;

import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame {

    private static final int Width=500;
    private static final int Height=500;

    private Fenetre container    =new Fenetre();

    private Bouton[]  bouton    =Bouton.Tableau_Bouton(10);
    private Form[]    form      =Form.Tableau_Form(10);
    private JLabel[]  texte     =Fenetre.Tableau_JLabel(10);
    private Fenetre[] lign      =Fenetre.Tableau_Fenetre(10);

    Menu()
    { //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle(" Menu ");
        this.setSize(Width, Height);
        setMinimumSize(new Dimension(Width, Height));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        container();
        this.setContentPane(container);
        this.setVisible(true);

    }

    private void container()
    {

        System.out.println(getWidth()+"  "+getHeight());

        for(int i=0;i<10;i++)
        {
            texte[i].setText("Yolo "+i);
            lign[i].setSize(getWidth(),33);
            System.out.println(lign[i].getWidth());

            lign[i].add(texte[i]);

            lign[i].setBackground(Color.lightGray);
            container.add(lign[i]);
        }


    }
}
