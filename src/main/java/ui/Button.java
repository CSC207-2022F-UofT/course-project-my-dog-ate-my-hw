package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Button extends JButton {

    public Button(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        setText(label);
        setBackground(background);
        setBorder(border);
        setForeground(textColor);
        setFont(font);
        setPreferredSize(preferedSize);
        setMinimumSize(preferedSize);
    }

}
