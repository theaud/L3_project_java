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




/*
            placer_dame(3);
            placer_dame(14);
            placer_dame(18);
            placer_dame(31);
            placer_dame(33);
            placer_dame(44);
            placer_dame(48);
            placer_dame(61);
*/

            recherche_solution();



            //On ajoute le conteneur
            this.setContentPane(damier);
            this.setVisible(true);
        }




    private void creation_damier()
    {

        for(int i=0;i<8;i++)
        {for (int j = 0; j < 8; j++) {
                Casee tmp = new Casee();
                tmp.top.setText("" + (i * 8 + j));

                damier.add(tmp);
                tmp.center.setText("vide");

                damier.getComponent(i * 8 + j).setBackground(new Color((i + j) % 2 * 255, (i + j) % 2 * 255, (i + j) % 2 * 255));
                damier.getComponent(i * 8 + j).setPreferredSize(new Dimension(100, 100));
            }}






    }


    public LinkedList<int []> recherche_solution()
    {
        LinkedList<int []>Lsolution=new LinkedList<>();



        arbreSolution a=new arbreSolution(0,0);

        a.afficher(0,2);






        return Lsolution;
    }


    public void placer_dame(int[]  position)
    {for(int i=0;i<8;i++)
        {placer_dame(position[i]);}
    }


    public void placer_dame(int position)
    {
        int X,Y,x,y;
        Color background;
       int i=position;


            background= damier.getComponent(i ).getBackground();
            if(background.equals(Color.black) ||background.equals(Color.WHITE))
            {
                X=i%8;
                Y=i/8;
                System.out.println("X= "+X+"Y ="+Y);

                placer_piece(i,1);
                for(int j=0;j<64;j++)
                {x=j%8;
                 y=j/8;

                if(i==j)
                    {placer_piece(j,1);}
                else if(X==x && Y!=y)
                    { placer_piece(j,2);  System.out.println("X= "+x);}
                else if(Y==y && X!=x)
                   { placer_piece(j,2);System.out.println("Y= "+y);}
                else if((X-x)==(Y-y))
                    { placer_piece(j,2);System.out.println("Y= "+y);}
                else if((X-x)==(y-Y))
                { placer_piece(j,2);System.out.println("Y= "+y);}
                else
                {}


                }
            }






    }



    public void placer_piece(int position,int valeur)
    {
        if(position>=0 &&position<64)
        {
            switch (valeur)
            {
                case 1: damier.getComponent(position).setBackground(Color.cyan);break;
                case 2: Color couleur=damier.getComponent(position).getBackground();

                    if(couleur.equals(Color.BLACK)||couleur.equals(Color.WHITE))
                {damier.getComponent(position).setBackground(Color.green);break;}


               default:/*
                   if(((position%8)+(position/8))%2==0)
                        { damier.getComponent(position).setBackground(Color.BLACK);break;}
                    else
                        { damier.getComponent(position).setBackground(Color.white);break;}
*/


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



















