package ihm.main;

import bdd.Film;
import core.Resultat;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

public class Centre extends JScrollPane {
    private JPanel content = new JPanel();
    private Principale p;
    public Centre(Principale p) {
        this.p = p;
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setViewportView(content);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        /*
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
        content.add(new VueFilm(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})));
                */
    }

    public void afficher(ArrayList<Resultat> rs) {
        content.removeAll();
        for (Resultat r : rs)
            content.add(new VueFilm(r.getFilm(), this));
        content.updateUI();
    }

    public void toggleExtraInfos(Film f) {
        p.afficheInfo(f);
    }
}
