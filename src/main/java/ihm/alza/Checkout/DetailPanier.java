package ihm.alza.Checkout;

import java.awt.FlowLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DetailPanier extends JFrame{
	
	private PannPanier centre;

	public DetailPanier() {
		centre = new PannPanier(this);

		this.setSize(900, 400);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
//	public static void main(String[] args) {
//
//		DetailPanier fen = new DetailPanier();
//		
//	}
}
