package ihm.alza.InformationCompte;


import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ModifInfAd extends JFrame{

	private PannModAd centre;
	private InformationAdmin fen;
	public ModifInfAd(InformationAdmin f) {
		fen = f;
		centre = new PannModAd(this,fen);
		this.setSize(750, 460);
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
