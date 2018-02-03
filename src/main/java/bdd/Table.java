package bdd;

abstract class Table {
    private BaseDeDonnee bdd;

    public Table(BaseDeDonnee bdd) {
        this.bdd = bdd;
    }

    /**
     * Crée la table si elle n'existe pas.
     */
    public void create() {
        StringBuilder stb = new StringBuilder("CREATE TABLE IF NOT EXISTS " + getName() + " (");
        String[] rows = getRows();
        for (int i = 0; i < rows.length; i++) {
            stb.append(rows[i]);
            if (i < rows.length)
                stb.append(",");
        }
        stb.append(");");
        bdd.execute(stb.toString());
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
    protected abstract String[] getRows();

    abstract void add();
}
