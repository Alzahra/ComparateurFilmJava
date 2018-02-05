package bdd;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Représente un tableau de la base de données.
 * Doit avoir ses propres fonctions d'ajout, modification et suppression du
 * type d'élément que contient le tableau.
 */
abstract class Table {
    protected BaseDeDonnee bdd;

    public Table(BaseDeDonnee bdd) {
        this.bdd = bdd;
    }

    /**
     * Crée la table si elle n'existe pas.
     * @param csvPath chemin vers un fichier de données qui permet d'ajouter des entrées à la table
     */
    public void create(String csvPath) {
        StringBuilder stb = new StringBuilder("CREATE TABLE IF NOT EXISTS " + getName() + " (");
        String[] colonnes = getColonnes();
        for (int i = 0; i < colonnes.length; i++) {
            stb.append(colonnes[i]);
            if (i < colonnes.length-1)
                stb.append(",");
        }
        stb.append(");");
        //System.out.println("Dans Table::create() ->\n" + stb);
        bdd.execute(stb.toString());

        if (csvPath != null)
            ;
    }

    /**
     *
     * @return le nom de la table
     */
    public abstract String getName();

    /**
     * Permet d'avoir la liste des colonnes de la table avec leurs caractèristiques
     * @return liste des paramètres de chaque colonne
     */
    protected abstract String[] getColonnes();

    /**
     * Détruit la table
     */
    public void destroy() {
        try {
            Statement statement = bdd.getConnection().createStatement();
            statement.execute("DROP TABLE IF EXISTS " + getName() + ";");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
