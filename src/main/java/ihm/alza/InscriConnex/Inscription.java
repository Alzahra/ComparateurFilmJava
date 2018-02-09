package ihm.alza.InscriConnex;

import bdd.Client;
import bdd.TableUtilisateurs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class Inscription extends JDialog {

	private PannInsc centre;
	public Inscription(Frame parent) {
		super(parent, "Inscription", true);
		centre = new PannInsc();
		this.setSize(400, 300);
		this.setTitle("Formulaire d'inscription");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());
	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public class PannInsc extends JPanel {

		private JTextField pseudo = new JTextField(10);
		private JPasswordField mdp = new JPasswordField(10);
		private JTextField nom = new JTextField(10);
		private JTextField prenom = new JTextField(10);
		private JTextField email = new JTextField(10);

		public PannInsc() {
			this.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;

			JLabel pseudol = new JLabel("Pseudo: ", JLabel.CENTER);
			JLabel mdpl = new JLabel("Mot de Passe: ", JLabel.CENTER);
			JLabel noml = new JLabel("Nom: ", JLabel.CENTER);
			JLabel prenoml = new JLabel("Prenom: ", JLabel.CENTER);
			JLabel emaill = new JLabel("Email: ", JLabel.CENTER);

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

		class InsAcLis implements ActionListener {

			private char c;
			public InsAcLis(char c) {
				this.c=c;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c=='V') {
					TableUtilisateurs.getInstance().ajouter(new Client(0,
							pseudo.getText(), nom.getText(), prenom.getText(),
							email.getText(), "user", 0, null), String.valueOf(mdp.getPassword()));
					dispose();
					//if(nonexistant)
					//new FenetrePrincipaleConn();
					//ou new Connexion();
				} else if(c=='A') {
					dispose();
				}
			}


		}


	}
}
