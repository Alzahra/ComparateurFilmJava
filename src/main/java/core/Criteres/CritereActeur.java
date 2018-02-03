package core.Criteres;

import bdd.Film;

public class CritereActeur extends Critere {
    private String[] acteurFilm;

    public CritereActeur(String ... acteurs) {
    	acteurFilm = acteurs;
    }

    @Override //la le equals on le fait sur chaque cases ? Comment on le g�re ?
    public int evaluate(Film film) {
        // Faudrait boucler sur chaque liste, et dès que l'on a un match on ajoute au score
        // Faut 2 boucles
        int score = 0;
        for (String s : acteurFilm) {
            for (String ss : film.getActeurs()) {
                if (s.equals(ss))
                    score += 50;
            }
        }
        if (score == 0)
            return -30;
        return 50;
    }
}
