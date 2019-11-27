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
    private enum Filtre{nom,type,code}
    private int etatInitial = 0;
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

    //Filtre une liste d'objets dépendemment du filtres appliqué
    private void filtreListe(String valeurFiltre, Filtre filtre, ArrayList<Objet> listeObjets){
        if (!valeurFiltre.isBlank()) {
            int etat = etatInitial;
            String mot = "";
            while (etat < valeurFiltre.length()){
                ArrayList<Objet> listeObjetARetirer = new ArrayList<>();
                for (Objet objet:listeObjets) {
                    switch (filtre){
                        case nom:
                            mot = objet.getNom();
                            break;
                        case type:
                            mot = objet.getType();
                            break;
                        case code:
                            mot = objet.getCode();
                            break;
                    }
                    if (mot.charAt(etat) != valeurFiltre.charAt(etat)){
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
    }

    //Retourne une liste d'objets en fonction des filtres appliqués et du contenu du panier
    public ArrayList<Objet> trouverSuggestions(String filtreNom, String filtreCode, String filtreType, Commande commande) {
        ArrayList<Objet> listeObjets = objets;

        for (Objet objet:commande.getPanier()) {
            listeObjets.remove(objet);
        }

        filtreListe(filtreNom,Filtre.nom,listeObjets);
        filtreListe(filtreCode,Filtre.code,listeObjets);
        filtreListe(filtreType,Filtre.type,listeObjets);

        while (listeObjets.size() > 10){
            listeObjets.remove(listeObjets.size()-1);
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
