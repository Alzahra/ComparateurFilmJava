package ihm.alza.InformationCompte;

import ihm.alza.ModifCompte.ChangerMdp;
import ihm.alza.ModifCompte.SuppressionCompte;
import ihm.alza.Paiement.Rechargement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
public class InformationClient extends JDialog {

	private PannInfCl centre ;
	public InformationClient(Frame parent) {
		super(parent, "Informations", true);
		centre = new PannInfCl();
		this.setSize(1000, 460);
		this.setTitle("Information de compte");
		this.setLocationRelativeTo(parent);
		this.setLayout(new FlowLayout());

		this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);		
	}

	public class PannInfCl extends JPanel{

		private JTextField prenom;
		private JTextField nom ;
		private JTextField mail;

		public PannInfCl() {
			//TODO tracer case p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
			nom.setEditable(false);
			prenom = new JTextField(10);
			prenom.setEditable(false);
			mail = new JTextField(10);
			mail.setEditable(false);
			JTextField solde = new JTextField(5);
			solde.setEditable(false);

			noml.setLabelFor(nom);
			prenoml.setLabelFor(prenom);
			maill.setLabelFor(mail);
			soldel.setLabelFor(solde);


			JButton modifinf = new JButton("Modifier infos");
			JButton modifmdp = new JButton ("Modifier mot de passe");
			JButton supp = new JButton("Supprimer le compte");
			JButton recharger = new JButton("Recharger");
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
			modifinf.addActionListener(new ClientAcLis('I'));

			gbc.gridy=8;
			p.add(modifmdp, gbc);
			modifmdp.addActionListener(new ClientAcLis('M'));

			gbc.gridy=10;
			p.add(supp, gbc);
			supp.addActionListener(new ClientAcLis('S'));

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
			recharger.addActionListener(new ClientAcLis('R'));

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
			retour.addActionListener(new ClientAcLis('F')); //inutile en soit, peut etre regrouper
			this.add(p);
		}

		class ClientAcLis implements ActionListener {

			private char c;
			public ClientAcLis(char c) {
				this.c=c;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c=='I' ) {//Modif Info
					new ModifInfCl(null, InformationClient.this);
				}
				if (c=='M' )//Modif Mdp
					new ChangerMdp('C');
				if (c=='S' )//Supprimer
					new SuppressionCompte();
				if (c=='R' ) {
					try {
						new Rechargement(null);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}if (c=='F' )//Fin/Retour
					dispose();
			}
		}
	}
}
