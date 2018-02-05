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
import javax.swing.JTextField;

public class DetailPanier {

	public static void main(String[] args) {
	
		JFrame fen = new JFrame();
		fen.setSize(900, 400);
		fen.setTitle("Login");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

		JPanel centre = new JPanel();
		
		centre.setLayout(new GridBagLayout());
		
		
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
	    centre.add(mess,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx = 0;
	    centre.add(titre, gbc);
	    gbc.gridx++;
		centre.add(nbjour, gbc);
		gbc.gridx++;
		centre.add(debut, gbc);
	    gbc.gridx++;
		centre.add(fin, gbc);
		gbc.gridx++;
		centre.add(prix, gbc);
	    gbc.gridx++;
		centre.add(supp, gbc);
		gbc.gridx++;
		
		//Pour creer l'espace, j'arrive pas a faire gbc.gridy=13;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
		gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);
	    gbc.gridy++;
	    centre.add(new JLabel(),gbc);

		
		gbc.gridx = 4;
		centre.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		centre.add(new JButton("Annuler"),gbc);
		gbc.gridy++;
		
		
	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);			
	}
}
