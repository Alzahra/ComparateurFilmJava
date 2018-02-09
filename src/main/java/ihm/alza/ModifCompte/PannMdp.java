package ihm.alza.ModifCompte;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import ihm.alza.InformationCompte.InformationAdmin;
import ihm.alza.InformationCompte.InformationClient;

@SuppressWarnings("serial")
public class PannMdp extends JPanel{

	private ChangerMdp fen;
	private char role;
	
	public PannMdp(ChangerMdp f,char r) {
		this.setLayout(new GridBagLayout());
		fen = f;
		role = r;
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel mdpactuel = new JLabel("Ancien Mot de Passe: ", JLabel.CENTER);
	    JLabel nvmdpl = new JLabel("Nouveau mot de passe: ", JLabel.CENTER);
	    JLabel confmdpl = new JLabel("Confirmer nouveau mot de passe: ", JLabel.CENTER);

	    JPasswordField mdpactu = new JPasswordField(10);
	    JPasswordField nvmdp = new JPasswordField(10); 
	    JPasswordField confmdp = new JPasswordField(10);

	    JButton valider =new JButton("Valider");
	    JButton annuler = new JButton("Annuler");
	    
	    mdpactuel.setLabelFor(mdpactu);
	    nvmdpl.setLabelFor(nvmdp);
	    confmdpl.setLabelFor(confmdp);

	    gbc.insets = new Insets(10, 5, 7, 1);
	    this.add(mdpactuel, gbc);
	    gbc.gridy++;
		this.add(nvmdpl, gbc);
		gbc.gridy++;
		this.add(confmdpl, gbc);
		gbc.gridy++;
		
		gbc.gridx++;
		gbc.gridy = 0;
		this.add(mdpactu, gbc);
		gbc.gridy++;
		this.add(nvmdp, gbc);
		gbc.gridy++;
		this.add(confmdp, gbc);
		gbc.gridy++;
		
		gbc.gridy++;
		this.add(valider,gbc);
		valider.addActionListener(new MdpAcLis('V'));
		gbc.gridx++;
		this.add(annuler,gbc);
		annuler.addActionListener(new MdpAcLis('A'));
		gbc.gridy++;

	}
	
	class MdpAcLis implements ActionListener{
		
		private char c;
		public MdpAcLis(char c) {
			this.c = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(c=='V') {
				if(role == 'C') new InformationClient(null);
				if (role == 'A') new InformationAdmin();
				fen.dispose();
			}if (c=='A') {
				if(role == 'C') new InformationClient(null);
				if (role == 'A') new InformationAdmin();
				fen.dispose();
			}
			
		}
	}
}
