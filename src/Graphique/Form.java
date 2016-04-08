package Graphique;

import javax.swing.*;
import java.awt.*;

public class Form  {


   protected JLabel     texte;
   protected JTextField form;


    public Form()
    {texte=new JLabel("no texte2");
     texte.setPreferredSize(new Dimension(100, 25));
     texte.setLayout(new BorderLayout());
        constructeur();
    }

    public Form(String Texte)
    {texte=new JLabel(Texte);
        constructeur();
    }
    private void constructeur()
    {  form=new JTextField();
        form.setPreferredSize(new Dimension(100, 25));
        form.setLayout(new BorderLayout());
    }

/*
    setSize(500, 300);
    setMinimumSize(new Dimension(500, 300));
    set

    name="Login initialiser";
    setBackground(Color.pink);
 */



    public static  Form[] Tableau_Form(int size)
    { Form[] form     =new Form[size];
        for(int i=0;i<size;i++)
        {form[i]=new Form("no texte");}
        return form;
    }




    public JLabel getTexte() {return texte;}
    public void setTexte(JLabel texte) {this.texte = texte;}

    public String getTexteString() {return texte.getText();}
    public void setTexteString(String texte) {this.texte.setText(texte);}

    public JTextField getForm() {return form;}
    public void setForm(JTextField form) {this.form = form;}

    public String getContain() {return form.getText();}
    public void setContain(String Contain) {this.form.setText(Contain) ;}

    public  JPanel getOnPanel() {JPanel returned=new JPanel();
        returned.add(texte);
        returned.add(form);
        returned.setBackground(Color.lightGray);


        return returned;}


}
