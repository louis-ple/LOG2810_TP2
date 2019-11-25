import javax.print.DocFlavor;

public class Objet {

    private String nom;
    private String code;
    private String type;

    Objet(String nom, String code, String type)
    {
        this.nom=nom;
        this.code=code;
        this.type=type;
    }

    public String getNom()
    {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public void afficherObjet(){
        System.out.println(nom + " " + code + " " + type);
    }
}
