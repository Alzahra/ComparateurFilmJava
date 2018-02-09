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

    /**
     * Permet d'obtenir les films que loue un client avec les dates
     * de fin de location, au format adapté pour le stockage dans la BDD
     * @param c le client auquel on va vérifier s'il a des films loués
     * @return une chaine de caractères formaté pour la BDD
     */
    static String formatFilmsForBDD(Client c) {
        StringBuilder sb = new StringBuilder();
        c.films.forEach((film, date) -> {
            sb.append(film.getDateSortie() + "("+date.getTime()+");");
        });
        return sb.toString();
    }

    /**
     * Permet d'obtenir une Map de film avec leur date de fin de location
     * correspondante, et ce à partir d'une chaine de caractère formaté
     * venant de la BDD
     * @param f la chaine de caractère formaté venant de la BDD
     * @param tFilm la table des films permettant d'avoir toutes les informations des films loués
     * @return la Map ayant pour clé un film et pour valeur la date de fin de location
     */
    static HashMap<Film, Date> formatFilmsForClient(String f, TableFilms tFilm) {
        HashMap<Film, Date> films = new HashMap<>();

        if (f == null) return films;
        for (String s : f.split(";")) {
            String titre = s.substring(0, s.indexOf("(")); // Extraction du titre du film
            // Extraction de la date de fin de location
            String date = s.substring(s.indexOf("("), s.indexOf(")"));
            films.put(tFilm.getFilm(titre), new Date(Long.parseLong(date)));
        }
        return films;
    }

    /**
     * Un Client est un utilisateur qui n'a pas le droit de modifier la base de donnée.
     * Il est caractérisé par les champs suivants :
     * @param id attribué par la base de donnée, permet de faire plus facilement des recherche
     * @param pseudo le pseudo du client
     * @param nom le nom du client
     * @param prenom le prénom du client
     * @param email l'email du client
     * @param role le role, dans ce cas role = user
     * @param solde le solde actuel du client
     * @param films les films que loue le client
     */
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
