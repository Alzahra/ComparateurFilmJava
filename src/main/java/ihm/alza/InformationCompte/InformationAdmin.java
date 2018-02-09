package ihm.alza.InformationCompte;

import ihm.alza.ModifCompte.ChangerMdp;
import ihm.alza.PannAdmin.GestionAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class InformationAdmin extends JDialog {

	private PannInfAd centre;
	public InformationAdmin(Frame parent) {
		super(parent, "Informations", true);
		centre = new PannInfAd();
		this.setSize(750, 460);
		this.setTitle("Information de compte");
		this.setLocationRelativeTo(parent);
		this.setLayout(new GridBagLayout());

		this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);		
	}

	public class PannInfAd extends JPanel{

		private JTextField prenom;
		private JTextField nom ;
		private JTextField mail;


		public PannInfAd() {
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

			nom = new JTextField(10);
			nom.setEditable(false);
			prenom = new JTextField(10);
			prenom.setEditable(false);
			mail = new JTextField(10);
			mail.setEditable(false);


			noml.setLabelFor(nom);
			prenoml.setLabelFor(prenom);
			maill.setLabelFor(mail);


			JButton modifinf = new JButton("Modifier infos");
			JButton modifmdp = new JButton ("Modifier mot de passe");

			JButton bdd = new JButton("Gestion de la BDD");
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
			modifinf.addActionListener(new GestAcLis('I'));

			gbc.gridy=8;
			p.add(modifmdp, gbc);
			modifmdp.addActionListener(new GestAcLis('M'));

			this.add(p);

			gbc.gridx = gbc.gridy = 0;
			p = new JPanel();
			p.setLayout(gb);


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

			gbc.gridwidth = GridBagConstraints.REMAINDER;
			p.add(bdd, gbc);
			bdd.addActionListener(new GestAcLis('B'));

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

		class GestAcLis implements ActionListener {

			private char c;

			public GestAcLis(char c) {
				this.c=c;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c=='I' ) {//Modif Info
					//Alors ca ne marche pas donc je vais faire une autre fenetre ^^'
					new ModifInfAd(null, InformationAdmin.this);

//				modifinf = new JButton("Valider Modifications");
//				nom.setEditable(true);
//				prenom.setEditable(true);
//				mail.setEditable(true);
//				modifinf.addActionListener(new GestAcLis('V'));
				}
//			if(c=='V') {
//				modifinf = new JButton("Modifications Informations");
//				nom.setEditable(false);
//				prenom.setEditable(false);
//				mail.setEditable(false);
//				modifinf.addActionListener(new GestAcLis('I'));
//			}

				if (c=='M' )//Modif Mdp
					new ChangerMdp(null,'A');
				if (c=='B')
					new GestionAdmin();
				if (c=='R')
					dispose();
			}

		}

	}

}
