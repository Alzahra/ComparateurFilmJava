package core;

import bdd.*;
import core.Criteres.Critere;
import ihm.main.Principale;

import javax.swing.*;
import java.lang.annotation.Native;
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
    /**
     * Les résultats de la dernière recherche
     */
    private ArrayList<Resultat> resultats = new ArrayList<>();

    public MoteurDeRecherche() {
        //bddTemporaire = bdd.getFilms(); // TODO : corriger ca
        bddTemporaire = TableFilms.getInstance().getFilms();
    }

    /**
     * Met à jour la liste des résultats et la renvoie.
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

    public static void main(String[] args) {
        BaseDeDonnee bdd = BaseDeDonnee.getInstance();
        TableFilms tf = TableFilms.getInstance();
        TableUtilisateurs tu = TableUtilisateurs.getInstance();

        // On repart à chaque fois d'une BDD neuve pour l'instant
        // Pas de sauvegarde des modifications des tables
        tf.destroy(); tu.destroy();
        bdd.createTable(tf, "./films.csv");
        bdd.createTable(tu, null);

        Principale fenPrincipale = new Principale("Comparateur Film", new MoteurDeRecherche());
        /*
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } */
        fenPrincipale.setVisible(true);
    }
}
