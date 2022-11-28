package ui;

import controllers.BuyHeartController;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBuilder {

    public Button buildHealButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        Button b = new Button(background, textColor, border, label, preferedSize, font);
        b.addActionListener(new BuyHeartController());
        return b;
    }

    public Button buildRouletteButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        Button b = new Button(background, textColor, border, label, preferedSize, font);
        //b.addActionListener();
        return b;
    }

    public Button buildNewTaskButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        Button b = new Button(background, textColor, border, label, preferedSize, font);
        //b.addActionListener();
        return b;
    }

    public Button buildAdoptButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font){
        Button b = new Button(background, textColor, border, label, preferedSize, font);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PetShopUIController control = new PetShopUIController()
                // TODO: must access parent (PetDisplayPanel) and remove button from panel
            }
        });
        return b;
    }

    public ToggleButton buildEditToggleButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font) {
        ToggleButton b = new ToggleButton(background, textColor, border, label, preferedSize, font);
        //b.addActionListener();
        return b;
    }

    public ToggleButton buildSeeDoneToggleButton(Color background, Color textColor, Border border, String label, Dimension preferedSize, Font font) {
        ToggleButton b = new ToggleButton(background, textColor, border, label, preferedSize, font);
        //b.addActionListener();
        return b;
    }
}
