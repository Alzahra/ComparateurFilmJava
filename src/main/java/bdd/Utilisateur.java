package bdd;

import java.util.List;

public class Utilisateur {
    enum Role { USER, ADMIN }

    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private Role role;

    public Utilisateur(String pseudo, String nom, String prenom, String email, Role role) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return pseudo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Utilisateur) {
            return ((Utilisateur) obj).pseudo.equals(this.pseudo);
        }
        return false;
    }
}
