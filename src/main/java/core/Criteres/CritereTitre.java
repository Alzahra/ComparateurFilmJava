package core.Criteres;

import bdd.Film;

public class CritereTitre extends Critere {
    private String titreFilm;

    public CritereTitre(String titre) {
        titreFilm = titre;
    }

    @Override
    public int evaluate(Film film) {
        if (titreFilm.equals(film.getTitre())) return 100;
        return -20;
    }
}
