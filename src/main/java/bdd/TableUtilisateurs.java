package bdd;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableUtilisateurs extends Table {
    private static TableUtilisateurs instance = null;

    public static TableUtilisateurs getInstance() {
        if (instance == null)
            instance = new TableUtilisateurs(BaseDeDonnee.getInstance());
        return instance;
    }

    private TableUtilisateurs(BaseDeDonnee bdd) {
        super(bdd);
    }

    @Override
    public String getName() {
        return "utilisateurs";
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

    /**
     * Ajoute une entrée à la BDD
     * TODO : définir ce qui fait qu'un utilisateur est unique (je dirais le PSEUDO)
     * @param user l'utilisateur à ajouter (contient déjà toutes les données nécessaire).
     *
     * Doit provoquer une erreur/exception lorsque le speudo est déjà utilisé.
     */
    public void ajouter(Utilisateur user, String pwd) {
        try {
            PreparedStatement pst = bdd.getConnection().prepareStatement("INSERT INTO utilisateurs (" +
                    "nom," +
                    "prenom," +
                    "pseudo," +
                    "email," +
                    "solde," +
                    "role," +
                    "pwd" +
                    ") values (?,?,?,?,?,?,?);");
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getPseudo());
            pst.setString(4, user.getEmail());
            if (user.getRole().equals("user"))
                pst.setBigDecimal(5, BigDecimal.valueOf(((Client) user).getSolde()));
            else
                pst.setBigDecimal(5, BigDecimal.valueOf(0));
            pst.setString(6, user.getRole());
            pst.setString(7, pwd);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifier(Utilisateur user, String pwd) {
        try {
            PreparedStatement pst = bdd.getConnection().prepareStatement("UPDATE utilisateurs" +
                    "SET nom=?," +
                    "prenom=?," +
                    "pseudo=?," +
                    "email=?," +
                    "solde=?," +
                    "role=?," +
                    "films_loue=?," +
                    "pwd=?" +
                    "WHERE id = ?;");
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getPseudo());
            pst.setString(4, user.getEmail());
            if (user.getRole().equals("user")) {
                pst.setBigDecimal(5, BigDecimal.valueOf(((Client) user).getSolde()));
                pst.setString(7, Client.formatFilmsForBDD((Client)user));
            }
            else {
                pst.setBigDecimal(5, BigDecimal.valueOf(0));
                pst.setString(7, "");
            }
            pst.setString(6, user.getRole());
            pst.setString(8, pwd);
            pst.setInt(9, user.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimer(Utilisateur user) {
        try {
            PreparedStatement pst = bdd.getConnection().prepareStatement("DELETE FROM utilisateurs" +
                    "WHERE id=?;");
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param pseudo
     * @param pwd
     * @return null si pas le bon login
     */
    public Utilisateur getUser(String pseudo, String pwd, TableFilms tFilms) {
        Utilisateur user = null;
        try {
            PreparedStatement pst = bdd.getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ?;");
            pst.setString(1, pseudo);
            ResultSet set = pst.executeQuery();
            if (set.next()) {
                if (set.getString("role").equals("user")) {
                    user = new Client(set.getInt("id"),
                            pseudo, set.getString("nom"), set.getString("prenom"),
                            set.getString("email"), set.getString("role"),
                            set.getBigDecimal("solde").floatValue(), Client.formatFilmsForClient(set.getString("films_loue"), tFilms));
                } else {
                    user = new Utilisateur(set.getInt("id"),
                            pseudo, set.getString("nom"), set.getString("prenom"),
                            set.getString("email"), set.getString("role"));
                }
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
