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
        setBackground(Color.lightGray);

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
         case 4:name="afficher_emprunteur(id);";    afficher_emprunteur( id);   break;
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
 {name="Nouveau Emprunteur1";
     initialiser(5,1);split(7);

     form[0].setTexteString("Nom");         add(form[0]);
     form[1].setTexteString("Prenom");      add(form[1]);
     form[2].setTexteString("Adresse");     add(form[2]);
     form[3].setTexteString("Assurance");   add(form[3]);// =>  JCheckBox premier = new JCheckBox("Nom check box");
     texte[0].setText("");     add(texte[0]);

     add(new Bouton("Validation",new Validation()));
 }

    private void nouveau_Devis()
    {name="Nouveau Devis1";      initialiser(5,1);
    split(8);

        form[0].setTexteString("Id_emprunteur");    add(form[0]);
        form[1].setTexteString("Id_vehicule");      add(form[1]);
        form[2].setTexteString("Date_debut");       add(form[2]);
        form[3].setTexteString("Date_fin");         add(form[3]);// =>  JCheckBox premier = new JCheckBox("Nom check box");
        form[4].setTexteString("Tarif");            add(form[4]);
        texte[0].setText("");                       add(texte[0]);

        add(new Bouton("Validation",new Validation()));
    }

    private void nouveau_Vehicule()
    {name="Nouveau Vehicule1";initialiser(9,1);
        split(12);

        form[0].setTexteString("Nom");             add(form[0]);
        form[1].setTexteString("Marque");          add(form[1]);
        form[2].setTexteString("Modèle");          add(form[2]);
        form[3].setTexteString("Constructeur");    add(form[3]);
        form[4].setTexteString("Couleur");         add(form[4]);
        form[5].setTexteString("Kilomètrage");     add(form[5]);
        form[6].setTexteString("Moto ou Voiture"); add(form[6]);
        form[7].setTexteString("Luxe ou Standard");add(form[7]);
        form[8].setTexteString("Tarif");           add(form[8]);
        texte[0].setText("");     add(texte[0]);

        add(new Bouton("Validation",new Validation()));
    }

    private void afficher_emprunteur(int Id)
            {name="afficher_emprunteur Emprunteur";

                add(new JLabel("afficher_emprunteur Emprunteur"),BorderLayout.NORTH);
                add(Emprunteur.afficher_utilisateur_console(Id),BorderLayout.WEST);
                add(new JLabel("Le reste a remplir"),BorderLayout.EAST);

            }

    private void afficher_devis(int Id)
        {
            add(new JLabel("afficher_devis"),BorderLayout.NORTH);

        add(Gestion_BDD.afficher_Devis_console(Id));}

    private void afficher_vehicule(int Id)//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
        {
        System.out.println("afficher_vehicule pas coder WARNING on envoie rien actuelment");
        split(2);
        add(new JLabel("afficher_vehicule pas coder WARNING on envoie rien actuelment"));

        }

    private void Catalogue()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    {add(new JLabel("Catalogue"),BorderLayout.NORTH);




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
        p1.setLayout(new BorderLayout());p1.setBackground(Color.lightGray);


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




    private void retour_vehicule()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { add(new JLabel("retour_vehicule"),BorderLayout.NORTH);
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

        tableau+=Gestion_BDD.affichage_Bdd_entete(chemin,12);





        for(int i=0;i<CopieBdd.size() ;i++)
        {  if(Gestion_BDD.contrainte(CopieBdd.get(i) , contrainte)||contrainte.size()==0)
            {System.out.println("Hello World!");
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




    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;
            JOptionPane jop1 = new JOptionPane();
            for(int i=0;i<3;i++) { if(form[i].getContain().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------

            LinkedList<String> text=new LinkedList<String>();

            if(test)
                {

                    if(name=="Nouveau Emprunteur1")
                        {texte[0].setText("Nouveau Emprunteur cree");
                            for(int i=0;i<4;i++){text.add(form[i].getContain());}

                            Gestion_BDD. ajout("./src/BDD/Emprunteur/",text);
                        }
                    else if(name=="Nouveau Devis1")
                        {texte[0].setText("Nouveau Devis cree");
                            if(Gestion_BDD.existe("./src/BDD/Emprunteur/",Integer.parseInt("0"+form[0].getContain()))
                                    &&Gestion_BDD.existe("./src/BDD/Vehicule/",Integer.parseInt("0"+form[1].getContain())))
                            {
                                if(vehicule_disponible(Integer.parseInt("0"+form[1].getContain())))
                                {for(int i=0;i<5;i++){text.add(form[i].getContain());}
                                    Gestion_BDD. ajout("./src/BDD/Devis/",text);
                                }
                                else
                                { jop1.showMessageDialog(null, "Il n'y a plus assez de vehicule disponible", "Information", JOptionPane.INFORMATION_MESSAGE);}
                            }
                            else
                            {
                             if(Gestion_BDD.existe("./src/BDD/Emprunteur/",Integer.parseInt("0"+form[0].getContain())))
                                { jop1.showMessageDialog(null, "Le vehicule demander n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);}
                                 else
                                { jop1.showMessageDialog(null, "L'emprunteur demander n'existe pas", "Information", JOptionPane.INFORMATION_MESSAGE);}
                            }
                        }
                    else
                        {  texte[0].setText("Nouveau Vehicule cree");
                            for(int i=0;i<9;i++){text.add(form[i].getContain());}
                            text.add("0");
                            text.add("0");

                            Gestion_BDD.ajout("./src/BDD/Vehicule/",text);
                        }

                }
            else
                {texte[0].setText("(erreur) pas tous les champ remplie");}

        }
    }
    public static boolean vehicule_disponible(int id)
    {
        LinkedList<String> texte=Gestion_BDD.lecture("./src/BDD/Vehicule/",id);
        if((Integer.parseInt("0"+texte.get(10))-Integer.parseInt("0"+texte.get(11)))>0)
        {
            texte.set(11,""+(parseInt(texte.get(11))+1));

            return true;
        }
        return false;
    }

    class Retour implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {setIsopen(3);}  }


}
