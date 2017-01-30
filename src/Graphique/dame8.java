package Graphique;

import Graphique.Jpanel.Jframeadd;
import Graphique.aide.Casee;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


/**
 * Created by mathieu on 30/01/2017.
 */
public class dame8 extends Jframeadd{


    public JPanel damier = new JPanel();
    public LinkedList<Casee> Case=new LinkedList<>();

    public GridLayout Layout=Layout();

  //  public LinkedList<ComplexeInt> dame=new LinkedList<>();

        public dame8()
        { this.setTitle("dame8");
            creation_damier();
            damier.setPreferredSize(new Dimension(1000, 1000));
            damier.setBackground(Color.RED);


            damier.setLayout(Layout);






         //   placer_piece(1,1);


            //On ajoute le conteneur
            this.setContentPane(damier);
            this.setVisible(true);
        }




    private void creation_damier()
    {

        for(int i=0;i<8;i++)
            for (int j = 0; j < 8; j++) {
                Casee tmp = new Casee();
                tmp.top.setText("" + (i * 8 + j));

                damier.add(tmp);
                tmp.center.setText("vide");

                damier.getComponent(i * 8 + j).setBackground(new Color((i + j) % 2 * 255, (i + j) % 2 * 255, (i + j) % 2 * 255));
                damier.getComponent(i * 8 + j).setPreferredSize(new Dimension(100, 100));
            }

    }



    public void placer_piece(int position,int valeur)
    {
        if(position>=0 &&position<64)
        {
            switch (valeur)
            {
                case 1:damier.getComponent(position).setBackground(Color.cyan);


                    damier.getComponent(position).setBackground(Color.blue);

                    break;
            }

        }



    }

    private GridLayout Layout()
    {GridLayout Layout=new GridLayout(9, 9);
        Layout.setHgap(5);
        Layout.setVgap(5);

        return Layout;
    }


}



















