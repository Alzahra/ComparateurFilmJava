package core.Criteres;

import bdd.Film;

public class CritereDuree extends Critere {
    private int dureeFilm; 

    public CritereDuree(int duree) {
    	dureeFilm = duree;
    }

    @Override //fait on un intervalle de duree
    public int evaluate(Film film) {
        if (film.getDuree() == dureeFilm) return 20;
        return 0;//-20
    }
}
