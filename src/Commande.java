//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Commande.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

public class Commande {

    //Masse des objets
    private final int masseA = 1;
    private final int masseB = 3;
    private final int masseC = 6;

    //Nombre de chaque objets
    private int nbObjetA;
    private int nbObjetB;
    private int nbObjetC;

    public Commande(int nbObjetA, int nbObjetB, int nbObjetC){
        this.nbObjetA = nbObjetA;
        this.nbObjetB = nbObjetB;
        this.nbObjetC = nbObjetC;
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

    public boolean estVide() {
        if (getNombreTotalObjets() == 0){
            return true;
        }
        return false;
    }
    public int masseTotale(){

        return nbObjetA*masseA+nbObjetB*masseB+nbObjetC*masseC;
    }

    public int getNombreTotalObjets(){
        return nbObjetA+nbObjetB+nbObjetC;
    }

    public void afficherCommande(){

        System.out.print( "Nombre d'objets A : "+ nbObjetA + "\n");
        System.out.print( "Nombre d'objets B : "+ nbObjetB + "\n");
        System.out.print( "Nombre d'objets C : "+ nbObjetC + "\n");

    }
}
