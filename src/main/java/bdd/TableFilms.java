package bdd;

public class TableFilms extends Table implements CsvReader {
    public TableFilms(BaseDeDonnee bdd) {
        super(bdd);
    }

    @Override
    public void addFromCsv(String path) {

    }

    @Override
    public String getName() {
        return "films";
    }

    @Override
    protected String[] getRows() {
        return new String[] {

        };
    }

    @Override
    void add() {

    }
}
