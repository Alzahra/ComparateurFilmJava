package ihm.alza.InscriConnex;

import java.awt.FlowLayout;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Inscription extends JFrame{

	private PannInsc centre;
	public Inscription() {
		centre = new PannInsc(this);
		this.setSize(400, 300);
		this.setTitle("Formulaire d'inscription");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());
	    this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		Inscription fen = new Inscription();
//		
//	}
}
