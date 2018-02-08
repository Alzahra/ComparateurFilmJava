package ihm.alza.InformationCompte;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class PannModCl extends JPanel{
	
	private ModifInfCl fen;
	private InformationClient fenancienne;
	private JTextField prenom;
	private JTextField nom ;
	private JTextField mail; 


	public PannModCl(ModifInfCl f,InformationClient fa) {
		fen = f;
		fenancienne = fa;
		GridLayout g = new GridLayout(1,3);
		this.setLayout(g);
		
		GridBagLayout gb = new GridBagLayout();
		JPanel p = new JPanel();
		p.setLayout(gb);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mess = new JLabel("Information du compte ",JLabel.CENTER);
		mess.setFont(new Font("Serif", Font.BOLD, 30));
		JLabel info = new JLabel("Infos Personnels ", JLabel.CENTER);
	    JLabel noml = new JLabel("Nom", JLabel.CENTER);
	    JLabel prenoml = new JLabel("Prenom", JLabel.CENTER);
	    JLabel maill = new JLabel("e-mail ", JLabel.CENTER);
	    JLabel filml = new JLabel("Film loue ", JLabel.CENTER);
	    JLabel soldel= new JLabel("Solde du compte ", JLabel.CENTER);
	    
	    nom = new JTextField(10);
	    nom.setEditable(true);
	    prenom = new JTextField(10);
	    prenom.setEditable(true);
	    mail = new JTextField(10);
	    mail.setEditable(true);
	    JTextField solde = new JTextField(5);
	    solde.setEditable(false);
	    
	    noml.setLabelFor(nom);
	    prenoml.setLabelFor(prenom);
	    maill.setLabelFor(mail);
	    
	    
	    JButton modifinf = new JButton("Valider modifications infos");
	    JButton modifmdp = new JButton ("Modifier mot de passe");
	    JButton supp = new JButton("Supprimer le compte");
	    JButton recharger = new JButton("Recharger");
	    modifmdp.setEnabled(false);  
	    supp.setEnabled(false);
	    recharger.setEnabled(false);
	    
	    JButton retour = new JButton("Retour");
	    
	    gbc.insets = new Insets(10, 10, 10,10);

	    gbc.gridx=0;
	    gbc.anchor = GridBagConstraints.BASELINE_LEADING;
	    p.add(mess,gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx = 0;
	   
	    p.add(info, gbc);
	    
	    gbc.gridx=0;
	    gbc.gridy=4;
	    gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		p.add(noml, gbc);
		gbc.anchor = GridBagConstraints.BASELINE;
		p.add(nom, gbc);
	
		gbc.gridx = 0;
		gbc.gridy=5;
	    gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		p.add(prenoml, gbc);
		gbc.anchor = GridBagConstraints.BASELINE;
		p.add(prenom,gbc);
		
		gbc.gridx = 0;
		gbc.gridy=6;
	    gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		p.add(maill, gbc);
		gbc.anchor = GridBagConstraints.BASELINE;
		p.add(mail,gbc);
		
		
		gbc.gridx = 0;
	    gbc.gridy=7;
		p.add(modifinf, gbc);
		modifinf.addActionListener(new GestAcLis('V'));
		
	    gbc.gridy=8;
		p.add(modifmdp, gbc);


		gbc.gridx = 0;
	    gbc.gridy=7;
		p.add(modifinf, gbc);
		modifinf.addActionListener(new GestAcLis('I'));
		
	    gbc.gridy=8;
		p.add(modifmdp, gbc);
		
		
	    gbc.gridy=10;
	    p.add(supp, gbc);
	
	    
	    this.add(p);
	    
	    gbc.gridx = 0;
		gbc.gridy = 0;
		p = new JPanel();
		p.setLayout(gb);

	    gbc.anchor = GridBagConstraints.NORTH;
	    p.add(filml,gbc);
		//Add une JTable peut etre pour le resultat de la requete ?
	    //En attendant : 
	    gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
	  	gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
	  	gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
		
	    this.add(p);
	    
	    gbc.gridx = 0;
	  	gbc.gridy = 0;
	  	p = new JPanel();
	  	p.setLayout(gb);
	    
	  	gbc.gridy=3;
	  	gbc.anchor = GridBagConstraints.BASELINE_LEADING;
	  	p.add(soldel,gbc);
	  	gbc.gridx++;
	  	gbc.gridwidth = GridBagConstraints.REMAINDER;
	  	p.add(solde, gbc);
	  	
	  	gbc.gridy++;
	  	gbc.gridwidth = GridBagConstraints.REMAINDER;
	  	p.add(recharger, gbc);
	

		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
	  	gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  	p.add(new JLabel(),gbc);
		gbc.gridy++;
	  
	    gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		p.add(retour,gbc);
		retour.addActionListener(new GestAcLis('R')); //inutile en soit, peut etre regrouper
		this.add(p);
	
	}
	
	class GestAcLis implements ActionListener{

		private char c;
		
		public GestAcLis(char c) {
			this.c=c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			if(c=='I') {
				new InformationClient();
				fen.dispose();
				fenancienne.dispose();
			}if (c=='R')
				fen.dispose();
		}
		
	}
	
}
