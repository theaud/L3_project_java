package Affichage;

import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;
import Graphique.Fenetre;
import Graphique.Form;
import Location.Emprunteur;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class Fenetre_ajout extends Ecran {



    public Fenetre_ajout(int type,int id){
        name="Fenetre_ajout 1";


        if((4<=type && type <=6) ||type==7){setLayout(new BorderLayout());}
                                     else{split(10);}

        initialisation_formulaire(type,id);

        if((4<=type && type <=6) ||type==7)             {add(Bouton_retour(new Bouton("Retour",new Retour())),BorderLayout.SOUTH);}
                                      else            { add(Bouton_retour(new Bouton("Retour",new Retour())));}

    }


    private JPanel Bouton_retour(Bouton b)
    {   Fenetre panneau=new Fenetre();

        panneau.setLayout(new BorderLayout());

        panneau.add(b,BorderLayout.SOUTH);


        return panneau;
    }

    private void initialisation_formulaire(int type,int id)
    {
        switch (type) {
         case 4:name="afficher_emprunteur(id);";    afficher_emprunteur(id);   break;
         case 5:name="afficher_devis(id);";         afficher_devis(id);         break;
         case 6:name="afficher_vehicule(id);";      afficher_vehicule(id);      break;

         case 7:name="Catalogue;";      Catalogue();      break;

         case 8:name="nouveau_Emprunteur()";     nouveau_Emprunteur();          break;
         case 9: name="nouveau_Devis 1";         nouveau_Devis();               break;
         case 10:name="nouveau_Vehicule()";      nouveau_Vehicule();            break;

         case 11:name="retour_vehicule()";     retour_vehicule();          break;
         case 12: name="louer_vehicule";         louer_vehicule();               break;
         case 13:name="supprimer_vehicule()";      supprimer_vehicule();            break;

        }
    }

 private void nouveau_Emprunteur()
 {name="Nouveau Emprunteur";
     initialiser(5,0);split(7);
    add(titre("Nouveau Emprunteur",true));
     form[0].setTexteString("Nom");         add(form[0]);
     form[1].setTexteString("Prenom");      add(form[1]);
     form[2].setTexteString("Adresse");     add(form[2]);
     form[3].setTexteString("Assurance");   add(form[3]);// =>  JCheckBox premier = new JCheckBox("Nom check box");


     add(new Bouton("Validation",new Emprunteur()));
 }

    private void nouveau_Devis()
    {name="Nouveau Devis";      initialiser(5,0);
    split(8);add(titre("Nouveau Devis",true));

        form[0].setTexteString("Id_emprunteur");    add(form[0]);
        form[1].setTexteString("Id_vehicule");      add(form[1]);
        form[2].setTexteString("Date_debut");       add(form[2]);
        form[3].setTexteString("Date_fin");         add(form[3]);// =>  JCheckBox premier = new JCheckBox("Nom check box");
        form[4].setTexteString("Tarif");            add(form[4]);


        add(new Bouton("Validation",new Devis()));
    }

    private void nouveau_Vehicule()
    {name="Nouveau Vehicule";initialiser(9,0);
        split(12);
        add(titre("Nouveau Vehicule",true));
        form[0].setTexteString("Marque");          add(form[0]);
        form[1].setTexteString("Modèle");          add(form[1]);
        form[2].setTexteString("Constructeur");    add(form[2]);
        form[3].setTexteString("Couleur");         add(form[3]);
        form[4].setTexteString("Kilomètrage");     add(form[4]);
        form[5].setTexteString("Moto ou Voiture"); add(form[5]);
        form[6].setTexteString("Luxe ou Standard");add(form[6]);
        form[7].setTexteString("Tarif");           add(form[7]);


        add(new Bouton("Validation",new Vehicule()));
    }

    private void afficher_emprunteur(int Id) { System.out.println("= "+Id);
       add(Gestion_BDD.afficher_Emprunteur(Id));}
    private void afficher_devis(int Id)      { System.out.println("= "+Id);add(Gestion_BDD.afficher_Devis(Id));    }
    private void afficher_vehicule(int Id)   { System.out.println("= "+Id);add(Gestion_BDD.afficher_Vehicule(Id)); }

    private void Catalogue()
    {add(titre("Catalogue",true),BorderLayout.NORTH);

        add(Catalogue_tableau(),BorderLayout.WEST);

        JPanel droite=new JPanel();
        droite.setLayout(new GridLayout(8,1));
        droite.add(new Bouton("Ajout véhicule", new Pression())); droite.add(new JLabel(""));
        droite.add(new Bouton("Modifier un vehicule", new Pression()));droite.add(new JLabel(""));
        droite.add(new Bouton("Louer un vehicule", new Pression()));droite.add(new JLabel(""));
        droite.add(new Bouton("Supprimer un vehicule", new Pression()));droite.add(new JLabel(""));
        add(droite,BorderLayout.CENTER);

    }
    private JPanel Catalogue_tableau()
    {  JLabel tableau;
        JPanel p1=new JPanel();
        LinkedList<String>contrainte=new LinkedList<String>();
        p1.setLayout(new BorderLayout());


        JPanel p2=new JPanel(); p2.setLayout( new GridLayout(5, 2));

        JTextField[] recherche=new JTextField[2];
        JLabel[] texte=new JLabel[2];

        p2.add(new JLabel("barre de recherche"));       p2.add(new JLabel(""));

        for(int i=0;i<2;i++)
            {recherche[i]=new JTextField();
             texte[i]=new JLabel();
                recherche[i]=new JTextField();
                texte[i].setText("vide");
                if(!recherche[i].getText().equals("")){  contrainte.add(recherche[i].getText());}
            }
        for(int i=0;i<2;i++)
            { p2.add(new JLabel("filtre "+i+":"));
                p2.add(recherche[i]);
            }
        for(int i=0;i<2;i++)
            {p2.add(texte[i]);}



        recherche[0].addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent ke)
        {if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))        {texte[0].setText(recherche[0].getText()); }}});

        recherche[1].addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent ke)
        {if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))        { texte[1].setText(recherche[1].getText());} }});

        p1.add(p2,BorderLayout.SOUTH);



        tableau=Catalogue_voiture(contrainte);

        p1.add(tableau,BorderLayout.NORTH);
        return p1;

    }

    private void retour_vehicule()
    { add(titre("retour_vehicule",true),BorderLayout.NORTH);

        JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);


    }

    private void louer_vehicule()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { add(new JLabel("louer_vehicule"),BorderLayout.NORTH);
        JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);

    }

    private void supprimer_vehicule()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { add(new JLabel("supprimer_vehicule"),BorderLayout.NORTH);
        JOptionPane jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Vous avez supprimer un vehicule", "Information", JOptionPane.INFORMATION_MESSAGE);

    }

    private JLabel Catalogue_voiture(LinkedList<String>contrainte)//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { int max =12;
        String chemin="./src/BDD/Vehicule/";

        LinkedList<LinkedList<String>> CopieBdd=Gestion_BDD.CopieBdd(chemin);

        String tableau="<html><table>";

        tableau+=Gestion_BDD.affichage_Bdd_entete(chemin,11);





        for(int i=0;i<CopieBdd.size() ;i++)
        {  if(Gestion_BDD.contrainte(CopieBdd.get(i) , contrainte)||contrainte.size()==0)
            {
                tableau+="<tr>";
                for(int j=0;j<CopieBdd.get(i).size()&&j<max;j++)// a faire le cas par cas
                    {if(j==112)
                        {}
                     else if(i==11)
                        {}
                    else
                        {tableau+="<td>"+CopieBdd.get(i).get(j)+"</td>";}
                    }
                tableau+="</tr>";
            }
        }
        tableau+="</table></html>";


        JLabel returned= new JLabel(tableau);

        return returned;

    }

    public static JPanel titre(String titre,boolean color)
    {
        JPanel returned=new JPanel();
        JLabel texte=new JLabel("<html><h1>"+titre+"</h1><html>");

        if(color){returned.setBackground(Color.lightGray);}
        returned.setLayout(new BorderLayout());


        returned.setLayout(new GridLayout(1,4));
        for(int i=0;i<2;i++)        {returned.add(new JLabel(""));}
        returned.add(texte);
        for(int i=0;i<1;i++)        {returned.add(new JLabel(""));}






        return returned;
    }


    private void split(int i){GridLayout Layout=new GridLayout(i, 1);    Layout.setVgap(10);     setLayout(Layout);}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static  LinkedList<String> add(String t1,String t2,String t3,String t4,String t5)
    {LinkedList<String> text=new LinkedList<String>();
        text.add(t1);        text.add(t2);        text.add(t3);        text.add(t4);    text.add(t5);
        return text;
    }





    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {String press=arg0.getActionCommand();

            if      (press.equals("Ajout véhicule"))      {setIsopen(10);}
            else if(press.equals("Modifier un vehicule"))  {setIsopen(10);}
            else if(press.equals("Louer un vehicule"))     {setIsopen(9);}

            else if(press.equals("Supprimer un vehicule"))  {setIsopen(7);}
        }
    }


    class Emprunteur implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            JOptionPane jop = new JOptionPane();
            boolean test=true;
            LinkedList<String> text = new LinkedList<String>();
            for (int i = 0; i < 3; i++) {
                if (form[i].getContain().equals("")) {
                    test = false;
                } else
                {
                    text.add(form[i].getContain());
                }
            }
            if (form[4].getContain().equals(""))            {text.add("false");}
            else{text.add("true");}


