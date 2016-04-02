package Graphique;

import Affichage.Form;

import javax.swing.*;
import java.awt.*;


public class Ecran extends Fenetre {



    protected Bouton[] bouton    ;
    protected Form[]   form      ;
    protected JLabel[] texte    ;
    protected Lign[]   lign        ;

    public Ecran() {





    }


    /**@param nbBouton bouton
     * @param nbForm   form
     * @param nbJpanel texte
     * @param nbLign   lign*/
    public void initialiser(int nbBouton,int nbForm,int nbJpanel,int nbLign)
    {   bouton    =Bouton.Tableau_Bouton(nbBouton);
        form      = Form.Tableau_Form(nbForm);
        texte     = Fenetre.Tableau_JLabel(nbJpanel);
        lign      =Lign.assemblage_ligne(nbLign);



    }
































}
