package ihm.main;

import bdd.Film;
import bdd.Utilisateur;
import core.UserInfo;
import ihm.alza.Checkout.ContinuerAchat;

import javax.swing.*;
import java.awt.*;

public class VueFilm extends JPanel {
    private Film f;

    public VueFilm(Film f, Centre c) {
        this.f = f;
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0; //gc.fill = GridBagConstraints.HORIZONTAL; gc.weightx = 1;
        gc.weightx = 1;
        gc.gridx = 0;
        add(new JLabel(f.getTitre()), gc);
        gc.gridx = 1;
        add(new JLabel(new Integer(f.getDuree()).toString() + " min"), gc);
        gc.gridx = 2;
        add(new JLabel(f.getGenre()), gc);
        gc.gridx = 3;
        add(new JLabel(new Float(f.getNote()).toString() + "/10"), gc);
        gc.gridx = 4;
        add(new JLabel(new Float(f.getPrix()).toString() + "€"), gc);

        JButton b = new JButton("Détails");
        b.addActionListener(e -> c.toggleExtraInfos(f));
        gc.gridx = 5;
        add(b, gc);

        JButton location = new JButton("Louer");
        location.addActionListener(e -> {
            Utilisateur u = UserInfo.getInstance().getUser();
            if(UserInfo.getInstance().isConnected()) {
                if (u.getRole().equals("user")) {
                    UserInfo.getInstance().ajouterPanier(f);
                    //new ContinuerAchat(null);
                }
            }
        });
        gc.gridx = 6;
        add(location, gc);
    }
}
