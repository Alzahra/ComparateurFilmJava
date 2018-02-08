package ihm.alza.Checkout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PannCont extends JPanel{

	private ContinuerAchat fermer;
	
	public PannCont(ContinuerAchat f) {

		fermer = f;
		JButton bouton = new JButton("Payez");
		this.add(bouton);
		bouton.addActionListener(new ContActionListener('P'));

		JButton bouton2 = new JButton("Continuer");
		this.add(bouton2);
		bouton2.addActionListener(new ContActionListener('C'));

	}
	
	class ContActionListener implements ActionListener{

		private char nombouton;
		public ContActionListener(char nom) {
			nombouton = nom;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(nombouton == 'P')
				//Ouvrir la fenetre dans -> /Checkout/DetailPanier.java
				new DetailPanier();	
			if(nombouton == 'C')
				fermer.dispose();
		}
		
	}
}
