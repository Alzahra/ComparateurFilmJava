package ihm.alza.InscriConnex;

import bdd.TableUtilisateurs;
import bdd.Utilisateur;
import core.UserInfo;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Connexion extends JDialog {
	
	private PannConnex centre;
	private boolean successfull = false;
	public Connexion(Frame parent) {
		super(parent, "Authtentification", true);
		centre = new PannConnex();
		this.setSize(500, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
	}

	public boolean isSuccessfull() {
		return successfull;
	}

	private class PannConnex extends JPanel{

		public PannConnex() {
			this.setLayout(new GridBagLayout());

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
			valider.addActionListener(e -> {
				Utilisateur user = TableUtilisateurs.getInstance().getUser(pseudo.getText());
				if (user != null) {
					if (TableUtilisateurs.getInstance().getPwd(user).equals(String.valueOf(mdp.getPassword()))) {
						UserInfo.getInstance().setInfos(user);
						successfull = true;
						dispose();
					}
					else JOptionPane.showMessageDialog(Connexion.this, "Erreur de connexion",
							"Authentification", JOptionPane.ERROR_MESSAGE);
				}
			});

			gbc.gridx = 2;
			this.add(annuler,gbc);
			annuler.addActionListener(e -> dispose());

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
			inscription.addActionListener(e -> new Inscription(null));
		}

	}
}
