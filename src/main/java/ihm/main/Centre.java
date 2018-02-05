package ihm.main;

import bdd.Film;

import javax.swing.*;
import java.sql.Date;

public class Centre extends JScrollPane {
    private JPanel content = new JPanel();;
    public Centre() {
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setViewportView(content);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

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
    }
}
