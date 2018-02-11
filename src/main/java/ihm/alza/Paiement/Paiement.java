package ihm.alza.Paiement;

import bdd.Client;
import bdd.Film;
import bdd.TableUtilisateurs;
import core.UserInfo;
import ihm.alza.Checkout.DetailPanier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class Paiement extends JDialog {
	
	private PannPaiement centre;
	public Paiement(Frame parent) throws IOException{
		super(parent, "Paiement", true);
		centre = new PannPaiement();
		this.setSize(700, 400);
		this.setTitle("Choix du mode de paiement");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
	}

	public class PannPaiement extends JPanel {

		public PannPaiement() throws IOException {
			this.setLayout(new GridBagLayout());
			JRadioButton cbRB = new JRadioButton("CB");
			JRadioButton soldeRB = new JRadioButton("Solde du compte");
			ButtonGroup group = new ButtonGroup();
			group.add(cbRB);
			group.add(soldeRB);
			cbRB.setSelected(true);

			ClassLoader classLoader = getClass().getClassLoader();
			Image vis = ImageIO.read(new File(classLoader.getResource("images/visa.jpeg").getFile()));
			Image mc = ImageIO.read(new File(classLoader.getResource("images/MasterCard.jpeg").getFile()));
			JRadioButton visa = new JRadioButton(new ImageIcon(vis));
			JRadioButton masterc = new JRadioButton(new ImageIcon(mc));
			ButtonGroup group2 = new ButtonGroup();
			group2.add(visa);
			group2.add(masterc);
			// visa.setSelected(true);

			String annee[] = {"2018","2019","2020","2021","2021","2022"};
			String mois[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};

			JLabel numcarte = new JLabel("Numero de carte de credit: ", JLabel.CENTER);
			JLabel typec = new JLabel("Type de carte de credit:");
			JLabel dateexp = new JLabel("Date d'expiration: ", JLabel.CENTER);

			JComboBox anneeCB = new JComboBox(annee);
			JComboBox moisCB = new JComboBox(mois);
			JLabel codesecu = new JLabel("Code de securite: ", JLabel.CENTER);

			JTextField numc = new JTextField(20);
			JTextField codesec = new JTextField(3);

			JButton finaliser = new JButton("Finaliser l'achat");
			JButton annuler = new JButton("Annuler");

			JLabel solde = new JLabel("Solde Disponible: ", JLabel.CENTER);
			JTextField soldetf = new JTextField("0",6);
			soldetf.setEditable(false);
			//pour le moment en JText mais c'est une donnee a recup

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;

			numcarte.setLabelFor(numc);
			codesecu.setLabelFor(codesec);

			gbc.insets = new Insets(5, 5, 5, 1);

			this.add(cbRB,gbc);

			gbc.gridx = 1;
			gbc.gridy=1;
			this.add(numcarte, gbc);
			gbc.gridx = 2 ;
			this.add(numc,gbc);

			gbc.gridx = 1;
			gbc.gridy=2;
			this.add(typec,gbc);
			gbc.gridx = 2 ;
			this.add(visa,gbc);
			gbc.gridx = 3;
			this.add(masterc,gbc);

			gbc.gridx = 1;
			gbc.gridy = 3;
			this.add(dateexp, gbc);
			gbc.gridx = 2 ;
			this.add(moisCB,gbc);
			gbc.gridx = 3;
			this.add(anneeCB,gbc);

			gbc.gridx = 1;
			gbc.gridy = 4;
			this.add(codesecu, gbc);
			gbc.gridx = 2 ;
			this.add(codesec,gbc);

			gbc.gridx = 0;
			gbc.gridy = 6;
			this.add(soldeRB,gbc);

			gbc.gridx = 1;
			gbc.gridy = 7;
			this.add(solde, gbc);
			gbc.gridx = 2;
			this.add(soldetf,gbc);


			gbc.gridx=2;
			gbc.gridy=9;
			this.add(finaliser,gbc);
			finaliser.addActionListener(new PaiementAcLis('F'));
			gbc.gridx++;
			this.add(annuler,gbc);
			annuler.addActionListener(new PaiementAcLis('A'));
			gbc.gridy++;

		}

		class PaiementAcLis implements ActionListener {

			private char c;
			public PaiementAcLis(char c) {
				this.c=c;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c=='F') {
//				if(verifmontant()) new InformationClient(); //affiche film loue
//				else new PaiementRefuse();
					Client c = (Client)UserInfo.getInstance().getUser();
					for (Film f : UserInfo.getInstance().getPanier())
						c.addFilm(f);
					TableUtilisateurs.getInstance().modifier(c, "nope");
					dispose();
				}if (c=='A') {
					dispose();
				}
			}
		}


	}
}
