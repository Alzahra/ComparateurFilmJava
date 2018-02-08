package ihm.alza.InformationCompte;

import java.awt.FlowLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InformationClient extends JFrame{

	private PannInfCl centre ;
	public InformationClient() {
		centre = new PannInfCl(this);
		this.setSize(1000, 460);
		this.setTitle("Information de compte");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

		this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
//	public static void main(String[] args) {
//		InformationClient fen = new InformationClient();
//	}
}
