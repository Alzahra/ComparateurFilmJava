package bdd;

import org.h2.tools.Csv;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class TableFilms extends Table {
    private static TableFilms instance = null;

    public static TableFilms getInstance() {
        if (instance == null)
            instance = new TableFilms();
        return instance;
    }

    private TableFilms() {
    }

    @Override
    public String getName() {
        return "films";
    }

    @Override
    protected String[] getColonnes() {
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

    public void ajouter(Film film) {
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("INSERT INTO films (" +
                    "titre," +
                    "duree," +
                    "note," +
                    "prix," +
                    "date_sortie," +
                    "genres," +
                    "synopsis," +
                    "acteurs" +
                    ") values (?,?,?,?,?,?,?,?);");
            pst.setString(1, film.getTitre());
            pst.setInt(2, film.getDuree());
            pst.setBigDecimal(3, BigDecimal.valueOf(film.getNote()));
            pst.setBigDecimal(4, BigDecimal.valueOf(film.getPrix()));
            pst.setDate(5, film.getDateSortie());
            pst.setString(6, film.getGenre());
            pst.setString(7, film.getSynopsis());

            StringBuilder st = new StringBuilder();
            for (String s : film.getActeurs()) {
                st.append(s);
                st.append(";");
            }
            pst.setString(8, st.toString());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifier(Film film) {
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("UPDATE films" +
                    "SET titre=?," +
                    "duree=?," +
                    "note=?," +
                    "prix=?," +
                    "date_sortie=?," +
                    "genres=?," +
                    "synopsis=?," +
                    "acteurs=?" +
                    "WHERE id = ?;");
            pst.setString(1, film.getTitre());
            pst.setInt(2, film.getDuree());
            pst.setBigDecimal(3, BigDecimal.valueOf(film.getNote()));
            pst.setBigDecimal(4, BigDecimal.valueOf(film.getPrix()));
            pst.setDate(5, film.getDateSortie());
            pst.setString(6, film.getGenre());
            pst.setString(7, film.getSynopsis());

            StringBuilder st = new StringBuilder();
            for (String s : film.getActeurs()) {
                st.append(s);
                st.append(";");
            }
            pst.setString(8, st.toString());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(Film film) {
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("DELETE FROM films" +
                    "WHERE id=?;");
            pst.setInt(1, film.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Film> getFilms() {
        ArrayList<Film> films = new ArrayList<>();

        try {
            ResultSet set = BaseDeDonnee.getInstance().getConnection().prepareStatement("SELECT * FROM films").executeQuery();
            while (set.next()) {
                Film film = new Film(set.getInt("id"),
                        set.getString("titre"),
                        set.getInt("duree"),
                        set.getInt("note"),
                        set.getBigDecimal("prix").floatValue(),
                        set.getDate("date_sortie"),
                        set.getString("genres"),
                        set.getString("synopsis"),
                        set.getString("acteurs").split(";"));
                films.add(film);
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }


    public Film getFilm(String titre) {
        Film film = null;
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("SELECT * FROM films WHERE titre = ?");
            pst.setString(1, titre);
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                film = new Film(set.getInt("id"),
                        set.getString("titre"),
                        set.getInt("duree"),
                        set.getInt("note"),
                        set.getBigDecimal("prix").floatValue(),
                        set.getDate("date_sortie"),
                        set.getString("genres"),
                        set.getString("synopsis"),
                        set.getString("acteurs").split(";"));
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public void addFromCSV(String path) {
        try{
            Csv csv = new Csv();
            csv.setFieldSeparatorRead('|');
            csv.setCaseSensitiveColumnNames(true);
            ResultSet rs = csv.read(path, null, null);
            ResultSetMetaData meta = rs.getMetaData();

            String titre = null; int duree = 0; float note = 0;
            float prix = 0; Date sortie = new Date(0); String genre = null;
            String synopsis = null; String acteurs = null;

            while (rs.next()) {
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    switch (meta.getColumnLabel(i + 1)) {
                        case "titre":
                            titre = rs.getString(i + 1);
                            break;
                        case "duree":
                            duree = Integer.parseInt(rs.getString(i + 1));
                            break;
                        case "note":
                            note = Float.parseFloat(rs.getString(i + 1));
                            break;
                        case "prix":
                            prix = Float.parseFloat(rs.getString(i + 1));
                            break;
                        case "date_sortie":
                            sortie = Date.valueOf(rs.getString(i + 1));
                            break;
                        case "genres":
                            genre = rs.getString(i + 1);
                            break;
                        case "synopsis":
                            synopsis = rs.getString(i + 1);
                            break;
                        case "acteurs":
                            acteurs = rs.getString(i + 1);
                            break;
                    }
                }

                try {
                    PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("INSERT INTO films (" +
                            "titre," +
                            "duree," +
                            "note," +
                            "prix," +
                            "date_sortie," +
                            "genres," +
                            "synopsis," +
                            "acteurs" +
                            ") values (?,?,?,?,?,?,?,?);");
                    pst.setString(1, titre);
                    pst.setInt(2, duree);
                    pst.setBigDecimal(3, BigDecimal.valueOf(note));
                    pst.setBigDecimal(4, BigDecimal.valueOf(prix));
                    pst.setDate(5, sortie);
                    pst.setString(6, genre);
                    pst.setString(7, synopsis);
                    pst.setString(8, acteurs);
                    pst.executeUpdate();
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
