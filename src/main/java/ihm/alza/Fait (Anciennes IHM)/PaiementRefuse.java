package Fait;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PaiementRefuse {
	public static void main(String[] args) {
		
		JLabel label = new JLabel("<html>Votre paiement a ete refuse et annule, "
				+ "vous ne serez pas debite.<br> Veuillez reessayer ou verifier "
				+ "le solde de votre compte</html>");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setForeground(Color.RED);
		Object[] options = { "Reessayer" };
		JOptionPane.showOptionDialog(null, label, "Paiement Refuse",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
	}
}
