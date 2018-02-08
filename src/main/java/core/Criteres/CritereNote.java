package core.Criteres;

import bdd.Film;

public class CritereNote extends Critere {
    private int noteMin;
    private int noteMax;

    public CritereNote(int noteMin, int noteMax) {
    	this.noteMax = noteMax;
    	this.noteMin = noteMin;
    }

    @Override //est ce qu'on mettrait pas les films avec des notes >= ?
    public int evaluate(Film film) {
        if (film.getNote() >= noteMin && film.getNote() <= noteMax) return 30;
        return -30;
    }

}
