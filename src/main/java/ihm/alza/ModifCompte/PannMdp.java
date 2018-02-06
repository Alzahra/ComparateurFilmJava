package ModifCompte;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PannMdp extends JPanel{

	public PannMdp() {
		this.setLayout(new GridBagLayout());
		
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
		this.add(new JButton("Valider"),gbc);
		gbc.gridx++;
		this.add(new JButton("Annuler"),gbc);
		gbc.gridy++;

	   
		
	}
}
