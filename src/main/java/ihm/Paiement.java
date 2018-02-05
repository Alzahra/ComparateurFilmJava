import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Paiement {
	
	public static void main(String[] args) {
		//TODO centrer le mess + tracer trait
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
		
		JLabel mess = new JLabel("Veuillez vous identifier. ",JLabel.RIGHT);
		
		JLabel pseudol = new JLabel("Identifiant: ", JLabel.CENTER);
	    JLabel mdpl = new JLabel("Mot de Passe: ", JLabel.CENTER);
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);

	    gbc.insets = new Insets(10, 5, 10, 1);
	    centre.add(mess,gbc);
	    gbc.insets = new Insets(5, 5, 5, 1);
	    gbc.gridy++;
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
		
	
		gbc.gridy++;
		centre.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Annuler"),gbc);
		gbc.gridy++;
		
		gbc.insets = new Insets(15, 5, 5, 1);
		gbc.gridx =0;
		centre.add(new JLabel("Pas encore inscrit ? --->"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Inscris-toi"),gbc);
		
	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);			
	}
}
