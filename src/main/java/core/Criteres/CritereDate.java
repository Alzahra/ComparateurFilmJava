package core.Criteres;

import bdd.Film;

import java.sql.Date;

public class CritereDate extends Critere {
    private Date dateFilm;

    public CritereDate(Date date) {
    	dateFilm = date;
    }

    @Override 
    public int evaluate(Film film) {
        if (dateFilm.equals(film.getDateSortie())) return 20;
        return -40;
    }
}
