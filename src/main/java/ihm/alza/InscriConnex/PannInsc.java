package ihm.alza.InscriConnex;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PannInsc extends JPanel{

	private Inscription fen;
	public PannInsc(Inscription f) {
		this.setLayout(new GridBagLayout());
		fen =f;
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
	    
	    JButton valider = new JButton("Valider");
	    JButton annuler = new JButton("Annuler");

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
		this.add(valider,gbc);
		valider.addActionListener(new InsAcLis('V'));
		gbc.gridx++;
		this.add(annuler,gbc);
		annuler.addActionListener(new InsAcLis('A'));
		gbc.gridy++;
			
	}
	
	class InsAcLis implements ActionListener{
		
		private char c;
		public InsAcLis(char c) {
			this.c=c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
//			if (c=='V'){
//				if(nonexistant)
//					new FenetrePrincipaleConn(); 
// 					ou new Connexion();
//				else new JFrame("Compte Existant"); //Quelque chose comme ca
//			}if(c=='A'){
//				//new Fenetreprincipale et
			fen.dispose();
//			}
		}
		
		
	}
	
	
}
