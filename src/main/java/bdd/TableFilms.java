package bdd;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableFilms extends Table {
    public TableFilms(BaseDeDonnee bdd) {
        super(bdd);
    }

    @Override
    public String getName() {
        return "films";
    }

    @Override
    protected String[] getColonnes() {
        return new String[] {
                "id INT AUTO_INCREMENT (0, 1) PRIMARY KEY",
                "nom VARCHAR(35) NOT NULL",
                "prenom VARCHAR(35) NOT NULL",
                "pseudo VARCHAR(35) NOT NULL UNIQUE",
                "email VARCHAR(35) NOT NULL UNIQUE",
                "films_loue VARCHAR(1000)",
                "solde DECIMAL NOT NULL",
                "role VARCHAR(6) NOT NULL",
                "pwd VARCHAR(256) NOT NULL"
        };
    }

    public void ajouter(Film film) {
        try {
            PreparedStatement pst = bdd.getConnection().prepareStatement("INSERT INTO films (" +
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
            PreparedStatement pst = bdd.getConnection().prepareStatement("UPDATE films" +
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
            PreparedStatement pst = bdd.getConnection().prepareStatement("DELETE FROM films" +
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
            ResultSet set = bdd.getConnection().prepareStatement("SELECT * FROM films").executeQuery();
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
            PreparedStatement pst = bdd.getConnection().prepareStatement("SELECT * FROM films WHERE titre = ?");
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
}
