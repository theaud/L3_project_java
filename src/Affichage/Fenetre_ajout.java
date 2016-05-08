package Affichage;

import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;
import Graphique.Fenetre;
import Graphique.Form;
import Location.Emprunteur;


import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Fenetre_ajout extends Ecran {



    public Fenetre_ajout(int type,int id){
        name="Fenetre_ajout 1";
        setBackground(Color.pink);

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
         case 10:name="nouveau_Vehicule()";      nouveau_Vehicule();            break;}
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
        add(Emprunteur.afficher_utilisateur_console(Id));

        }
    private void Catalogue()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    {add(new JLabel("Cataloguue 22"),BorderLayout.NORTH);

        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());p1.setBackground(Color.cyan);


        JPanel p2=new JPanel(); p2.setLayout( new GridLayout(5, 2));

        JTextField recherche1=new JTextField();

        JTextField recherche2=new JTextField();
        p2.add(new JLabel("Barre de recherche"));   p2.add(new JLabel(""));
        p2.add(new JLabel("filtre 1:"));       p2.add(recherche1);
        p2.add(new JLabel("filtre 2:"));        p2.add(recherche2);
        JLabel a=new JLabel("vide");        JLabel z=new JLabel("vide");
        p2.add(a);        p2.add(z);

        recherche1.addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent ke)
            {if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))
                {System.out.println("User is editing something in TextField:"+recherche1.getText());
                a.setText(recherche1.getText());
                    System.out.println("contrainte1 :|"+recherche1.getText()+"| contrainte2= |"+recherche2.getText()+"|");
                }
            }
        });
        recherche2.addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent ke)
            {if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))
                { System.out.println("User is editing something in TextField :"+recherche2.getText()+" ");
                   z.setText(recherche1.getText());

                    System.out.println("contrainte1 :|"+recherche1.getText()+"| contrainte2= |"+recherche2.getText()+"|");
                }
            }
        });




        p1.add(p2,BorderLayout.SOUTH);

        LinkedList<String>contrainte=new LinkedList<String>();
        System.out.println("contrainte1 :|"+recherche1.getText()+"| contrainte2= |"+recherche2.getText()+"|");
        JLabel tableau;
        contrainte.add(recherche1.getText());///§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
        contrainte.add(recherche2.getText());
        contrainte.add("j");

         tableau=Catalogue_voiture(contrainte);

        p1.add(tableau,BorderLayout.NORTH);


        add(p1,BorderLayout.WEST);

        JPanel droite=new JPanel();
        droite.setLayout(new GridLayout(8,1));
        droite.add(new Bouton("Ajout véhicule", new Pression())); droite.add(new JLabel(""));
        droite.add(new Bouton("Modifier un vehicule", new Pression()));droite.add(new JLabel(""));
        droite.add(new Bouton("Louer un vehicule", new Pression()));droite.add(new JLabel(""));
        droite.add(new Bouton("Supprimer un vehicule", new Pression()));droite.add(new JLabel(""));
        add(droite,BorderLayout.CENTER);

    }

    private void retour_vehicule()//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { add(new JLabel("retour_vehicule"),BorderLayout.NORTH);



    }



    private JLabel Catalogue_voiture(LinkedList<String>contrainte)//§§§§§§§§§§§§§§§§§§§§§§§§§§ pas fait
    { int max =12;
        String chemin="./src/BDD/Vehicule/";

        LinkedList<LinkedList<String>> CopieBdd=Gestion_BDD.CopieBdd(chemin);

        String tableau="<html><table>";

        tableau+=Gestion_BDD.affichage_Bdd_entete(chemin,12);





        for(int i=0;i<CopieBdd.size() ;i++)
        { System.out.println(Gestion_BDD.contrainte(CopieBdd.get(i) ,contrainte) +" "+(contrainte.size()==0));


            if(Gestion_BDD.contrainte(CopieBdd.get(i) , contrainte)||contrainte.size()==0)
            {System.out.println("Hello World!");
                tableau+="<tr>";
                for(int j=0;j<CopieBdd.get(i).size()&&j<max;j++)
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
        returned.setForeground(Color.RED);
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








    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if((e.getKeyCode()==KeyEvent.VK_ENTER))
            System.out.println("vous avez apuyer sur entrer");
    }



    public void keyReleased(KeyEvent e) {        // TODO Auto-generated method stub
    }

    public void keyTyped(KeyEvent e) {        // TODO Auto-generated method stub
    }


    class Pression implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {String press=arg0.getActionCommand();

            if      (press.equals("Emprunteur ID"))      {setIsopen(4);}
            else if(press.equals("Devis ID"))           {setIsopen(5);}
            else if(press.equals("Vehicule ID"))        {setIsopen(6);}

            else if(press.equals("Voir le Catalogue"))  {setIsopen(7);}
        }
    }

    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;

            for(int i=0;i<3;i++) { if(form[i].getContain().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {
                    LinkedList<String> text=new LinkedList<String>();

                    if(name=="Nouveau Emprunteur1")
                        {texte[0].setText("Nouveau Emprunteur cree");
                            for(int i=0;i<4;i++){text.add(form[i].getContain());}

                            Gestion_BDD. ajout("./src/BDD/Emprunteur/",text);
                        }
                    else if(name=="Nouveau Devis1")
                        {texte[0].setText("Nouveau Devis cree");
                            for(int i=0;i<5;i++){text.add(form[i].getContain());}
                            Gestion_BDD. ajout("./src/BDD/Devis/",text);
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


    class Retour implements ActionListener {
        public void actionPerformed(ActionEvent arg0)
        {setIsopen(3);}  }


}
