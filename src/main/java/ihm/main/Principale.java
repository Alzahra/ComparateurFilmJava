package ihm.main;

import bdd.Film;
import core.MoteurDeRecherche;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class Principale extends JFrame {
    VoirPlus vp = new VoirPlus();
    public Principale(String titre, MoteurDeRecherche m) {
        setTitle(titre);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 400);

        Centre c = new Centre(this);
        add(new BarreHaute(m, c), BorderLayout.NORTH);
        /*add(new VoirPlus(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})), BorderLayout.EAST); */
        add(c, BorderLayout.CENTER);
        pack();
        Dimension d = getSize();
        d.height += 100;
        d.width += 20;
        setMinimumSize(d);

        add(vp, BorderLayout.EAST);
    }

    public void afficheInfo(Film f) {
        vp.setFilm(f);
        //vp.revalidate();
        repaint();
        revalidate();
    }
}
