//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Main.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-18

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Test.");

        Fenetre f = new Fenetre();

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer le mot à rechercher : ");
        String s = sc.nextLine();

        clearScreen();

        System.out.println("Vous recherchez le mot suivant : " + s);
    }












}