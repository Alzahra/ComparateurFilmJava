package ihm.main;

import core.Criteres.*;
import core.MoteurDeRecherche;
import ihm.utils.RangeSliderPerso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class BarreRecherche extends JPanel {
    private JTextField titre;
    private JComboBox<String> genre;
    private JComboBox<String> duree;
    private RangeSliderPerso annee;
    private RangeSliderPerso note;
    private RangeSliderPerso prix;

    public BarreRecherche(MoteurDeRecherche m, Centre fenRslt) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 0.2;
        c.gridx = 0; c.gridy = 0;
        //c.gridwidth = 2;
        add(new JLabel("Titre :"), c);
        titre = new JTextField();
        titre.setColumns(7);
        c.gridx = 1;
        add(titre, c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 1;
        c.weightx = 0.25;
        //c.gridwidth = 1;
        c.gridx = 0;
        add(new JLabel("Genre :"), c);
        genre = new JComboBox<>(new String[]{
                "", "Comique", "Fantastique", "Policier"
        });
        c.gridx = 1;
        add(genre, c);

        c.gridx = 2;
        add(new JLabel("Durée :"), c);
        duree = new JComboBox<>(new String[]{
                "< 180", "180 - 240", "> 240"
        });
        c.gridx = 3;
        add(duree, c);

        c.weightx = 1./3;
        c.gridy = 2;

        annee = new RangeSliderPerso(1994, 2018, "Année :",
                1994, 2018);
        c.gridx = 0;
        add(annee, c);

        note = new RangeSliderPerso(0, 10, "Note :",
                0, 10);
        c.gridx = 1;
        add(note, c);

        prix = new RangeSliderPerso(0, 20, "Prix (€) :",
                0, 20);
        c.gridx = 2;
        add(prix, c);

        c.anchor = GridBagConstraints.LAST_LINE_END;
        c.gridx = 0; c.gridy = 3;
        c.weightx = 1;
        //c.gridwidth = 4;
        JButton rechercher = new JButton("Rechercher");
        add(rechercher);

        rechercher.addActionListener(e -> fenRslt.afficher(m.rechercher(getCriteres())));
    }

    Critere[] getCriteres() {
        ArrayList<Critere> c = new ArrayList<>();

        c.add(new CritereGenre((String)genre.getSelectedItem()));

        //"< 180", "180 - 240", "> 240"
        switch (duree.getSelectedIndex()) {
            case 0:
                c.add(new CritereDuree(0, 180));
                break;
            case 1:
                c.add(new CritereDuree(180, 240));
                break;
            case 2:
                c.add(new CritereDuree(240, 10000));
                break;
        }

        Date deb = Date.valueOf("" + annee.getLowerValue() + "-1-1");
        Date fin = Date.valueOf("" + annee.getUpperValue() + "-1-1");
        c.add(new CritereDate(deb, fin));

        c.add(new CritereNote(note.getLowerValue(), note.getUpperValue()));
        c.add(new CriterePrix(note.getLowerValue(), note.getUpperValue()));

        return c.toArray(new Critere[c.size()]);
    }
}
