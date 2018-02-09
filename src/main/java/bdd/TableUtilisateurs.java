package bdd;

import org.h2.tools.Csv;

import java.math.BigDecimal;
import java.sql.*;

public class TableUtilisateurs extends Table {
    private static TableUtilisateurs instance = null;

    public static TableUtilisateurs getInstance() {
        if (instance == null)
            instance = new TableUtilisateurs();
        return instance;
    }

    private TableUtilisateurs() {
    }

    @Override
    public String getName() {
        return "utilisateurs";
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

    /**
     * Ajoute une entrée à la BDD
     * TODO : définir ce qui fait qu'un utilisateur est unique (je dirais le PSEUDO)
     * @param user l'utilisateur à ajouter (contient déjà toutes les données nécessaire).
     *
     * Doit provoquer une erreur/exception lorsque le speudo est déjà utilisé.
     */
    public void ajouter(Utilisateur user, String pwd) {
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("INSERT INTO utilisateurs (" +
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
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("UPDATE utilisateurs" +
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
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("DELETE FROM utilisateurs" +
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
     * @return null si pas le bon login
     */
    public Utilisateur getUser(String pseudo) {
        Utilisateur user = null;
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ?;");
            pst.setString(1, pseudo);
            ResultSet set = pst.executeQuery();
            if (set.next()) {
                if (set.getString("role").equals("user")) {
                    user = new Client(set.getInt("id"),
                            pseudo, set.getString("nom"), set.getString("prenom"),
                            set.getString("email"), set.getString("role"),
                            set.getBigDecimal("solde").floatValue(), Client.formatFilmsForClient(set.getString("films_loue"), TableFilms.getInstance()));
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

    public String getPwd(Utilisateur user) {
        String pwd = null;
        try {
            PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("SELECT * FROM utilisateurs WHERE pseudo = ?;");
            pst.setString(1, user.getPseudo());
            ResultSet set = pst.executeQuery();
            if (set.next()) {
                pwd = set.getString("pwd");
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwd;
    }

    @Override
    public void addFromCSV(String path) {
        try{
            Csv csv = new Csv();
            csv.setFieldSeparatorRead('|');
            csv.setCaseSensitiveColumnNames(true);
            ResultSet rs = csv.read(path, null, null);
            ResultSetMetaData meta = rs.getMetaData();

            String nom = null; String prenom = null; String pseudo = null;
            String email = null; float solde = 0; String role = null;
            String pwd = null;

            while (rs.next()) {
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    switch (meta.getColumnLabel(i + 1)) {
                        case "nom":
                            nom = rs.getString(i + 1);
                            break;
                        case "prenom":
                            prenom = rs.getString(i + 1);
                            break;
                        case "pseudo":
                            pseudo = rs.getString(i + 1);
                            break;
                        case "email":
                            email = rs.getString(i + 1);
                            break;
                        case "solde":
                            solde = Float.parseFloat(rs.getString(i + 1));
                            break;
                        case "pwd":
                            pwd = rs.getString(i + 1);
                            break;
                    }
                }

                try {
                    PreparedStatement pst = BaseDeDonnee.getInstance().getConnection().prepareStatement("INSERT INTO utilisateurs (" +
                            "nom," +
                            "prenom," +
                            "pseudo," +
                            "email," +
                            "solde," +
                            "role," +
                            "pwd" +
                            ") values (?,?,?,?,?,?,?);");
                    pst.setString(1, nom);
                    pst.setString(2, prenom);
                    pst.setString(3, pseudo);
                    pst.setString(4, email);
                    if (role.equals("user"))
                        pst.setBigDecimal(5, BigDecimal.valueOf(solde));
                    else
                        pst.setBigDecimal(5, BigDecimal.valueOf(0));
                    pst.setString(6, role);
                    pst.setString(7, pwd);
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
