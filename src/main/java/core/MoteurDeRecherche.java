package core;

import bdd.BaseDeDonnee;
import bdd.Film;
import core.Criteres.Critere;

import java.util.ArrayList;
import java.util.Collections;

public class MoteurDeRecherche {
    /**
     * Contient la BDD actuel, un changement dans la BDD devra donc être reflété
     * dans cette list.
     * TODO : je sais pas trop quand et comment appeler BDD.modifier etc..
     * En tout cas faut garder cette liste et la BDD synchronisé
     */
    private ArrayList<Film> bddTemporaire;
    private BaseDeDonnee bdd;
    /**
     * Les résultats de la dernière recherche
     */
    private ArrayList<Resultat> resultats = new ArrayList<>();

    // TODO : Pas besoin de passer la BDD en paramètre mais l'instancier direct ?!
    public MoteurDeRecherche(BaseDeDonnee bdd) {
        this.bdd = bdd;
        //bddTemporaire = bdd.getFilms(); // TODO : corriger ca
    }

    /**
     * Va simplement mettre à jour la liste des résultats.
     * TODO : je ne sais pas si c'est utile de la renvoyer aussi (évite de passer par un getResultats())
     *
     * C'est encore un peu le bordel, je sais pas trop comment lier les critères aux caractèristiques d'un film.
     *
     * Cette fonction va instancier des résultats dans sa list resultats.
     * Pour cela il va calculer les scores un à un.
     * La list doit être triée.
     * @param criteres
     * @return les résultat par ordre décroissant
     */
    public ArrayList<Resultat> rechercher(Critere... criteres) {
        resultats.clear(); // Nouvelle recherche on supprime l'ancienne
        for (Film f : bddTemporaire) {
            int score = 0;
            for (Critere c : criteres)
                score += c.evaluate(f);
            Resultat r = new Resultat(f, score);
            resultats.add(r);
        }
        // Cherche à avoir le plus gros score en premier
        Collections.sort(resultats, Collections.reverseOrder());
        return resultats;
    }
}
