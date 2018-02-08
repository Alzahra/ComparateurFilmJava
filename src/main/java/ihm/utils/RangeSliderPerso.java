package ihm.utils;

import javax.swing.*;
import java.awt.*;

public class RangeSliderPerso extends JPanel {
    private RangeSlider slider;
    private JLabel vGauche = new JLabel();
    private JLabel vDroite = new JLabel();
    public RangeSliderPerso(int vmin, int vmax, String label, int vminSet, int vmaxSet) {
        setLayout(new FlowLayout());
        add(new JLabel(label));
        slider = new RangeSlider();

        slider.addChangeListener(e -> {
            RangeSlider slider = (RangeSlider) e.getSource();
            vGauche.setText(String.valueOf(slider.getValue()));
            vDroite.setText(String.valueOf(slider.getUpperValue()));
        });

        add(vGauche);
        add(slider);
        add(vDroite);

        slider.setMinimum(vmin);
        slider.setMaximum(vmax);
        slider.setValue(vminSet);
        slider.setUpperValue(vmaxSet);
    }

    public int getLowerValue() {
        return  slider.getValue();
    }
    public int getUpperValue() {
        return slider.getUpperValue();
    }
}
