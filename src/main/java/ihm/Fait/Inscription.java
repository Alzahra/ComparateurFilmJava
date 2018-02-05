package Fait;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inscription {

	public static void main(String[] args) {
		JFrame fen = new JFrame();
		fen.setSize(400, 300);
		fen.setTitle("Formulaire d'inscription");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

		JPanel centre = new JPanel();
		centre.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel pseudol = new JLabel("Pseudo: ", JLabel.CENTER);
	    JLabel mdpl = new JLabel("Mot de Passe: ", JLabel.CENTER);
	    JLabel noml = new JLabel("Nom: ", JLabel.CENTER);
	    JLabel prenoml = new JLabel("Prenom: ", JLabel.CENTER);
	    JLabel emaill = new JLabel("Email: ", JLabel.CENTER);
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
	    JTextField nom = new JTextField(10);
	    JTextField prenom = new JTextField(10);
	    JTextField email = new JTextField(10); 
	    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);
	    noml.setLabelFor(nom);
	    prenoml.setLabelFor(prenom);
	    emaill.setLabelFor(email);

	    gbc.insets = new Insets(10, 5, 3, 1);
	    centre.add(pseudol, gbc);
	    gbc.gridy++;
		centre.add(mdpl, gbc);
		gbc.gridy++;
		centre.add(noml, gbc);
		gbc.gridy++;
		centre.add(prenoml, gbc);
		gbc.gridy++;
		centre.add(emaill, gbc);
		gbc.gridx++;
		gbc.gridy = 0;
		centre.add(pseudo, gbc);
		gbc.gridy++;
		centre.add(mdp, gbc);
		gbc.gridy++;
		centre.add(nom, gbc);
		gbc.gridy++;
		centre.add(prenom, gbc);
		gbc.gridy++;
		centre.add(email, gbc);
		gbc.gridy++;

	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
		
	}
}
