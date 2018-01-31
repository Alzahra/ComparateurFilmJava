package core.Criteres;

import bdd.Film;

public class CritereNom extends Critere {
    private String nomFilm;

    public CritereNom(String nom) {
        nomFilm = nom;
    }

    @Override
    public int evaluate(Film film) {
        if (nomFilm.equals(film.getTitre())) return 100;
        return 0;
    }
}