//------------------------------------------------------------------------------------------------------
                if (test) {


                        text.add("0");
                        Gestion_BDD.ajout("./src/BDD/Emprunteur/", text);
                    jop.showMessageDialog(null, "Nouveau Emprunteur cree id:"+Gestion_BDD.getIdLast("./src/BDD/Emprunteur/"), "information", JOptionPane.INFORMATION_MESSAGE);

// --------------------------------------------------------------------------------------------------------------------------------------
                } else {
                    jop.showMessageDialog(null, "(erreur) pas tous les champ remplie", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
        }
    }

    class Devis implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            JOptionPane jop = new JOptionPane();
            boolean test=true;
            LinkedList<String> text = new LinkedList<String>();
            for (int i = 0; i < 5; i++) {
                if (form[i].getContain().equals("")) {
                    test = false;
                }
            }
//---------------------------------------------------------------------------------------------------------------------------------------------------------
                if (test)
                    {
                            if (Gestion_BDD.existe("./src/BDD/Emprunteur/", Integer.parseInt("0" + form[0].getContain())) && Gestion_BDD.existe("./src/BDD/Vehicule/", Integer.parseInt("0" + form[1].getContain())))
                            {if (vehicule_disponible(Integer.parseInt("0" + form[1].getContain())))
                                { for (int i = 0; i < 5; i++)
                                    {text.add(form[i].getContain());}
                                    Gestion_BDD.ajout("./src/BDD/Devis/", text);
                                    jop.showMessageDialog(null, "Le nouveau utilisateur a ete ajouter son id est:"+Gestion_BDD.getIdLast("./src/BDD/Devis/"), "Information", JOptionPane.INFORMATION_MESSAGE);
                                }
                            else
                                { jop.showMessageDialog(null, "Il n'y a plus assez de vehicule disponible", "Information", JOptionPane.INFORMATION_MESSAGE);}
                            }
                   }
                else
                    {jop.showMessageDialog(null, "(erreur) pas tous les champ remplie", "Erreur", JOptionPane.ERROR_MESSAGE);}

        }





    }  class Vehicule implements ActionListener {

        private LinkedList<String> entrer()
        {  LinkedList<String> text = new LinkedList<String>();
            boolean test=true;

            for (int i = 0; i < 5; i++)
                {if (form[i].getContain().equals(""))
                     {test = false; }
                 else
                    {text.add(form[i].getContain());}
                 }

            for (int i = 5; i < 7; i++)
            {if(form[i].getContain().equals("")){text.add("false");}
            else{text.add("true"); }
            }

            if (form[7].getContain().equals("")) {test = false;}
            else {text.add(form[7].getContain());}

            if(test)
                {return text;}
            else
             { return new LinkedList<String>(); }
        }





        public void actionPerformed(ActionEvent arg0) {
            JOptionPane jop = new JOptionPane();

            LinkedList<String> text=entrer();
 //---------------------------------------------------------------------------------------------------------------------
            if (text.size()>0) //ajout de ce vehicule a la flotte
            {   text.add("1");
                text.add("0");
                Gestion_BDD.ajout("./src/BDD/Vehicule/", text);
                jop.showMessageDialog(null, "Le vehicule a ete ajouter a la flotte son id est:"+Gestion_BDD.getIdLast("./src/BDD/Vehicule/"), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                {jop.showMessageDialog(null, "(erreur) pas tous les champ remplie", "Erreur", JOptionPane.ERROR_MESSAGE);}
        }
    }


    public static boolean vehicule_disponible(int id) {
        LinkedList<String> texte = Gestion_BDD.lecture("./src/BDD/Vehicule/", id);


        for (int i=0;i<texte.size();i++){ System.out.println(i+" "+ texte.get(i));}


        if ((Integer.parseInt("0" + texte.get(9)) - Integer.parseInt("0" + texte.get(10))) > 0) {
            texte.set(10, "" + (parseInt(texte.get(10)) + 1));

            return true;
        }
        return false;
    }

    class Retour implements ActionListener {
            public void actionPerformed(ActionEvent arg0) {
                setIsopen(3);
            }
        }
    }


