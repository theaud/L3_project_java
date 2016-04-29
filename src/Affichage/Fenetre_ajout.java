package Affichage;

import BDD.Gestion_BDD;
import Graphique.Bouton;
import Graphique.Ecran;
import Graphique.Fenetre;
import Location.Emprunteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Fenetre_ajout extends Ecran {



    public Fenetre_ajout(int type,int id){
        name="Fenetre_ajout 1";
        setBackground(Color.pink);


        split(10);
        initialisation_formulaire(type,id);
        add(Bouton_retour(new Bouton("Retour",new Retour())));
    }


    private JPanel Bouton_retour(Bouton b)
    {   Fenetre panneau=new Fenetre();
        panneau.setLayout(new GridLayout(3, 3));
        for(int i=0;i<4;i++){panneau.add(new Label(""));}
        panneau.add(b);
        for(int i=0;i<4;i++){panneau.add(new Label(""));}
        return panneau;
    }

    private void initialisation_formulaire(int type,int id)
    {
        switch (type) {
         case 4:name="afficher_emprunteur(id);";    afficher_emprunteur( id);   break;
         case 5:name="afficher_devis(id);";         afficher_devis(id);         break;
         case 6:name="afficher_vehicule(id);";      afficher_vehicule(id);      break;

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
                split(2);
                add(Emprunteur.afficher_utilisateur_console(Id));}

    private void afficher_devis(int Id)
        {name="afficher_devis ";split(2);
        add(Gestion_BDD.afficher_Devis_console(Id));}

    private void afficher_vehicule(int Id)
        {name="afficher_vehicule ";
        System.out.println("afficher_vehicule pas coder WARNING on envoie rien actuelment");
        split(2);
        add(Emprunteur.afficher_utilisateur_console(Id));

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



    class Validation implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            boolean test=true;

            for(int i=0;i<3;i++) { if(form[i].getContain().equals("")) {test=false;}}
        //--------------------------------------------------------------------------------------------------------------
            if(test)
                {
                    LinkedList<String> text=add(form[0].getContain(),form[1].getContain(),form[2].getContain(),""+form[3].getContain().equals(""),""+0);
                    if(name=="Nouveau Emprunteur1")
                        {texte[0].setText("Nouveau Emprunteur cree");
                            Gestion_BDD. ajout("./src/BDD/Emprunteur/",text);
                        }
                    else if(name=="Nouveau Devis1")
                        {texte[0].setText("Nouveau Devis cree");
                            Gestion_BDD. ajout("./src/BDD/Devis/",text);
                        }
                    else
                        {texte[0].setText("Nouveau Vehicule cree");
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
