package ihm.main;

import javax.swing.*;

/**
 * Affiche les infos actuel selon si l'utilisateur est connecté et selon son rôle
 */
public class BarreHaute extends VueFilm {
    public BarreHaute() {
        add(new JButton("Se connecter"));
        add(new JButton("S'inscrire"));
    }
}
