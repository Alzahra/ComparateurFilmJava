package core;

import bdd.Film;

import java.util.Date;
import java.util.List;

/*
 * Un Résultat est un film qui a un score et que l'on peut donc comparer
 * par rapport à leur score.
 */
public class Resultat implements Comparable<Resultat> {
    private int score;
    private Film film;

    public Resultat(Film film, int score) {
        this.film = film;
        this.score = score;
    }

    @Override
    public int compareTo(Resultat o) {
        if (score > o.score) return 1;
        else if (score == o.score) return 0;
        else return -1;
    }
}
