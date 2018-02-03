package core.Criteres;

import bdd.Film;

/**
 * Chaque critère est évalué d'une facon bien précise
 */
public abstract class Critere {
    abstract public int evaluate(Film film);
}
