package Checkout;

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
import javax.swing.JTextField;

public class DetailPanier extends JFrame{
	
	private PannPanier centre = new PannPanier();
	
	public DetailPanier() {
		JFrame fen = new JFrame();
		fen.setSize(900, 400);
		fen.setTitle("Login");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);		
	}
	
	public static void main(String[] args) {

		DetailPanier fen = new DetailPanier();
		
	}
}
