package ihm.alza.InscriConnex;

import java.awt.Color;
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
public class PannErrCo extends JPanel{

	private ErreurConnexion fen;
	
	public PannErrCo(ErreurConnexion f) {
		
		fen =f;
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mess = new JLabel("Veuillez vous identifier. ");
		mess.setFont(new Font("Serif", Font.BOLD, 20));
		
		JLabel pseudol = new JLabel("Identifiant: ", JLabel.CENTER);
	    JLabel mdpl = new JLabel("Mot de Passe: ", JLabel.CENTER);
	    
	    JTextField pseudo = new JTextField(10);
	    JPasswordField mdp = new JPasswordField(10); 
    
	    JButton valider = new JButton("Valider");
	    JButton annuler = new JButton("Annuler");
	    JButton inscription = new JButton("Inscris-toi");
	    
	    pseudol.setLabelFor(pseudo);
	    mdpl.setLabelFor(mdp);

	    gbc.insets = new Insets(10, 10, 10,10);
	    gbc.gridx=2;
	    this.add(mess,gbc);
	    gbc.gridy++;
	    
	    gbc.gridx = 1;
	    gbc.insets = new Insets(5, 5, 5, 0);
	    this.add(pseudol, gbc);
	    gbc.gridy++;
		this.add(mdpl, gbc);
		gbc.gridy++;
		gbc.gridx++;
		gbc.gridy = 1;
		this.add(pseudo, gbc);
		gbc.gridy++;
		this.add(mdp, gbc);
		gbc.gridy++;
		
		gbc.gridx = 2;
		JLabel jmess = new JLabel("Identifiant ou Mot de Passe Incorect, Veuillez Reessayer");
		this.add(jmess,gbc);
		jmess.setForeground(Color.RED);
		
		gbc.gridx++;
		gbc.gridy++;

		this.add(valider,gbc);
		valider.addActionListener(new ErrAcLis('V'));
		
		gbc.gridx++;
		this.add(annuler,gbc);
		annuler.addActionListener(new ErrAcLis('A'));
		gbc.gridy++;
		
		gbc.insets = new Insets(15, 5, 5, 1);
		gbc.gridx = 2;
		this.add(new JLabel("Pas encore inscrit ? --->"),gbc);
		gbc.gridx++;
		this.add(inscription,gbc);
		inscription.addActionListener(new ErrAcLis('I'));
	}
	
	class ErrAcLis implements ActionListener{
		
		private char c;
		public ErrAcLis(char c) {
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
