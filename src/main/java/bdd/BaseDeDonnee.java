package bdd;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO : mettre a jour les expirations de location de film (à chaque lancement ?)
 */
public class BaseDeDonnee {
	private Connection bdd;
	
	public BaseDeDonnee() {
		try {
			Class.forName("org.h2.Driver"); // On charge le module H2
			/*
			 * sa = system administrator
			 * créé automatiquement la BDD si n'existe pas et met les login à "sa" et pwd à ""
			 * TODO : voir le chiffrement de la BDD (simple option normalement)
			 */
			bdd = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
			createTables();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Va créer les tables Utilisateur et Film si besoin
	 */
	public void createTables() {
		/* On vérifie que les tables ne sont pas déjà créés. */
		/* On crée les tables. */

		try {
			Statement statement = bdd.createStatement();
			statement.execute("DROP TABLE IF EXISTS films, utilisateurs;");
			statement.execute("CREATE TABLE IF NOT EXISTS films (" +
					"id INT AUTO_INCREMENT (0, 1) PRIMARY KEY," +
					"titre VARCHAR(255) NOT NULL UNIQUE," +
					"duree SMALLINT NOT NULL," +
					"note DECIMAL NOT NULL," +
					"prix DECIMAL NOT NULL," +
					"date_sortie DATE NOT NULL," +
					"genres VARCHAR(15) NOT NULL," +
					"synopsis VARCHAR(1500) NOT NULL," +
					"acteurs VARCHAR(300) NOT NULL" +
					");");
			statement.execute("CREATE TABLE IF NOT EXISTS utilisateurs (" +
					"id INT AUTO_INCREMENT (0, 1) PRIMARY KEY," +
					"nom VARCHAR(35) NOT NULL," +
					"prenom VARCHAR(35) NOT NULL," +
					"pseudo VARCHAR(35) NOT NULL UNIQUE," +
					"email VARCHAR(35) NOT NULL UNIQUE," +
					"films_loue VARCHAR(1000)," +
					"solde DECIMAL NOT NULL," +
					"role VARCHAR(6) NOT NULL" +
					");");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* TODO :
	 * Doit y avoir moyen de simplifier tout ca.
	 * Créer une classe/interface Table, avoir deux spécifications, TableUtilisateur et TableFilm
	 * Avoir qu'une seule méthode pr ajouter/modifier/supprimer quelque soit le type ?!
	 */
	/**
	 * Ajoute une entrée à la BDD
	 * TODO : définir ce qui fait qu'un utilisateur est unique (je dirais le PSEUDO)
	 * @param user l'utilisateur à ajouter (contient déjà toutes les données nécessaire).
	 *
	 * Doit provoquer une erreur/exception lorsque le speudo est déjà utilisé.
	 */
	public void ajouter(Utilisateur user) {

	}

	public void ajouter(Film film) {
		try {
			PreparedStatement pst = bdd.prepareStatement("INSERT INTO films (" +
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

	public void modifier(Utilisateur user) {

	}

	public void modifier(Film film) {
		try {
			PreparedStatement pst = bdd.prepareStatement("UPDATE films" +
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

	public void supprimer(Utilisateur user) {

	}

	public void supprimer(Film film) {

	}

	public ArrayList<Film> getBDD() {
		ArrayList<Film> films = new ArrayList<>();

		try {
			ResultSet set = bdd.prepareStatement("SELECT * FROM films").executeQuery();
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

	static public void main(String[] args) {
		BaseDeDonnee baseDeDonnee = new BaseDeDonnee();
		baseDeDonnee.ajouter(new Film(1, "Mr Bean", 160, 7.8f, 20, new Date(Date.valueOf("1994-6-10").getTime()),
				"drole", "Mr bean par en vacs :D", new String[]{"Le magnifique", "lul"}));


		for (Film f : baseDeDonnee.getBDD())
			System.out.println(f);
	}
}
