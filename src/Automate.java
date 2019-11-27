//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Automate.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;


public class Automate {

    //Attributs
    private ArrayList<Objet> objets;
    private int limiteSuggestions = 10;


    //Constructeur
    public Automate() {
        this.objets = new ArrayList<Objet>();
    }

    //Getter
    public ArrayList<Objet> getObjets() {
        return objets;
    }

    //Lecture du lexique a partir du fichier texte
    public void creerAutomate(String chemin) throws FileNotFoundException {
        File fichier = new File(chemin);
        Scanner sc = new Scanner(fichier);
        while (sc.hasNextLine()) {
            String ligne = sc.nextLine();
            String[] vecteurLigne = ligne.split(" ");
            objets.add(new Objet(vecteurLigne[0], vecteurLigne[1], vecteurLigne[2]));
        }
    }

    //Retourne une liste d'objets en fonction des filtres appliqués et du contenu du panier
    public ArrayList<Objet> trouverSuggestions(String filtreNom, String filtreCode, String filtreType, Commande commande) {
        ArrayList<Objet> listeObjets = objets;
        int etatInitial = 0;
        int etat;
        if (!filtreNom.isBlank()) {
            etat = etatInitial;
            while (etat < filtreNom.length()){
                ArrayList<Objet> listeObjetARetirer = new ArrayList<>();
                for (Objet objet:listeObjets) {
                    if (objet.getNom().charAt(etat) != filtreNom.charAt(etat)){
                        listeObjetARetirer.add(objet);
                    }
                }
                if (!listeObjetARetirer.isEmpty()) {
                    for (Objet objetARetirer : listeObjetARetirer) {
                        listeObjets.remove(objetARetirer);
                    }
                }
                etat++;
            }
        }
        if (!filtreCode.isBlank()) {
            etat = etatInitial;
            while (etat < filtreCode.length()){
                ArrayList<Objet> listeObjetARetirer = new ArrayList<>();
                for (Objet objet:listeObjets) {
                    if (objet.getCode().charAt(etat) != filtreCode.charAt(etat)){
                        listeObjetARetirer.add(objet);
                    }
                }
                if (!listeObjetARetirer.isEmpty()) {
                    for (Objet objetARetirer : listeObjetARetirer) {
                        listeObjets.remove(objetARetirer);
                    }
                }
                etat++;
            }
        }
        if (!filtreType.isBlank()) {
            etat = etatInitial;
            while (etat < filtreType.length()){
                ArrayList<Objet> listeObjetARetirer = new ArrayList<>();
                for (Objet objet:listeObjets) {
                    if (objet.getType().charAt(etat) != filtreType.charAt(etat)){
                        listeObjetARetirer.add(objet);
                    }
                }
                if (!listeObjetARetirer.isEmpty()) {
                    for (Objet objetARetirer : listeObjetARetirer) {
                        listeObjets.remove(objetARetirer);
                    }
                }
                etat++;
            }
        }
        return listeObjets;
    }

    //Affichage des suggestions
    public void afficherSuggestion(ArrayList<Objet> objets) {
        int i = 0;
        for (Objet objet : objets) {
            System.out.print(i + ": ");
            objet.afficherObjet();
            i++;
        }
    }
}
