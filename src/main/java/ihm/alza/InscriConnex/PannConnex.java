package ihm.alza.InscriConnex;

import java.awt.Font;
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
public class PannConnex extends JPanel{

	private Connexion fen;
	
	public PannConnex(Connexion f) {
		this.setLayout(new GridBagLayout());
		fen =f;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mess = new JLabel("Veuillez vous identifier. ");
		mess.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel pseudol = new JLabel("Identifiant: ");
	    JLabel mdpl = new JLabel("Mot de Passe: ");
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
	    
	    JButton inscription = new JButton("Inscris-toi");
	    JButton valider = new JButton("Valider");
	    JButton annuler = new JButton("Annuler");
	    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);

	    gbc.gridy = 0;
	    gbc.gridx = 1;
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.insets = new Insets(10, 5, 10, 1);
	    this.add(mess,gbc);
	    
	    gbc.insets = new Insets(5, 5, 5, 1);
	    gbc.gridy = 1;
	    gbc.gridx = 0;
	    this.add(pseudol, gbc);
	    gbc.gridy = 2;
		this.add(mdpl, gbc);
		gbc.gridy = 3;
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(pseudo, gbc);
		gbc.gridy = 2;
		this.add(mdp, gbc);
		
		gbc.gridy=4;
		this.add(valider,gbc);
		valider.addActionListener(new ConnAcLis('V'));
		
		gbc.gridx = 2;
		this.add(annuler,gbc);
		annuler.addActionListener(new ConnAcLis('A'));
		
//		JSeparator separator = new JSeparator();
//        gbc.gridx = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(3, 5, 0, 5);
//        this.add(separator, gbc);
//        gbc.gridy++;
		
		gbc.gridy= 5;
		gbc.insets = new Insets(10, 5, 5, 1);
		gbc.gridx=0;
		this.add(new JLabel("Pas encore inscrit ? --->"),gbc);
		gbc.gridx=1;
		this.add(inscription,gbc);
		inscription.addActionListener(new ConnAcLis('I'));
		
	}
	
	class ConnAcLis implements ActionListener {
		
		private char c;
		public ConnAcLis (char c) {
			this.c = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(c=='V') {
//				if(verifierMdp()) new FenetrePrincipale();
//				else new ErreurConnexion();
				fen.dispose();
			}if(c=='A')	
				fen.dispose();
			if (c=='I')	{
				new Inscription();
				//fen.dispose();
			}
		}
		
	}
	
}
