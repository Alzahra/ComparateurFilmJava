package ihm.main;

import javax.swing.*;

public class BarreConnectionsInfos extends JPanel {
    public BarreConnectionsInfos() {
        add(new Gauche());
        add(new Droite());
    }

    private class Gauche extends JPanel {
        public Gauche() {
            add(new JLabel("Bonjour Mr/Mme ..."));
            add(new JLabel("Votre solde est de : "));
            add(new JLabel("Se déconnecter"));
        }
    }

    private class Droite extends JPanel {
        public Droite() {
            add(new JButton("Panier (0)"));
            add(new JButton("Mon compte"));
        }
    }
}
