package ihm.main;

import bdd.Film;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class Principale extends JFrame {
    public Principale(String titre) {
        setTitle(titre);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 400);

        add(new BarreHauteConnecte(), BorderLayout.NORTH);
        add(new VoirPlus(new Film(1, "Super film", 180, 9.9f, 10f,
                new Date(151651), "comique", "Un comique qui comiquait.",
                new String[]{"Le jardin du Jean", "Pecresse aura tes fesses"})), BorderLayout.EAST);
        add(new Centre(), BorderLayout.CENTER);
        pack();
    }
}
