package ui;

import controllers.AdoptPetButtonController;
import controllers.BuyHeartController;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBuilder {

    private static final Dimension STANDARD_BUTTONS_SIZE = new Dimension(80, 33);
    private static final Dimension COMPLETED_TOGGLE_SIZE = new Dimension(120, 33);

    public Button buildHealButton(Color background, Color textColor, Border border, String label){
        Button b = new Button(background, textColor, border, label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new BuyHeartController());
        return b;
    }

    public Button buildRouletteButton(Color background, Color textColor, Border border, String label){
        Button b = new Button(background, textColor, border, label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        //b.addActionListener();
        return b;
    }

    public Button buildNewTaskButton(Color background, Color textColor, Border border, String label){
        Button b = new Button(background, textColor, border, label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        //b.addActionListener();
        return b;
    }

    public Button buildAdoptButton(Color background, Color textColor, Border border, String label){
        Button b = new Button(background, textColor, border, label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdoptPetButtonController controller = new AdoptPetButtonController();
                controller.getPetShopDisplay();
                b.getParent().remove(b);

            }
        });
        return b;
    }

    public ToggleButton buildEditToggleButton(Color background, Color textColor, Border border, String label) {
        ToggleButton b = new ToggleButton(background, textColor, border, label, STANDARD_BUTTONS_SIZE, UIFormat.BUTTON_FONT);
        //b.addActionListener();
        return b;
    }

    public ToggleButton buildSeeDoneToggleButton(Color background, Color textColor, Border border, String label) {
        ToggleButton b = new ToggleButton(background, textColor, border, label, COMPLETED_TOGGLE_SIZE, UIFormat.BUTTON_FONT);
        //b.addActionListener();
        return b;
    }
}
