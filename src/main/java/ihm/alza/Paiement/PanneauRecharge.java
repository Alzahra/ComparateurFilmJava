package ihm.alza.Paiement;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings({ "rawtypes", "unchecked","serial" })
public class PanneauRecharge extends JPanel {

	private Rechargement fen;
	public PanneauRecharge(Rechargement f) throws IOException {
		this.setLayout(new GridBagLayout());
		fen =f;
		JRadioButton cbRB = new JRadioButton("CB");
        JRadioButton soldeRB = new JRadioButton("Solde du compte");
        ButtonGroup group = new ButtonGroup();
        group.add(cbRB);
        group.add(soldeRB);
        cbRB.setSelected(true);
        
        Image vis = ImageIO.read(new File("./src/ihm/Paiement/visa.jpeg"));
        Image mc = ImageIO.read(new File("./src/ihm/Paiement/MasterCard.jpeg"));
        JRadioButton visa = new JRadioButton(new ImageIcon(vis));
        JRadioButton masterc = new JRadioButton(new ImageIcon(mc));
        ButtonGroup group2 = new ButtonGroup();
        group2.add(visa);
        group2.add(masterc);
       // visa.setSelected(true);
        
        String annee[] = {"2018","2019","2020","2021","2021","2022"};
        String mois[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        
        JLabel montant = new JLabel("Montant:");
		JLabel numcarte = new JLabel("Numero de carte de credit: ", JLabel.CENTER);
		JLabel typec = new JLabel("Type de carte de credit:");
		JLabel dateexp = new JLabel("Date d'expiration: ", JLabel.CENTER);
		JComboBox anneeCB = new JComboBox(annee);
		JComboBox moisCB = new JComboBox(mois);
	    JLabel codesecu = new JLabel("Code de securite: ", JLabel.CENTER);
	    
	    JTextField numc = new JTextField(20);
	    JTextField codesec = new JTextField(3);
	    JTextField montanttf = new JTextField(6);
	  
	    JButton finaliser = new JButton("Finaliser");
	    JButton annuler = new JButton("Annuler");
	    
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
    
	    numcarte.setLabelFor(numc);
	    codesecu.setLabelFor(codesec);

	    gbc.insets = new Insets(5, 5, 5, 1);
	   
	    this.add(montant,gbc);
	    gbc.gridx = 1;
	    this.add(montanttf,gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy=1;
	    this.add(numcarte, gbc);
	    gbc.gridx = 1 ;
	    this.add(numc,gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy=2;
	    this.add(typec,gbc);
	    gbc.gridx = 1 ;
		this.add(visa,gbc);
		gbc.gridx = 2;
		this.add(masterc,gbc);
	    
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(dateexp, gbc);
		gbc.gridx = 1 ;
		this.add(moisCB,gbc);
		gbc.gridx = 2;
		this.add(anneeCB,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(codesecu, gbc);
		gbc.gridx = 1 ;
		this.add(codesec,gbc);

		gbc.gridx=2;
		gbc.gridy=9;
		this.add(finaliser,gbc);
		finaliser.addActionListener(new RechargeAcLis('F'));
		gbc.gridx++;
		this.add(annuler,gbc);
		annuler.addActionListener(new RechargeAcLis('A'));
		gbc.gridy++;	
	}
	
	class RechargeAcLis implements ActionListener{
		
		private char c;
		public RechargeAcLis(char c) {
			this.c=c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (c=='F') {
				//ajoutersolde(montanttf);
				fen.dispose();
			}if (c=='A') {
				//new FenetrePrincipaleConn();
				fen.dispose();
			}
		}
	}
}
