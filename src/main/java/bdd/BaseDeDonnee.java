package bdd;

import org.h2.tools.Csv;

import java.sql.*;
import java.util.HashMap;

/**
 * TODO : mettre a jour les expirations de location de film (à chaque lancement ?)
 */
public class BaseDeDonnee {
	private Connection bdd;
	private HashMap<String, Table> tables = new HashMap<>();
	
	public BaseDeDonnee() {
		try {
			Class.forName("org.h2.Driver"); // On charge le module H2
			/*
			 * sa = system administrator
			 * créé automatiquement la BDD si n'existe pas et met les login à "sa" et pwd à ""
			 * TODO : voir le chiffrement de la BDD (simple option normalement)
			 */
			bdd = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
			tables.put("films", new TableFilms(this));
			tables.put("utilisateurs", new TableUtilisateurs(this));

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

	public void addFromCSV(String path, String table) {
		try{
			Csv csv = new Csv();
			csv.setFieldSeparatorRead('|');
			csv.setCaseSensitiveColumnNames(true);
			ResultSet rs = csv.read(path, null, null);
			ResultSetMetaData meta = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < meta.getColumnCount(); i++) {
					System.out.println(
							meta.getColumnLabel(i + 1) + ": " +
									rs.getString(i + 1));
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	static public void main(String[] args) {
		BaseDeDonnee baseDeDonnee = new BaseDeDonnee();
		//baseDeDonnee.ajouter(new Film(1, "Mr Bean", 160, 7.8f, 20, new Date(Date.valueOf("1994-6-10").getTime()),
		//		"drole", "Mr bean par en vacs :D", new String[]{"Le magnifique", "lul"}));
		baseDeDonnee.createTable(null, null);

		//for (Film f : baseDeDonnee.getFilms())
		//	System.out.println(f);
	}
}
