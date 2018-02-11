package ihm.alza.Checkout;

import bdd.Film;
import core.UserInfo;
import ihm.alza.Paiement.Paiement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class DetailPanier extends JDialog {
	
	private PannPanier centre;

	public DetailPanier(Frame parent) {
		super(parent, "Détail du panier", true);
		centre = new PannPanier();

		setSize(900, 400);
		setLocationRelativeTo(parent);

	    setContentPane(centre);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public class PannPanier extends JPanel {
		private JScrollPane listePanier = new JScrollPane();
		private JPanel contenuListe = new JPanel();

		public PannPanier() {
			listePanier.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			listePanier.setViewportView(contenuListe);
			contenuListe.setLayout(new BoxLayout(contenuListe, BoxLayout.PAGE_AXIS));


			JLabel mess = new JLabel("Detail du panier ",JLabel.CENTER);
			mess.setFont(new Font("Serif", Font.BOLD, 30));
			JLabel titre = new JLabel("Titre ", JLabel.CENTER);
			JLabel nbjour = new JLabel("Nombre de jours de location ", JLabel.CENTER);
			JLabel debut = new JLabel("Date de debut de location ", JLabel.CENTER);
			JLabel fin = new JLabel("Date de fin de location ", JLabel.CENTER);
			JLabel prix = new JLabel("Prix ", JLabel.CENTER);
			JLabel supp = new JLabel("Supprimer ", JLabel.CENTER);

			JButton valider = new JButton("Valider");
			JButton annuler = new JButton("Annuler");

			valider.addActionListener(new PannAcLis('V'));
			annuler.addActionListener(new PannAcLis('A'));

			JPanel conteneurNorth = new JPanel();
			conteneurNorth.setLayout(new BoxLayout(conteneurNorth, BoxLayout.PAGE_AXIS));
			conteneurNorth.add(mess);
			JPanel libele = new JPanel();
			libele.setLayout(new FlowLayout());
			libele.add(titre);
			libele.add(nbjour);
			libele.add(debut);
			libele.add(fin);
			libele.add(prix);
			libele.add(supp);
			conteneurNorth.add(libele);

			add(conteneurNorth, BorderLayout.NORTH);
			add(listePanier, BorderLayout.CENTER);
			afficheListe();

			JPanel buttons = new JPanel();
			buttons.add(valider);
			buttons.add(annuler);
			add(buttons, BorderLayout.SOUTH);
		}

		private void afficheListe() {
			contenuListe.removeAll();
			for (Film f : UserInfo.getInstance().getPanier())
				contenuListe.add(createVueFilm(f));

			contenuListe.updateUI();
			revalidate();
			repaint();
		}

		private JPanel createVueFilm(Film f) {
			JPanel vue = new JPanel();
			vue.setLayout(new BoxLayout(vue, BoxLayout.LINE_AXIS));

			vue.add(new JLabel(f.getTitre()));
			vue.add(new JLabel("NBEJOUR"));
			vue.add(new JFormattedTextField(new java.util.Date()));
			vue.add(new JFormattedTextField(new java.util.Date()));
			vue.add(new JLabel(""+f.getPrix()));
			JButton supr = new JButton("X");
			supr.addActionListener(e -> {
				UserInfo.getInstance().enleverDuPanier(f);
				afficheListe();
			});
			vue.add(supr);

			return vue;
		}

		class PannAcLis implements ActionListener {

			private char action;
			public PannAcLis(char ac) {
				action = ac;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(action == 'V') {
					try {
						new Paiement(null);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					dispose();
				}if(action == 'A')
					dispose();
			}

		}

	}
}
