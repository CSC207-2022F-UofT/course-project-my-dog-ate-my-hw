package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class PetNamePanel extends JPanel {

    private JLabel petNameLabel;

    public void createNamePanel(String petName){
        this.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(245, 202, 195), new Color(245, 202, 195)));
        this.setLayout(new BorderLayout());
        petNameLabel = new JLabel(petName);
        petNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        petNameLabel.setForeground(UIFormat.GREEN_TEXT);
        petNameLabel.setFont(UIFormat.PET_NAME_FONT);
        this.add(petNameLabel, BorderLayout.CENTER);
    }
}
