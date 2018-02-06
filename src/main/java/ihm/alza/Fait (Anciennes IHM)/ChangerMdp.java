package Fait;

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

public class ChangerMdp {
	
	public static void main(String[] args) {
		JFrame fen = new JFrame();
		fen.setSize(500, 250);
		fen.setTitle("Modification du mot de passe");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

		JPanel centre = new JPanel();
		centre.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mdpactuel = new JLabel("Ancien Mot de Passe: ", JLabel.CENTER);
	    JLabel nvmdpl = new JLabel("Nouveau mot de passe: ", JLabel.CENTER);
	    JLabel confmdpl = new JLabel("Confirmer nouveau mot de passe: ", JLabel.CENTER);

	    JPasswordField mdpactu = new JPasswordField(10);
	    JPasswordField nvmdp = new JPasswordField(10); 
	    JPasswordField confmdp = new JPasswordField(10);

	    
	    mdpactuel.setLabelFor(mdpactu);
	    nvmdpl.setLabelFor(nvmdp);
	    confmdpl.setLabelFor(confmdp);

	    gbc.insets = new Insets(10, 5, 7, 1);
	    centre.add(mdpactuel, gbc);
	    gbc.gridy++;
		centre.add(nvmdpl, gbc);
		gbc.gridy++;
		centre.add(confmdpl, gbc);
		gbc.gridy++;
		
		gbc.gridx++;
		gbc.gridy = 0;
		centre.add(mdpactu, gbc);
		gbc.gridy++;
		centre.add(nvmdp, gbc);
		gbc.gridy++;
		centre.add(confmdp, gbc);
		gbc.gridy++;
		
		gbc.gridy++;
		centre.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Annuler"),gbc);
		gbc.gridy++;

	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
		
	}
}
