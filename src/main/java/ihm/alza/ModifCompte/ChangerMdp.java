package ihm.alza.ModifCompte;

import ihm.alza.InformationCompte.InformationAdmin;
import ihm.alza.InformationCompte.InformationClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChangerMdp extends JDialog {
	
	private PannMdp centre;
	private char role;
	public ChangerMdp(Frame parent, char r) {
		super(parent, "Modification mdp", true);
		role = r;
		centre = new PannMdp();
		this.setSize(500, 250);
		this.setTitle("Modification du mot de passe");
		this.setLocationRelativeTo(parent);
		this.setLayout(new FlowLayout());
		 
		this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

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

		class MdpAcLis implements ActionListener {

			private char c;
			public MdpAcLis(char c) {
				this.c = c;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c=='V') {
					// TODO : changer info
					dispose();
				}if (c=='A') {
					dispose();
				}

			}
		}
	}

}
