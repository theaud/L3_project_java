package Affichage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Menu extends JFrame {

    private Fenetre container    =new Fenetre();

    private Bouton[] Bouton     =new Bouton[1];
    private Form[]   Form       =new Form[1];
    private JLabel[] Texte      =new JLabel[1];
    private Fenetre[] Lign       =new  Fenetre[1];

    Menu()
    {

        //----------------------------Creation de la fenetre global ---------------------------------------------------------
        this.setTitle(" Menu ");
        this.setSize(250, 250);
        setMinimumSize(new Dimension(250, 250));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


//-----------------------Definir pan comme fond et l'afficher--------------------------------------


//---------------------------------------------------------------------------------------------

        container();
        this.setContentPane(container);
        this.setVisible(true);



    }

    private void container()
    {




    }












}
