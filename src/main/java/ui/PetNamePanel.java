package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class PetNamePanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(406, 33);
    private JLabel petNameLabel;

    public void createNamePanel(String petName){
        createNameLabel(petName);
        setLayout(new BorderLayout());
        add(petNameLabel, BorderLayout.CENTER);
    }

    private void createNameLabel(String petName){
        petNameLabel = new JLabel(petName);
        petNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        petNameLabel.setForeground(UIFormat.GREEN_TEXT);
        petNameLabel.setFont(UIFormat.PET_NAME_FONT);
    }

    private void format(){
        setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        setBorder(new SoftBevelBorder(BevelBorder.RAISED, getBackground().brighter(), getBackground().brighter()));
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }
}
