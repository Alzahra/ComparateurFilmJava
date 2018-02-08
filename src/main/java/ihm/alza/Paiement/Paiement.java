package ihm.alza.Paiement;

import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Paiement extends JFrame {
	
	private PannPaiement centre;
	public Paiement() throws IOException{
		centre = new PannPaiement(this);
		this.setSize(700, 400);
		this.setTitle("Choix du mode de paiement");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
//	public static void main(String[] args) throws IOException  {
//		//TODO les images des cartes ne sont pas selectionnables..
//		Paiement fen = new Paiement();
//	}
}
