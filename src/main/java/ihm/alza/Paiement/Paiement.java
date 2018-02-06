package Paiement;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Paiement extends JFrame {
	
	private PannPaiement centre = new PannPaiement();
	public Paiement() throws IOException{
JFrame fen = new JFrame();
		fen.setSize(700, 400);
		fen.setTitle("Choix du mode de paiement");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());

	    fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);	
	}
	
	public static void main(String[] args) throws IOException  {
		//TODO les images des cartes ne sont pas selectionnables..
		Paiement fen = new Paiement();
		
				
	}
}
