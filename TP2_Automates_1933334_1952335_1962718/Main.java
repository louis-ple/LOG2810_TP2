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
    static String yasPath = "E:\\Polytechnique\\2ème année\\Session 1\\LOG2810\\Labos\\TP2\\TP2\\LOG2810_TP2\\src\\inventaire.txt";

    //enum des différents états de notre interface
    private enum EtatInterface {menuPrincipal, faireSuggestion, menuSuggestion, ajoutPanier, viderPanier, passerCommande, afficherPanier, exit}

    // L'interface comprend un menu principal qui permet d'effectuer une recherche, de visualiser le panier, de vider le panier et de passer une commande.
    // Pour ajouter un objet au panier, il faut d'abord effectuer une recherche. Une fois la recherche effectuée, un nouveau menu s'affiche permettant
    // d'ajouter des éléments au panier en choisissant parmis les objets suggérés. Ce second menu permet toujours d'afficher, de vider le panier et de
    // passer une commande. Il est aussi possible de retourner au menu principal à partir du second menu.

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Test" + "\n");

        Automate a = new Automate();
        Commande commande = new Commande();
        a.creerAutomate(yasPath); // CHANGER LE PATH DU FICHIER ICI

        Scanner sc = new Scanner(System.in);

        EtatInterface etatCourant = EtatInterface.menuPrincipal;
        int choix;
        EtatInterface etatPrecedent = etatCourant;
        ArrayList<Objet> suggestion = new ArrayList<>();
        String nomObjet = null;
        String typeObjet = null;
        String codeObjet = null;
        while (etatCourant != EtatInterface.exit) {
            switch (etatCourant) {
                case menuPrincipal:
                    System.out.println("---------------------------------");
                    System.out.println("Choisir quoi faire:" + "\n");
                    System.out.println("1: Recherche d'objets");
                    System.out.println("2: Afficher le panier");
                    System.out.println("3: Vider le panier");
                    System.out.println("4: Passer une commande");
                    System.out.println("5: Exit" + "\n");
                    System.out.println("Choix: ");

                    choix = sc.nextInt();
                    sc.nextLine();
                    etatPrecedent = etatCourant;
                    switch (choix) {
                        case 1:
                            etatCourant = EtatInterface.faireSuggestion;
                            break;
                        case 2:
                            etatCourant = EtatInterface.afficherPanier;
                            break;
                        case 3:
                            etatCourant = EtatInterface.viderPanier;
                            break;
                        case 4:
                            etatCourant = EtatInterface.passerCommande;
                            break;
                        case 5:
                            etatCourant = EtatInterface.exit;
                            break;
                        default:
                            System.out.println("choix invalide");
                    }
                    System.out.println("---------------------------------");
                    break;

                case faireSuggestion:
                    System.out.println("-Mode de suggestion-");
                    System.out.println("Veuillez appliquer un ou des filtres");
                    System.out.println("Nom: ");
                    nomObjet = sc.nextLine();
                    System.out.println("Type: ");
                    typeObjet = sc.nextLine();
                    System.out.println("Code: ");
                    codeObjet = sc.nextLine();

                    suggestion = a.trouverSuggestions(nomObjet, codeObjet, typeObjet, commande);

                    if (suggestion.isEmpty()) {
                        System.out.println("Aucun objet trouvé");
                        etatCourant = EtatInterface.menuPrincipal;
                    } else {
                        etatCourant = EtatInterface.menuSuggestion;
                    }
                    break;

                case menuSuggestion:
                    System.out.println("\n Suggestions: \n");
                    System.out.println(("Nombre d'objets possibles: " + suggestion.size()));
                    a.afficherSuggestion(suggestion);
                    System.out.println("\n Choisir quoi faire: \n");
                    System.out.println("1: Afficher le panier");
                    System.out.println("2: Ajouter au panier");
                    System.out.println("3: Vider le panier");
                    System.out.println("4: Passer une commande");
                    System.out.println("5: Retour menu principal");

                    choix = sc.nextInt();
                    sc.nextLine();
                    etatPrecedent = etatCourant;
                    switch (choix) {
                        case 1:
                            etatCourant = EtatInterface.afficherPanier;
                            break;
                        case 2:
                            etatCourant = EtatInterface.ajoutPanier;
                            break;
                        case 3:
                            etatCourant = EtatInterface.viderPanier;
                            break;
                        case 4:
                            etatCourant = EtatInterface.passerCommande;
                            break;
                        case 5:
                            etatCourant = EtatInterface.menuPrincipal;
                            break;
                        default:
                            System.out.println("choix invalide");
                            etatCourant = EtatInterface.menuSuggestion;
                    }
                    break;

                case ajoutPanier:
                    System.out.println("-Mode d'ajout au panier-");
                    System.out.println("Voulez-vous entrer dans ce mode? (o/n)");
                    if (sc.nextLine().equals("o")) {
                        System.out.println("\n Choisir parmis les suggestions précédentes (Entrez le numéro de l'objet):");

                        choix = sc.nextInt();
                        sc.nextLine();

                        if (choix > suggestion.size()) {
                            System.out.println("Objet introuvable");
                        } else {
                            System.out.println("Objet ajouté au panier");
                            commande.getPanier().add(suggestion.get(choix));
                            suggestion = a.trouverSuggestions(nomObjet, codeObjet, typeObjet, commande);
                        }
                    }
                    etatCourant = EtatInterface.menuSuggestion;
                    break;

                case passerCommande:
                    System.out.println("-Mode passage de commande-");
                    System.out.println("Voulez-vous entrer dans ce mode? (o/n)");
                    if (sc.nextLine().equals("o")) {
                        if (commande.masseTotale() >= 25) {
                            System.out.println("Votre commande dépasse 25kg, le panier vas être vidé");
                            commande.viderPanier();
                        } else {
                            if (commande.getPanier().isEmpty())
                                System.out.println("Votre panier est vide");
                            else {


                                for (Objet objet : commande.getPanier()) {
                                    a.getObjets().remove(objet);
                                }
                                commande.viderPanier();
                                System.out.println("Merci, votre commande a été passée");
                            }
                        }
                    }
                    etatCourant = EtatInterface.menuSuggestion;
                    break;

                case afficherPanier:
                    System.out.println("-Mode affichage du panier-");
                    commande.afficherPanier();
                    etatCourant = etatPrecedent;
                    break;

                case viderPanier:
                    System.out.println("-Mode vidage du panier-");
                    System.out.println("Voulez-vous entrer dans ce mode? (o/n)");
                    if (sc.nextLine().equals("o")) {
                        if (commande.getPanier().isEmpty())
                            System.out.println("Votre panier est déjà vide");
                        else {
                            System.out.println("Votre panier a été vidé");
                            commande.viderPanier();
                            suggestion = a.trouverSuggestions(nomObjet, codeObjet, typeObjet, commande);
                        }
                    }
                    etatCourant = EtatInterface.menuSuggestion;
                    break;
            }
        }
    }
}