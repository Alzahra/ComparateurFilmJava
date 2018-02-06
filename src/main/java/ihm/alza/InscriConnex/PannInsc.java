package InscriConnex;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PannInsc extends JPanel{

	public PannInsc() {
		this.setLayout(new GridBagLayout());
		
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
	    this.add(pseudol, gbc);
	    gbc.gridy++;
		this.add(mdpl, gbc);
		gbc.gridy++;
		this.add(noml, gbc);
		gbc.gridy++;
		this.add(prenoml, gbc);
		gbc.gridy++;
		this.add(emaill, gbc);
		gbc.gridx++;
		gbc.gridy = 0;
		this.add(pseudo, gbc);
		gbc.gridy++;
		this.add(mdp, gbc);
		gbc.gridy++;
		this.add(nom, gbc);
		gbc.gridy++;
		this.add(prenom, gbc);
		gbc.gridy++;
		this.add(email, gbc);
		gbc.gridy++;


		
	}
}
