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
