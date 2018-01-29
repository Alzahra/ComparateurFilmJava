package bdd;

import java.util.List;

/**
 * TODO : certainement d'autres fonctions à ajouter
 * - debiter(montant)
 * - crediter(montant)
 * - ajouterFilm(Film)
 * - supprimerFilm(Film)
 */
public class Client extends Utilisateur {
    private float solde;
    private List<Film> films; // TODO : voir si pas conteneur plus adapté

    public Client(String pseudo, String nom, String prenom, String email, Role role, float solde, List<Film> films) {
        super(pseudo, nom, prenom, email, role);
        this.solde = solde;
        this.films = films;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
