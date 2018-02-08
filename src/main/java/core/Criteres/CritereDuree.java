package core.Criteres;

import bdd.Film;

public class CritereDuree extends Critere {
    private int dureeMin;
    private int dureeMax;

    public CritereDuree(int dureeMin, int dureeMax) {
    	this.dureeMax = dureeMax;
    	this.dureeMin = dureeMin;
    }

    @Override //fait on un intervalle de duree
    public int evaluate(Film film) {
        if (film.getDuree() <= dureeMax && film.getDuree() >= dureeMin) return 20;
        return -20;
    }
}
