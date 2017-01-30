package Graphique.aide;

import javax.swing.*;

/**
 * Created by mathieu on 30/01/2017.
 */
public class Casee extends JPanel{

    public JLabel top=new JLabel("1");
    public JLabel center=new JLabel("Dame");

    public Casee()
    {
        add("PAGE_START",top);
        add("LINE_END",center);
    }


    public JLabel getTop()
    {return top;}


}
