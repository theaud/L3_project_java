package Affichage;

import javax.swing.*;
import java.awt.*;

public class Form extends JTextField {


    Form()
    {
     setPreferredSize(new Dimension(100, 30));

    }


    public static  Form[] Tableau_Form(int size)
    { Form[] form     =new Form[size];
        for(int i=0;i<size;i++)
        {form[i]=new Form();}
        return form;
    }



}
