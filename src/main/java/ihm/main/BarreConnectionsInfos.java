package ihm.main;

import bdd.Client;
import core.UserInfo;

import javax.swing.*;

public class BarreConnectionsInfos extends JPanel {
    public BarreConnectionsInfos() {
        if (UserInfo.getInstance().isConnected()) {
            add(new GaucheConnected());
            add(new DroiteConnected());
        } else {
            add(new Defaut());
        }
    }

    private class Defaut extends JPanel {
        public Defaut() {
            add(new JButton("Se connecter"));
            add(new JButton("S'inscrire"));
        }
    }

    private class GaucheConnected extends JPanel {
        public GaucheConnected() {
            add(new JLabel("Bonjour Mr/Mme " + UserInfo.getInstance().getUser().getNom()));
            if (UserInfo.getInstance().getUser().getRole().equals("user")) {
                Client c = (Client)UserInfo.getInstance().getUser();
                add(new JLabel("Votre solde est de : " + c.getSolde()));
            }
            add(new JButton("Se déconnecter"));
        }
    }

    private class DroiteConnected extends JPanel {
        public DroiteConnected() {
            if (UserInfo.getInstance().getUser().getRole().equals("user"))
                add(new JButton("Panier (0)"));
            add(new JButton("Mon compte"));
        }
    }
}
