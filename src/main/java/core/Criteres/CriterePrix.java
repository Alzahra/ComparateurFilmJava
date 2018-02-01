package core.Criteres;

import bdd.Film;
public class CriterePrix extends Critere {
    private int prixFilm; 

    public CriterePrix(int prix) {
    	prixFilm = prix;
    }

    @Override
    public int evaluate(Film film) {
        if (film.getPrix() == prixFilm) return 50;
        return 0;//-30
    }

}
