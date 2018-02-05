package ihm.main;

import ihm.utils.RangeSlider;

import javax.swing.*;
import java.awt.*;

public class BarreRecherche extends JPanel {
    public BarreRecherche() {
        setLayout(new FlowLayout());

        add(new JLabel("Titre :"));
        JTextField titre = new JTextField();
        titre.setColumns(7);
        add(titre);

        add(new JLabel("Genre :"));
        JTextField genre = new JTextField();
        genre.setColumns(7);
        add(genre);

        add(new JLabel("Durée :"));
        JOptionPane duree = new JOptionPane();
        duree.setSelectionValues(new String[]{
                "< 180", "180 - 240", "> 240"
        });
        add(duree);

        RangeSlider annee = new RangeSlider();
        annee.setMinimum(1994);
        annee.setMaximum(2018);
        annee.setValue(2000);
        annee.setUpperValue(2017);
        add(annee);
    }
}
