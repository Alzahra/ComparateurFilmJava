package ihm.Fait;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContinuerAchat {

	
	public static void main(String[] args) {
		
		JFrame fen = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
 
		JButton bouton = new JButton("Payez");
		panel.add(bouton);
 
		JButton bouton2 = new JButton("Continuer");
		panel.add(bouton2);
		
		fen.setContentPane(panel);
		fen.setVisible(true);
		fen.setSize(400, 100);
		fen.setTitle("Continuer achat ou payer");
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
