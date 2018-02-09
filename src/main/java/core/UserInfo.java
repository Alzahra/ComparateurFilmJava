package core;

import bdd.Film;
import bdd.Utilisateur;

import java.util.ArrayList;

public class UserInfo {
    private static UserInfo ourInstance = new UserInfo();

    public static UserInfo getInstance() {
        return ourInstance;
    }

    private Utilisateur user = null;

    private ArrayList<Film> panier = new ArrayList<>();

    private UserInfo() {
    }

    public void setInfos(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }

    public boolean isConnected() {
        return user != null;
    }

    public void ajouterPanier(Film f) {
        if (!panier.contains(f))
            panier.add(f);
    }

    public void enleverDuPanier(Film f) {
        panier.remove(f);
    }

    public float getPrixPanier() {
        float prix = 0;
        for (Film f : panier)
            prix += f.getPrix();
        return prix;
    }

}
