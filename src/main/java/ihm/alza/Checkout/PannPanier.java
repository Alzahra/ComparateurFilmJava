package ihm.alza.Checkout;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import ihm.alza.Paiement.*;


@SuppressWarnings("serial")
public class PannPanier extends JPanel{
	
	private DetailPanier fen;
	
	public PannPanier(DetailPanier d) {
		fen = d;
		//Apres reflexion, je pense qu'il faut faire une JTable puisque c'est un retour de requete BDD non ?
		
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
	    
	    JButton valider = new JButton("Valider");
	    JButton annuler = new JButton("Annuler");
	    
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
		this.add(valider,gbc);
		valider.addActionListener(new PannAcLis('V'));
		gbc.gridx++;
		this.add(annuler,gbc);
		annuler.addActionListener(new PannAcLis('A'));
		gbc.gridy++;
			
	}
	
	class PannAcLis implements ActionListener {

		private char action;
		public PannAcLis(char ac) {
			action = ac;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(action == 'V') {
				try {
					new Paiement();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				fen.dispose();	
			}if(action == 'A')
				fen.dispose();
		}
		
	}
	
}