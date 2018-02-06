package InscriConnex;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inscription extends JFrame{

	private PannInsc centre = new PannInsc();
	public Inscription() {
		JFrame fen = new JFrame();
		fen.setSize(400, 300);
		fen.setTitle("Formulaire d'inscription");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());
	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);
	}
	public static void main(String[] args) {
		Inscription fen = new Inscription();
		
	}
}
