package ihm.alza.ModifCompte;

import java.awt.FlowLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ChangerMdp extends JFrame{
	
	private PannMdp centre;
	private char role;
	public ChangerMdp(char r) {
		role = r;
		centre = new PannMdp(this,role);
		this.setSize(500, 250);
		this.setTitle("Modification du mot de passe");
		this.setLocationRelativeTo(null);	
		this.setLayout(new FlowLayout());
		 
		this.setContentPane(centre);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		ChangerMdp fen = new ChangerMdp('A');
//		
//	}
}
