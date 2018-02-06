package ModifCompte;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ChangerMdp extends JFrame{
	
	private PannMdp centre = new PannMdp();
	public ChangerMdp() {
		JFrame fen = new JFrame();
		fen.setSize(500, 250);
		fen.setTitle("Modification du mot de passe");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());
		 
		fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}
	public static void main(String[] args) {
		
		ChangerMdp fen = new ChangerMdp();
		
	}
}
