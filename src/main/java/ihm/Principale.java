import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Principale {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Ex 4- Un formulaire avec marge.");

        /* 1- Initialisation du container. */
        mainFrame.setLayout(new GridBagLayout());

        /* 2- Création et initialisation d'une série de composants. */
        JLabel photoLabel = new JLabel("photo");
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photoLabel.setPreferredSize(new Dimension(75, 100));

        JLabel nomLabel = new JLabel("Nom :");
        JLabel prenomLabel = new JLabel("Prénom :");
        JLabel fonctionLabel = new JLabel("Fonction :");
        JLabel sexeLabel = new JLabel("Sexe :");
        JLabel matriculeLabel = new JLabel("Matricule : 19650731-145/24");

        JComboBox fonctionComboBox = new JComboBox(new String[]{"Ecrivain"});

        JTextField nomTextField = new JTextField("Rowling");
        JTextField prenomTextField = new JTextField("Joanne");

        JRadioButton hommeRadioButton = new JRadioButton("Homme");
        JRadioButton femmeRadioButton = new JRadioButton("Femme");
        femmeRadioButton.setSelected(true);

        JSeparator separator = new JSeparator();

        JButton moreFunctionsButton = new JButton("...");
        moreFunctionsButton.setMargin(new Insets(1, 3, 1, 3));
        JButton imprimerButton = new JButton("Imprimer...");

        /*3- Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
        GridBagConstraints gbc = new GridBagConstraints();

        /* a- ajout du label contenant le matricule. */
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // gbc.gridheight = 1;
        gbc.insets = new Insets(10, 5, 0, 0);
        /* Le point d'ancrage ici n'a pas une grande importance. Nous allons quand même essayer d'aligner tout les
         * composants qui le peuvent sur leur ligne de base. */
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        mainFrame.add(matriculeLabel, gbc);
        /* ************************************************************************************** */

        /* b- ajout de la zone pour la photo. nous avons utilisé une étiquette pour cela. */
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 4;
        /* Ici, nous ne voulons surement pas que le composant s'aligne sur la ligne de base. Il n'est pas censé
        * représenté un élémént de texte mais bien une image. Nous allons donc utiliser la constance LINE_START. */
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 0, 0);
        mainFrame.add(photoLabel, gbc);
        /* ************************************************************************************** */

        /* c- étiquette contenant le nom. */
        gbc.gridx = gbc.gridy = gbc.gridwidth = gbc.gridheight = 1;
        /* L'étiquette avec le nom sera alignée sur la ligne de base avec le champ de saisie pour le nom. */
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 5, 0, 0);
        mainFrame.add(nomLabel, gbc);
        /* ************************************************************************************** */

        /* d- le champs de saisie pour le nom. */
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // dernier composant de la ligne.
        gbc.fill = GridBagConstraints.HORIZONTAL; // étalons le sur l'espace disponible.
        gbc.insets = new Insets(3, 5, 0, 5); // laissons tout de même une marge à droite.
        gbc.anchor = GridBagConstraints.BASELINE; // alignons le sur la même ligne de base que son étiquette.
        mainFrame.add(nomTextField, gbc);
        /* ************************************************************************************** */

        /* e- l'étiquette pour le prénom. */
        gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 5, 0, 0);
        mainFrame.add(prenomLabel, gbc);
        /* ************************************************************************************** */

        /* f- le champ de saisie pour le prénom */
        gbc.gridx = gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(3, 5, 0, 5);
        mainFrame.add(prenomTextField, gbc);
        /* ************************************************************************************** */

        /* g- l'étiquette pour la fonction. */
        gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 5, 0, 0);
        mainFrame.add(fonctionLabel, gbc);

        /* h- la liste déroulante pour les fonctions. */
        gbc.gridx = 2;
        gbc.gridwidth = GridBagConstraints.RELATIVE; /* avant dernier composant de sa ligne */
        gbc.weightx = 1.;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(3, 5, 0, 0);
        mainFrame.add(fonctionComboBox, gbc);
        /* ************************************************************************************** */

        /* i- le bouton permettant (immaginaire) d'ajouter une fonction qui est inexistante dans la liste déroulante. */
        gbc.gridx = 4;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 0.; // supprimons le poids.
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 3, 0, 5);
        mainFrame.add(moreFunctionsButton, gbc);
        /* ************************************************************************************** */

        /* j- L'étiquette pour le sexe. */
        gbc.gridy = 4;
        gbc.gridx = gbc.gridwidth = gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(5, 5, 0, 0);
        mainFrame.add(sexeLabel, gbc);
        /* ************************************************************************************** */

        /* k- le bouton radio pour l'option Homme. */
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(0, 2, 0, 0);
        mainFrame.add(hommeRadioButton, gbc);
        /* ************************************************************************************** */

        /* l- le bouton radio pour l'option Femme. */
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        mainFrame.add(femmeRadioButton, gbc);
        /* ************************************************************************************** */

        /* M- Un séparateur. */
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 5, 0, 5);
        mainFrame.add(separator, gbc);
        /* ************************************************************************************** */

        /* N- Le bouton permettant d'imprimer. */
        gbc.gridy = 6;
        gbc.gridheight = GridBagConstraints.REMAINDER; /* dernier composant de la colonne */
        gbc.weighty = 1.;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbc.insets = new Insets(3, 0, 5, 5);
        mainFrame.add(imprimerButton, gbc);
        /* ************************************************************************************** */

        mainFrame.setMinimumSize(new Dimension(320, 205));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
