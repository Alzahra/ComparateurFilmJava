package ihm.main;

import bdd.Client;
import core.UserInfo;
import ihm.alza.Checkout.DetailPanier;
import ihm.alza.InformationCompte.InformationAdmin;
import ihm.alza.InformationCompte.InformationClient;
import ihm.alza.InscriConnex.Connexion;
import ihm.alza.InscriConnex.Inscription;
import org.h2.engine.User;

import javax.swing.*;

public class BarreConnectionsInfos extends JPanel {
    public BarreConnectionsInfos() {
        changePanels();
    }

    private void changePanels() {
        removeAll();
        if (UserInfo.getInstance().isConnected()) {
            add(new GaucheConnected());
            add(new DroiteConnected());
        } else {
            add(new Defaut());
        }
        revalidate();
        repaint();
    }

    private class Defaut extends JPanel {
        public Defaut() {
            JButton connecter = new JButton("Se connecter");
            JButton inscrire = new JButton("S'inscrire");

            connecter.addActionListener(e -> {
                Connexion co = new Connexion(null);
                if (co.isSuccessfull()) changePanels();
            });

            inscrire.addActionListener(e -> new Inscription(null));

            add(inscrire);
            add(connecter);
        }
    }

    private class GaucheConnected extends JPanel {
        public GaucheConnected() {
            add(new JLabel("Bonjour Mr/Mme " + UserInfo.getInstance().getUser().getNom()));
            if (UserInfo.getInstance().getUser().getRole().equals("user")) {
                Client c = (Client)UserInfo.getInstance().getUser();
                add(new JLabel("Votre solde est de : " + c.getSolde()));
            }
            JButton deconnecter = new JButton("Se déconnecter");
            deconnecter.addActionListener(e -> {
                UserInfo.getInstance().setInfos(null);
                changePanels();
            });
            add(deconnecter);
        }
    }

    private class DroiteConnected extends JPanel {
        public DroiteConnected() {
            if (UserInfo.getInstance().getUser().getRole().equals("user")) {
                JButton panier = new JButton("Panier (0)");
                panier.addActionListener(e -> new DetailPanier(null));
                add(panier);
            }
            JButton compte = new JButton("Mon compte");
            compte.addActionListener(e -> {
                if (UserInfo.getInstance().getUser().getRole().equals("admin"))
                    new InformationAdmin(null);
                else
                    new InformationClient(null);
            });
            add(compte);
        }
    }
}
