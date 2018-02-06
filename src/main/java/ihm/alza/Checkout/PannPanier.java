package Checkout;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PannPanier extends JPanel{
	
	public PannPanier() {
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mess = new JLabel("Detail du panier ",JLabel.CENTER);
		mess.setFont(new Font("Serif", Font.BOLD, 30));
		JLabel titre = new JLabel("Titre ", JLabel.CENTER);
	    JLabel nbjour = new JLabel("Nombre de jours de location ", JLabel.CENTER);
	    JLabel debut = new JLabel("Date de debut de location ", JLabel.CENTER);
	    JLabel fin = new JLabel("Date de fin de location ", JLabel.CENTER);
	    JLabel prix = new JLabel("Prix ", JLabel.CENTER);
	    JLabel supp = new JLabel("Supprimer ", JLabel.CENTER);
	    
	    gbc.insets = new Insets(10, 10, 10,10);

	    gbc.gridx=2;
	    this.add(mess,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx = 0;
	    this.add(titre, gbc);
	    gbc.gridx++;
		this.add(nbjour, gbc);
		gbc.gridx++;
		this.add(debut, gbc);
	    gbc.gridx++;
		this.add(fin, gbc);
		gbc.gridx++;
		this.add(prix, gbc);
	    gbc.gridx++;
		this.add(supp, gbc);
		gbc.gridx++;
		
		//Pour creer l'espace, j'arrive pas a faire gbc.gridy=13;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
		gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);
	    gbc.gridy++;
	    this.add(new JLabel(),gbc);

		
		gbc.gridx = 4;
		this.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		this.add(new JButton("Annuler"),gbc);
		gbc.gridy++;
		
			
	}
}
