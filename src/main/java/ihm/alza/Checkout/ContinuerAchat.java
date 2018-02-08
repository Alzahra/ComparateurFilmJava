package ihm.alza.Checkout;

import java.awt.FlowLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ContinuerAchat extends JFrame{

	private PannCont panel;
	
	public ContinuerAchat() {
	
		panel = new PannCont(this);
		panel.setLayout(new FlowLayout());
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 100);
		this.setTitle("Continuer achat ou payer");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	
//	public static void main(String[] args) {	
//		ContinuerAchat fenetre = new ContinuerAchat();
//	}
}
