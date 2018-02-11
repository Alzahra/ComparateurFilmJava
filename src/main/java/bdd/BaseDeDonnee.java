package bdd;

import org.h2.tools.Csv;

import java.sql.*;
import java.util.HashMap;

/**
 * Class de type singleton.
 * Elle prend en charge la gestion global de la base de donnée.
 * A savoir la création de celle-ci, la gestion des requêtes et
 * la création des tables qui la compose.
 */
public class BaseDeDonnee {
	private Connection bdd;

	private static BaseDeDonnee instance = null;

	public static BaseDeDonnee getInstance() {
		if (instance == null)
			instance = new BaseDeDonnee();
		return instance;
	}

	/**
	 *
	 */
	private BaseDeDonnee() {
		try {
			Class.forName("org.h2.Driver"); // On charge le module H2
			/*
			 * sa = system administrator
			 * créé automatiquement la BDD si n'existe pas et met les login à "sa" et pwd à ""
			 * TODO : voir le chiffrement de la BDD (simple option normalement)
			 */
			bdd = DriverManager.getConnection("jdbc:h2:./test", "sa", "");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Retourne une connection à la base de donnée.
	 * Permet d'effectuer des requêtes complexes
	 * (des requêtes qui requiert une préparation).
	 * @return connexion à la base de donnée
	 */
	public Connection getConnection() {
		return bdd;
	}

	/**
	 * Crée une table dans la base de donnée
	 * @param t la table à créer
	 * @param csv (facultatif) le fichier csv contenant des entrées pour la table
	 */
	public void createTable(Table t, String csv) {
		t.create(csv);
	}

	/**
	 * Permet d'executer une action simple sur la BDD (sans paramètre ni retour)
	 * @param action l'action au format SQL à effectuer
	 */
	public void execute(String action) {
		try {
			Statement statement = bdd.createStatement();
			statement.execute(action);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
