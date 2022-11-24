package ui;

import controllers.BuyHeartController;

import javax.swing.border.Border;
import java.awt.*;

public class HealButton extends CuteButton{

    public HealButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        super(background, textColor, border, label, preferedSize, font);
        this.addActionListener(new BuyHeartController());
    }
}
