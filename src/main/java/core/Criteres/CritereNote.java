package core.Criteres;

import bdd.Film;

public class CritereNote extends Critere {
    private int noteFilm; 

    public CritereNote(int note) {
    	noteFilm = note;
    }

    @Override //est ce qu'on mettrait pas les films avec des notes >= ?
    public int evaluate(Film film) {
        if (film.getNote() == noteFilm) return 30;
        return 0;//-30
    }

}
