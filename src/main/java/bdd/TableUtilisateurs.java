package bdd;

public class TableUtilisateurs extends Table implements CsvReader {

    public TableUtilisateurs(BaseDeDonnee bdd) {
        super(bdd);
    }

    @Override
    public void addFromCsv(String path) {

    }

    @Override
    public String getName() {
        return "utilisateurs";
    }

    @Override
    protected String[] getRows() {
        return new String[] {
                "id INT AUTO_INCREMENT (0, 1) PRIMARY KEY",
                "titre VARCHAR(255) NOT NULL UNIQUE",
                "duree SMALLINT NOT NULL",
                "note DECIMAL NOT NULL",
                "prix DECIMAL NOT NULL",
                "date_sortie DATE NOT NULL",
                "genres VARCHAR(15) NOT NULL",
                "synopsis VARCHAR(1500) NOT NULL",
                "acteurs VARCHAR(300) NOT NULL"
        };
    }

    @Override
    void add() {

    }
}
