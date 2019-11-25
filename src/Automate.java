//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Automate.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;


public class Automate {

    private int nbEtats = 0;

    private ArrayList<Objet> objets;
    private ArrayList<Objet> objetsSuggeres;


    public Automate()
    {
        this.objets = new ArrayList<Objet>();
    }

    //Lecture du lexique a partir du fichier texte
    public void creerAutomate(String chemin) throws FileNotFoundException
    {
        File fichier = new File(chemin);
        Scanner sc = new Scanner(fichier);

        while(sc.hasNextLine())
        {
            String ligne = sc.nextLine();

            String[] vecteurLigne = ligne.split(" ");

            objets.add( new Objet(vecteurLigne[0], vecteurLigne[1], vecteurLigne[2]) );
        }
    }



    public ArrayList<Objet> trouverSuggestions(String filtreNom, String filtreCode, String filtreType){


        return objetsSuggeres;
    }

}
