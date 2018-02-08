package ihm.alza.InscriConnex;

import java.awt.FlowLayout;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Connexion extends JFrame{
	
	private PannConnex centre;
	public Connexion() {
		centre = new PannConnex(this);
		this.setSize(500, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());

	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
//	public static void main(String[] args) {
//		//TODO  tracer trait
//		Connexion fen = new Connexion();
//	}
}
