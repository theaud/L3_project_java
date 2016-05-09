package Affichage;

import Affichage.*;
import BDD.Gestion_BDD;
import Graphique.Ecran;

import javax.swing.*;
import java.awt.*;

public class Panneau extends JFrame {

    protected Affichage.Menu Ecran_menu    =new Affichage.Menu();
    protected Ecran Ecran_actif  ;

    public Panneau() {   Ecran_actif = Ecran_menu;

        this.setSize(1000, 1000);
        setMinimumSize(new Dimension(1000, 1000));

        this.setTitle(Ecran_actif.getName());

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//--------------------------------------------

        Ecran_menu.setBackground(Color.LIGHT_GRAY);

//--------------------------------------------
        changement_Ecran(new Login());//on se place a la connection sur la page login

        this.setContentPane(Ecran_actif);


        setVisible(true);


        gestion_fenetre();
    }

    public void changement_Ecran(Ecran nouveau_Ecran)
    {   Ecran_actif=nouveau_Ecran;
        actualisation();

    }

    public void retour_Menu()
    {   Ecran_actif=Ecran_menu; getEcran_actif().setIsopen(0);
        actualisation();
    }


    public void actualisation()
    {   stopIsopen();
        this.setContentPane(Ecran_actif);
        this.setTitle(Ecran_actif.getName());
        repaint();
        revalidate();
    }
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

    public void gestion_fenetre()
    {//on reste dans la boucle en permanence , on peut tout de meme quitter le programme par la croix rouge
       int Isopen;
        int Id=Ecran_menu.id;
        System.out.println("rendu id="+Id);
        while(true)
        {Isopen=getEcran_actif().getIsopen();
            if(Isopen!=0)
            {if((4<=Isopen && Isopen<=6) || (8<=Isopen && Isopen<=10) || Isopen==7 || (11<=Isopen && Isopen<=13))
                {int type=Isopen;

                 changement_Ecran(new Fenetre_ajout(type,Id));
                stopIsopen();}
            else
                {switch (Isopen)
                    {case 0:break;//No move
                        //------------------------------------------------------------------------------------------------------------------
                    case 2://-----------------------Login--------------------------------
                            getEcran_actif().setIsopen(3);
                            changement_Ecran(new Login());
                            break;
                    case 3://------------------------Menu--------------------------------
                            getEcran_actif().setIsopen(2);
                            retour_Menu();
                            break;

                    default:
                            break;
                    }
                    stopIsopen();
                }
            }
        }
    }


//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------


    public Ecran getEcran_actif() {        return Ecran_actif;    }
    public void setEcran_actif(Ecran ecran_actif) {        Ecran_actif = ecran_actif;    }

    public Affichage.Menu getEcran_menu() {        return Ecran_menu;    }
    public void setEcran_menu(Affichage.Menu ecran_menu) {        Ecran_menu = ecran_menu;    }

    public void stopIsopen(){Ecran_actif.setIsopen(0);}


}
