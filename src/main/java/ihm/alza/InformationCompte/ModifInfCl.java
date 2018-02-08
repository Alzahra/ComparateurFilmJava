package ihm.alza.InformationCompte;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ModifInfCl extends JFrame{

	private PannModCl centre;
	private InformationClient fen;
	public ModifInfCl(InformationClient f) {
		fen=f;
		centre = new PannModCl(this,fen);
		this.setSize(1000, 460);
		this.setTitle("Information de compte");
		this.setLocationRelativeTo(null);	
		

		this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
//	public static void main(String[] args) {
//		InformationAdmin fen = new InformationAdmin();
//	}
}
