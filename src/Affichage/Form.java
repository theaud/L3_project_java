package Affichage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mathieu on 11/03/2016.
 */
public class Form extends JTextField {


    Form()
    {
     setPreferredSize(new Dimension(50, 30));

    }


    public static  Form[] Tableau_Form(int size)
    { Form[] form     =new Form[size];
        for(int i=0;i<size;i++)
        {form[i]=new Form();}
        return form;
    }



}
