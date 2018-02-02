package bdd;

import core.MoteurDeRecherche;

import java.sql.Date;
import java.util.HashMap;

/**
 * TODO : certainement d'autres fonctions à ajouter
 * - debiter(montant)
 * - crediter(montant)
 * - ajouterFilm(Film)
 * - supprimerFilm(Film)
 */
public class Client extends Utilisateur {
    private float solde;
    private HashMap<Film, Date> films; // Un film a une date de péremption x)

    static String formatFilmsForBDD(Client c) {
        StringBuilder sb = new StringBuilder();
        c.films.forEach((film, date) -> {
            sb.append(film.getDateSortie() + "("+date.getTime()+");");
        });
        return sb.toString();
    }

    static HashMap<Film, Date> formatFilmsForClient(String f, BaseDeDonnee bdd) {
        HashMap<Film, Date> films = new HashMap<>();

        for (String s : f.split(";")) {
            String titre = s.substring(0, s.indexOf("(")); // Extraction du titre du film
            // Extraction de la date de fin de location
            String date = s.substring(s.indexOf("("), s.indexOf(")"));
            films.put(bdd.getFilm(titre), new Date(Long.parseLong(date)));
        }
        return films;
    }

    public Client(int id, String pseudo, String nom, String prenom, String email, String role, float solde, HashMap<Film, Date> films) {
        super(id, pseudo, nom, prenom, email, role);
        this.solde = solde;
        this.films = films;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public HashMap<Film, Date> getFilms() {
        return films;
    }

    public void setFilms(HashMap<Film, Date> films) {
        this.films = films;
    }
}
