package InscriConnex;

import java.awt.Color;
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

//A voir si on la garde on si on gere l'affichage du message en rouge 
//par une action d'erreur dans les listener ?
public class ErreurConnexion extends JFrame{

	private PannErrCo centre = new PannErrCo();
	public ErreurConnexion() {
		JFrame fen = new JFrame();
		fen.setSize(700, 300);
		fen.setTitle("Login");
		fen.setLocationRelativeTo(null);	
		fen.setLayout(new FlowLayout());
		fen.setContentPane(centre);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setVisible(true);		
	}
	public static void main(String[] args) {
		//TODO tracer trait
		ErreurConnexion fen = new ErreurConnexion();

	}
}
