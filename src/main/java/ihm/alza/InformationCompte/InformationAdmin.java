package ihm.alza.InformationCompte;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformationAdmin extends JFrame{

	private PannInfAd centre;
	public InformationAdmin() {
		centre = new PannInfAd(this);
		this.setSize(750, 460);
		this.setTitle("Information de compte");
		this.setLocationRelativeTo(null);	
		this.setLayout(new GridBagLayout());

		this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
//	public static void main(String[] args) {
//		InformationAdmin fen = new InformationAdmin();
//	}
}
