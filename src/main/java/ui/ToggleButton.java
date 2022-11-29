package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ToggleButton extends JToggleButton {

    public ToggleButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        this.setText(label);
        this.setBackground(background);
        this.setBorder(border);
        this.setForeground(textColor);
        this.setFont(font);
        this.setPreferredSize(preferedSize);
    }

}
