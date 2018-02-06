package Fait;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Connexion {
	public static void main(String[] args) {
		//TODO  tracer trait
		JFrame fen = new JFrame();
		fen.setSize(500, 300);
		fen.setTitle("Login");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

		JPanel centre = new JPanel();
		centre.setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mess = new JLabel("Veuillez vous identifier. ");
		mess.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel pseudol = new JLabel("Identifiant: ");
	    JLabel mdpl = new JLabel("Mot de Passe: ");
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);

	    gbc.gridy = 0;
	    gbc.gridx = 1;
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.insets = new Insets(10, 5, 10, 1);
	    centre.add(mess,gbc);
	    
	    gbc.insets = new Insets(5, 5, 5, 1);
	    gbc.gridy = 1;
	    gbc.gridx = 0;
	    centre.add(pseudol, gbc);
	    gbc.gridy = 2;
		centre.add(mdpl, gbc);
		gbc.gridy = 3;
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		centre.add(pseudo, gbc);
		gbc.gridy = 2;
		centre.add(mdp, gbc);
		
		gbc.gridy=4;
		centre.add(new JButton("Valider"),gbc);
		gbc.gridx = 2;
		centre.add(new JButton("Annuler"),gbc);
		
		
//		JSeparator separator = new JSeparator();
//        gbc.gridx = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(3, 5, 0, 5);
//        centre.add(separator, gbc);
//        gbc.gridy++;
		
		gbc.gridy= 5;
		gbc.insets = new Insets(10, 5, 5, 1);
		gbc.gridx=0;
		centre.add(new JLabel("Pas encore inscrit ? --->"),gbc);
		gbc.gridx=1;
		centre.add(new JButton("Inscris-toi"),gbc);
		
	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);			
	}
}
