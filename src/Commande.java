//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Commande.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import java.util.ArrayList;

public class Commande {
    //Attributs
    //Masse des objets
    private final int masseA = 1;
    private final int masseB = 3;
    private final int masseC = 6;

    private ArrayList<Objet> panier;

    //Constructeur
    public Commande() {
        this.panier = new ArrayList<>();
    }

    //getter
    public ArrayList<Objet> getPanier() {
        return panier;
    }

    //vide le panier
    public void viderPanier() {
        panier.clear();
    }

    //calcule la masse totale du panier
    public int masseTotale() {
        int masseTotale = 0;
        for (Objet objet : panier) {
            if (objet.getType().equals("A")) {
                masseTotale += masseA;
            } else if (objet.getType().equals("B")) {
                masseTotale += masseB;
            } else if (objet.getType().equals("C")) {
                masseTotale += masseC;
            }
        }
        return masseTotale;
    }

    //affiche le contenu du panier
    public void afficherPanier() {
        if (panier.isEmpty()) {
            System.out.println("panier vide");
        }
        for (Objet objet : panier) {
            objet.afficherObjet();
        }
        System.out.print("\n");
    }
}
