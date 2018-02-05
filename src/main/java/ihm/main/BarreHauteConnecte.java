package ihm.main;

import javax.swing.*;

public class BarreHauteConnecte extends VueFilm {
    public BarreHauteConnecte() {
        add(new Gauche());
        add(new Droite());
    }

    private class Gauche extends VueFilm {
        public Gauche() {
            add(new JLabel("Bonjour Mr/Mme ..."));
            add(new JLabel("Votre solde est de : "));
            add(new JLabel("Se déconnecter"));
        }
    }

    private class Droite extends VueFilm {
        public Droite() {
            add(new JButton("Panier (0)"));
            add(new JButton("Mon compte"));
        }
    }
}
