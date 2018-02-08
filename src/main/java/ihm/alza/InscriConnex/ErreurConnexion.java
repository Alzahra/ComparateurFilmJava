package ihm.alza.InscriConnex;


import java.awt.FlowLayout;
import javax.swing.JFrame;


//A voir si on la garde on si on gere l'affichage du message en rouge 
//par une action d'erreur dans les listener ?
@SuppressWarnings("serial")
public class ErreurConnexion extends JFrame{

	private PannErrCo centre;
	public ErreurConnexion() {
		centre = new PannErrCo(this);
		this.setSize(700, 300);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());
		this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
//	public static void main(String[] args) {
//		//TODO tracer trait
//		ErreurConnexion fen = new ErreurConnexion();
//
//	}
}
