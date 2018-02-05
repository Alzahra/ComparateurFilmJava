package ihm.main;

import bdd.Film;

import javax.swing.*;

public class VoirPlus extends JPanel {
    public VoirPlus(Film f) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new JLabel("Synopsis : " + f.getSynopsis()));

        StringBuilder listActeurs = new StringBuilder();
        listActeurs.append("Acteurs : \n");
        for (int i = 0; i < f.getActeurs().length; i++) {
            listActeurs.append(f.getActeurs()[i]);
            if (i < f.getActeurs().length-1)
                listActeurs.append(", ");
            else
                listActeurs.append(".");
        }
        add(new JLabel(listActeurs.toString()));
    }
}
