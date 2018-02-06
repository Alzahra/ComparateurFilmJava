package Fait;

import java.awt.Color;
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
import javax.swing.JTextField;

public class ErreurConnexion {

	public static void main(String[] args) {
		//TODO tracer trait
		JFrame fen = new JFrame();
		fen.setSize(700, 300);
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
		
		JLabel pseudol = new JLabel("Identifiant: ", JLabel.CENTER);
	    JLabel mdpl = new JLabel("Mot de Passe: ", JLabel.CENTER);
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);

	    gbc.insets = new Insets(10, 10, 10,10);
	    gbc.gridx=2;
	    centre.add(mess,gbc);
	    gbc.gridy++;
	    
	    gbc.gridx = 1;
	    gbc.insets = new Insets(5, 5, 5, 0);
	    centre.add(pseudol, gbc);
	    gbc.gridy++;
		centre.add(mdpl, gbc);
		gbc.gridy++;
		gbc.gridx++;
		gbc.gridy = 1;
		centre.add(pseudo, gbc);
		gbc.gridy++;
		centre.add(mdp, gbc);
		gbc.gridy++;
		
		gbc.gridx = 2;
		JLabel jmess = new JLabel("Identifiant ou Mot de Passe Incorect, Veuillez Reessayer");
		centre.add(jmess,gbc);
		jmess.setForeground(Color.RED);
		
		gbc.gridx++;
		gbc.gridy++;
		centre.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Annuler"),gbc);
		gbc.gridy++;
		
		gbc.insets = new Insets(15, 5, 5, 1);
		gbc.gridx = 2;
		centre.add(new JLabel("Pas encore inscrit ? --->"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Inscris-toi"),gbc);
		
	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);			
	}
}
