package Graphique;

import javax.swing.*;


public class Ecran extends Fenetre {



    protected Bouton[] bouton    ;
    protected Form[]   form      ;
    protected JLabel[] texte    ;


    public Ecran() {

    }


    /**@param nbBouton bouton
     * @param nbForm   form
     * @param nbJpanel texte*/
    public void initialiser(int nbBouton,int nbForm,int nbJpanel)
    {   bouton    =Bouton.Tableau_Bouton(nbBouton);
        form      = Form.Tableau_Form(nbForm);
        texte     = Fenetre.Tableau_JLabel(nbJpanel);

    }




}
