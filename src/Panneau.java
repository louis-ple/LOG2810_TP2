//  LOG2810 - TP2 : AUTOMATES ET LANGAGES
//  fichier: Panneau.java
//  Auteurs (Matricule) : Jérémie Bédard (1952335) Yasmine Moumou (1962718) Louis Plessis (1933334)
//  Date : 2019-11-24

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    public void paintComponent(Graphics g){
        g.drawString("Entrez le mot à rechercher :", 10, 20);
    }
}
