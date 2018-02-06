package Checkout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContinuerAchat extends JFrame{

	private PannCont panel = new PannCont();
	
	public ContinuerAchat() {
		JFrame fen = new JFrame();
		//panel.setLayout(new FlowLayout());
		fen.setContentPane(panel);
		fen.setVisible(true);
		fen.setSize(400, 100);
		fen.setTitle("Continuer achat ou payer");
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {	
		ContinuerAchat fenetre = new ContinuerAchat();
	}
}
