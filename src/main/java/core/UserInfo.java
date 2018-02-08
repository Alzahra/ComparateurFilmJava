package core;

import bdd.Utilisateur;

public class UserInfo {
    private static UserInfo ourInstance = new UserInfo();

    public static UserInfo getInstance() {
        return ourInstance;
    }

    private Utilisateur user = null;

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

}
