package core.Criteres;

import bdd.Film;

import java.sql.Date;

public class CritereDate extends Critere {
    private Date dateDeb;
    private Date dateFin;

    public CritereDate(Date deb, Date fin) {
        dateDeb = deb;
        dateFin = fin;
    }

    @Override 
    public int evaluate(Film film) {
        if (film.getDateSortie().after(dateDeb) && film.getDateSortie().before(dateFin))
            return 20;
        return -40;
    }
}
