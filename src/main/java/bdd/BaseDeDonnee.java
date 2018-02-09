package bdd;

import org.h2.tools.Csv;

import java.sql.*;
import java.util.HashMap;

/**
 * TODO : mettre a jour les expirations de location de film (à chaque lancement ?)
 */
public class BaseDeDonnee {
	private Connection bdd;

	private static BaseDeDonnee instance = null;

	public static BaseDeDonnee getInstance() {
		if (instance == null)
			instance = new BaseDeDonnee();
		return instance;
	}

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
	 * Retourne la connection à la BDD
	 * TODO : devrait être enlevé et prévoir des méthodes qui permettent une certaines abstraction (cf. execute())
	 * @return
	 */
	public Connection getConnection() {
		return bdd;
	}

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
