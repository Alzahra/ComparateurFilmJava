package ihm.alza.PannAdmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



@SuppressWarnings("serial")
public class PannGestionAd extends JPanel{

	private GestionAdmin fen;

	//Faudrait il faire des JTable pour le resultat ? 
	//Ou peut on mettre le resultat dans  ce layout ?
	public PannGestionAd(GestionAdmin f) {

		fen = f;
		JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Films", null ,new PannFilm());
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Utilisateurs", null ,new PannUtil());
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
        add(tabbedPane);
	}
	
	
	class PannFilm extends JPanel{
		
		public PannFilm() {
			this.setPreferredSize(new Dimension(900,200));
			this.setLayout(new GridBagLayout());
				
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			
			JLabel image = new JLabel ("Image");
			JLabel titre = new JLabel("Titre ");
			JLabel duree = new JLabel("Durée ");
			JLabel note = new JLabel("Note ");
		    JLabel date = new JLabel("Date de sortie ");
		    JLabel genre = new JLabel("Genre ");
		    JLabel syno = new JLabel("Synopsys ");
		    JLabel acteur = new JLabel("Acteurs ");
		    
		    JButton modif = new JButton("Modifier ");
		    JButton supp = new JButton("Supprimer ");
		    
		    //gbc.anchor = GridBagConstraints.NORTHWEST;
		    //gbc.anchor = GridBagConstraints.LINE_START;
		    
		    gbc.insets = new Insets(2,2, 2,10);

		    gbc.gridx = 0;
		    this.add(image, gbc);
		    gbc.gridx++;
		    this.add(titre, gbc);
		    gbc.gridx++;
			this.add(duree, gbc);
			gbc.gridx++;
			this.add(note, gbc);
		    gbc.gridx++;
			this.add(date, gbc);
			gbc.gridx++;
			this.add(genre, gbc);
			gbc.gridx++;
			this.add(syno, gbc);
			gbc.gridx++;
			this.add(acteur, gbc);
		    
			gbc.gridx++;
			this.add(modif, gbc);
			modif.addActionListener(new ModifAcLis('M'));
			
		    gbc.gridx++;
			this.add(supp, gbc);
			supp.addActionListener(new ModifAcLis('S'));
			gbc.gridx++;
		
				
		}
	}
	
	class PannUtil extends JPanel{
		
		public PannUtil() {
			this.setPreferredSize(new Dimension(700,200)); //pas utile
			this.setLayout(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			
			JLabel nom = new JLabel ("Nom");
			JLabel prenom = new JLabel("Prenom ");
			JLabel pseudo = new JLabel("Pseudo ");
			JLabel email = new JLabel("E-mail ");
		    JLabel film= new JLabel("Films loues ");
		    JLabel solde = new JLabel("Solde ");
		    JLabel role = new JLabel("Role ");
		  
		    JButton modif = new JButton("Modifier ");
		    JButton supp = new JButton("Supprimer ");
		    
		    gbc.insets = new Insets(0,10, 0,10);
		    
		    gbc.gridx = 0;
		    this.add(nom, gbc);
		    gbc.gridx++;
		    this.add(prenom, gbc);
		    gbc.gridx++;
			this.add(pseudo, gbc);
			gbc.gridx++;
			this.add(email, gbc);
		    gbc.gridx++;
			this.add(film, gbc);
			gbc.gridx++;
			this.add(solde, gbc);
			gbc.gridx++;
			this.add(role, gbc);
			
			gbc.gridx++;
			this.add(modif, gbc);
			modif.addActionListener(new ModifAcLis('M'));
			
		    gbc.gridx++;
			this.add(supp, gbc);
			supp.addActionListener(new ModifAcLis('S'));
			gbc.gridx++;
		
		}
	}
	
	class ModifAcLis implements ActionListener {

		private char c;
		
		public ModifAcLis(char c) {
			this.c = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			if(c=='M')
//				//modifier en BD + raffraichir requete
//			if(c=='S')
//				//Supprimer en BD + raffraichir requete
//			
		}
		
	}
}
