package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			bdd = DriverManager.getConnection("jdbc:h2:test", "sa", "");
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

	}

	public void modifier(Utilisateur user) {

	}

	public void modifier(Film film) {

	}

	public void supprimer(Utilisateur user) {

	}

	public void supprimer(Film film) {

	}
}
