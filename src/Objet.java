//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Objet.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-18

import javax.print.DocFlavor;

public class Objet {

    //Attributs
    private String nom;
    private String code;
    private String type;

    //Constructeur
    Objet(String nom, String code, String type){
        this.nom=nom;
        this.code=code;
        this.type=type;
    }

    //Getters
    public String getNom(){
        return nom;
    }

    public String getCode(){
        return code;
    }

    public String getType() {
        return type;
    }

    //Affichage d'un objet
    public void afficherObjet(){
        System.out.println(nom + " " + code + " " + type);
    }
}
