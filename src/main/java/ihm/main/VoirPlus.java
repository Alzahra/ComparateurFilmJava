package ihm.main;

import bdd.Film;

import javax.swing.*;

public class VoirPlus extends JPanel {
    JLabel synopsis = new JLabel();
    JLabel acteurs = new JLabel();
    public VoirPlus() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(synopsis);
        add(acteurs);
    }

    public void setFilm(Film f) {
        synopsis.setText("Synopsis : " + f.getSynopsis());
        StringBuilder listActeurs = new StringBuilder();
        listActeurs.append("Acteurs : \n");
        for (int i = 0; i < f.getActeurs().length; i++) {
            listActeurs.append(f.getActeurs()[i]);
            if (i < f.getActeurs().length-1)
                listActeurs.append(", ");
            else
                listActeurs.append(".");
        }
        acteurs.setText(listActeurs.toString());
    }
}
