package ihm.alza.PannAdmin;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GestionAdmin extends JFrame{

	private PannGestionAd centre;
	
	public GestionAdmin() {
		centre = new PannGestionAd(this);
		
		this.setSize(800, 460);//taille arbitraire
		this.setTitle("Panneau Administrateur");
		this.setLocationRelativeTo(null);	
		this.setLayout(new GridBagLayout()); 
		this.setContentPane(centre);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		GestionAdmin fen = new GestionAdmin();
	}
}
