package ihm.main;

import core.MoteurDeRecherche;

import javax.swing.*;

/**
 * Affiche les infos actuel selon si l'utilisateur est connecté et selon son rôle
 */
public class BarreHaute extends JPanel {
    public BarreHaute(MoteurDeRecherche m, Centre c) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new BarreConnectionsInfos());
        add(new BarreRecherche(m, c));
    }
}
