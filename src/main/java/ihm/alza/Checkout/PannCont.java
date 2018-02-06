package Checkout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PannCont extends JPanel{

	public PannCont() {

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
			// TODO Auto-generated method stub
//			if(nombouton == 'P')
//			
//			if(nombouton == 'C')
//			
		}
		
	}
}
