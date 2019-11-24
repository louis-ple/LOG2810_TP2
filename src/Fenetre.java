//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Fenetre.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import java.awt.*;
import javax.swing.*;


public class Fenetre extends JFrame{

    String[] tab = {"Type", "Code identificateur", "Nom"};

    private Panneau pan = new Panneau();
    private JButton button = new JButton("OK.");
    private JComboBox combo = new JComboBox(tab);
    private JLabel label = new JLabel("Rechercher par : ");

    public Fenetre(){
        this.setTitle("LOG2810 - TP2 : Automates");
        this.setSize(800, 600);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Définition de sa couleur de fond
        pan.setBackground(Color.WHITE);
        pan.setLayout(new BorderLayout());
        combo.setPreferredSize(new Dimension(120, 20));

        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        pan.add(top, BorderLayout.NORTH);

        //Ajout du bouton
        pan.add(button, BorderLayout.SOUTH);

        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);
        this.setVisible(true);
    }
}
