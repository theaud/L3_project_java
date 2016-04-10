package Graphique;

import javax.swing.*;


public class Ecran extends Fenetre {


    protected Form[]   form      ;
    protected JLabel[] texte    ;


    public Ecran() {

    }


    /**@param nbForm   form
     * @param nbJpanel texte*/
    public void initialiser(int nbForm,int nbJpanel)
    {
        form      = Form.Tableau_Form(nbForm);
        texte     = Fenetre.Tableau_JLabel(nbJpanel);
    }




}
