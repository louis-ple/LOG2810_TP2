//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Commande.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import java.util.ArrayList;

public class Commande {

    //Masse des objets
    private final int masseA = 1;
    private final int masseB = 3;
    private final int masseC = 6;

    //Nombre de chaque objets
    private int nbObjetA;
    private int nbObjetB;
    private int nbObjetC;

    private ArrayList<Objet> panier;

    public Commande(){
        this.panier = new ArrayList<>();
    }

    public int getNbObjetA() {
        return nbObjetA;
    }

    public int getNbObjetB() {
        return nbObjetB;
    }

    public int getNbObjetC() {
        return nbObjetC;
    }

    public ArrayList<Objet> getPanier() {
        return panier;
    }

    public void addPanier(Objet objet){
        panier.add(objet);
    }

    public void viderPanier(){
        panier.clear();
    }

    public boolean estVide() {
        if (getNombreTotalObjets() == 0){
            return true;
        }
        return false;
    }

    public int masseTotale(){
        int masseTotale = 0;
        for (Objet objet:panier) {
            if (objet.getType() == "A"){
                masseTotale += masseA;
            }else if (objet.getType() == "B"){
                masseTotale += masseB;
            }else if (objet.getType() == "C"){
                masseTotale += masseC;
            }
        }
        return masseTotale;
    }

    public int getNombreTotalObjets(){
        return nbObjetA+nbObjetB+nbObjetC;
    }

    public void afficherCommande(){
        for (Objet objet:panier) {
            objet.afficherObjet();
        }
    }
}
