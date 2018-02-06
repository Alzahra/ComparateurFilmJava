package ModifCompte;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SuppressionCompte {

	public static void main(String[] args) {
		//TODO Mettre le contenu du Mdp en cache
		
		JLabel label = new JLabel("Attention cette action est irreversible. "
				+ "Pour supprimer votre compte, veuillez entrer votre mot de passe et valider");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setForeground(Color.RED);
		JOptionPane.showInputDialog(
	    	new JFrame(), 
	        label, 
	        "Valider Suppression de Compte", 
	        JOptionPane.CANCEL_OPTION
	    );
	}
}
