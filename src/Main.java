//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Main.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-18

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String jayPath = "C:\\Users\\jeremie\\Documents\\structureDiscrete\\LOG2810_TP2\\src\\inventaire.txt";
    static String louisPath = "C:\\Users\\Louis\\LOG2810_TP2\\src\\inventaire.txt";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Test" + "\n");

        Automate a = new Automate();
        a.creerAutomate(jayPath);

        Scanner sc = new Scanner(System.in);

        while (a.getNbEtats() != 6) {
            switch (a.getNbEtats()) {
                case 0:
                    System.out.println("---------------------------------");
                    System.out.println("Choisir quoi faire:" + "\n");
                    System.out.println("1: Faire une suggestion");
                    System.out.println("2: Ajouter au panier");
                    System.out.println("3: Passer une commande");
                    System.out.println("4: Afficher le panier");
                    System.out.println("5: Vider le panier");
                    System.out.println("6: Exit" + "\n");
                    System.out.println("Choix: ");
                    a.setNbEtats(sc.nextInt());
                    sc.nextLine();
                    System.out.println("---------------------------------");
                    break;

                case 1:
                    System.out.println("-Mode de suggestion-");
                    System.out.println("Nom: ");
                    String nomRobot = sc.nextLine();
                    System.out.println("Type: ");
                    String typeRobot = sc.nextLine();
                    System.out.println("Code: ");
                    String codeRobot = sc.nextLine();

                    ArrayList<Objet> suggestion;
                    suggestion = a.trouverSuggestions(nomRobot, codeRobot, typeRobot);

                    System.out.println("Suggestions: " + "\n");
                    System.out.println(("Nombre d'objets possibles: " + suggestion.size()));
                    for (Objet afficher : suggestion) {
                        afficher.afficherObjet();
                    }
                    a.setNbEtats(0);
                    break;

                case 2:
                    System.out.println("-Mode d'ajout au panier-");
                    
                    System.out.println("\n" + "À ajouter au panier:");
                    System.out.println("Nom: ");
                    nomRobot = sc.nextLine();
                    System.out.println("Type: ");
                    typeRobot = sc.nextLine();
                    System.out.println("Code: ");
                    codeRobot = sc.nextLine();
                    Objet objetAjouter = a.trouverObjetUnique(nomRobot, codeRobot, typeRobot);
                    if (objetAjouter != null){
                        a.getCommande().addPanier(objetAjouter);
                    }else {
                        System.out.println("Objet introuvable");
                    }
                    a.setNbEtats(0);
                    break;

                case 3:
                    System.out.println("-Mode passage de commande-");
                    if (a.getCommande().masseTotale() > 25) {
                        System.out.println("Votre commande dépasse 25kg, le panier vas être vidé");
                        a.getCommande().viderPanier();
                    } else {
                        for (Objet objet : a.getCommande().getPanier()) {
                            a.getObjets().remove(objet);
                        }
                        a.getCommande().viderPanier();
                    }
                    a.setNbEtats(0);
                    break;

                case 4:
                    System.out.println("-Mode affichage de la commande-");
                    a.getCommande().afficherCommande();
                    a.setNbEtats(0);
                    break;

                case 5:
                    System.out.println("-Mode vidage de la commande-");
                    a.getCommande().viderPanier();
                    a.setNbEtats(0);
                    break;
            }
        }
    }
}