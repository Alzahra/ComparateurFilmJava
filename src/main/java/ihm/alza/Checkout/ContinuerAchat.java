package ihm.alza.Checkout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class ContinuerAchat extends JDialog {

	private PannCont panel;
	
	public ContinuerAchat(Frame parent) {
		super(parent, "Continuer achat ?", true);
		panel = new PannCont();
		panel.setLayout(new FlowLayout());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 100);
		this.setTitle("Continuer achat ou payer");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public class PannCont extends JPanel{

		public PannCont() {

			JButton bouton = new JButton("Payez");
			this.add(bouton);
			bouton.addActionListener(new ContActionListener('P'));

			JButton bouton2 = new JButton("Continuer");
			this.add(bouton2);
			bouton2.addActionListener(new ContActionListener('C'));

		}

		class ContActionListener implements ActionListener {

			private char nombouton;
			public ContActionListener(char nom) {
				nombouton = nom;
			}

			@Override
			public void actionPerformed(ActionEvent e) {

				if(nombouton == 'P')
					//Ouvrir la fenetre dans -> /Checkout/DetailPanier.java
					new DetailPanier(null);
				if(nombouton == 'C')
					dispose();
			}

		}
	}
}
