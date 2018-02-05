package ihm.main;

import bdd.Film;

import javax.swing.*;

public class VueFilm extends JPanel {
    public VueFilm(Film f) {
        add(new JLabel(f.getTitre()));
        add(new JLabel(new Integer(f.getDuree()).toString()));
        add(new JLabel(f.getGenre()));
        add(new JLabel(new Float(f.getNote()).toString()));
        add(new JLabel(new Float(f.getPrix()).toString()));
    }
}
