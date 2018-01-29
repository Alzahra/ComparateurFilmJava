package core;

import bdd.Film;

import java.util.Date;
import java.util.List;

/**
 * Un Résultat est un film qui a un score et que l'on peut donc comparer
 * par rapport à leur score.
 */
public class Resultat extends Film implements Comparable<Resultat> {
    private int score;

    public Resultat(String titre, int duree, float note, float prix, Date dateSortie, String genre, String synopsis, List<String> acteurs) {
        super(titre, duree, note, prix, dateSortie, genre, synopsis, acteurs);
    }

    @Override
    public int compareTo(Resultat o) {
        if (score > o.score) return 1;
        else if (score == o.score) return 0;
        else return -1;
    }
}
