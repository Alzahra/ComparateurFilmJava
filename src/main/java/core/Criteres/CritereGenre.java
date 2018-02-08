package core.Criteres;

import bdd.Film;

public class CritereGenre extends Critere {
    private String genreFilm; //fait on String [] genreFilm
    // Pour l'instant on reste que sur un genre par film, si on fini dans les temps on passe a plus

    public CritereGenre(String genre) {
    	genreFilm = genre;
    }

    @Override
    public int evaluate(Film film) {
        if (genreFilm.equalsIgnoreCase(film.getGenre())) return 60;
        else if (genreFilm.equals("")) return 0;
        return -50;
    }
}