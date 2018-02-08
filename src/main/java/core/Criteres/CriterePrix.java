package core.Criteres;

import bdd.Film;
public class CriterePrix extends Critere {
    private int prixMin;
    private int prixMax;

    public CriterePrix(int prixMin, int prixMax) {
    	this.prixMin = prixMin;
    	this.prixMax = prixMax;
    }

    @Override
    public int evaluate(Film film) {
        if (film.getPrix() >= prixMin && film.getPrix() <= prixMax) return 50;
        return -30;
    }

}
