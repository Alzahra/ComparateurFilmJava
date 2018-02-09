package ihm.main;

import bdd.Film;

import javax.swing.*;
import java.awt.*;

public class VueFilm extends JPanel {
    public VueFilm(Film f, Centre c) {
        add(new JLabel(f.getTitre()));
        add(new JLabel(new Integer(f.getDuree()).toString()));
        add(new JLabel(f.getGenre()));
        add(new JLabel(new Float(f.getNote()).toString()));
        add(new JLabel(new Float(f.getPrix()).toString()));
        JButton b = new JButton("Détails");

        b.addActionListener(e -> c.toggleExtraInfos(f));

        add(b);
    }
}
