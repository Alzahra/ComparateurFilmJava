package core.Criteres;

import bdd.Film;

public class CritereLangue extends Critere {
	
    private String langueFilm; 

    public CritereLangue(String langue) {
    	langueFilm = langue;
    }

    @Override
    public int evaluate(Film film) {
        //if (langueFilm.equals(film.getLangue())) return 40;
        return 0; //-70
    }
}
