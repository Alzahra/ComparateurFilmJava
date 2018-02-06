package InscriConnex;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Connexion extends JFrame{
	
	private PannConnex centre = new PannConnex();
	public Connexion() {
		JFrame fen = new JFrame();
		fen.setSize(500, 300);
		fen.setTitle("Login");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);	
	}
	public static void main(String[] args) {
		//TODO  tracer trait
		Connexion fen = new Connexion();
	}
}
