package ihm;

import javax.swing.*;

public class FenetrePrincipale extends JFrame {
    public FenetrePrincipale(String titre) {
        setTitle(titre);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 400);
    }

    static public void main(String[] args) {
        FenetrePrincipale fen = new FenetrePrincipale("Comparateur v0.0.1");
        fen.setVisible(true);
    }
}
