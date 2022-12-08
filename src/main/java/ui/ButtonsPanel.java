package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonsPanel extends JPanel {

    private static final Dimension fillerDimensionsSmall = new Dimension(6, 0);
    private Button newTaskButton;
    private Button rouletteButton;
    private ToggleButton seeDoneButton;

    public void createButtonsPanel(){
        format();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        initalizeButtons();
        add(newTaskButton);
        add(new Box.Filler(fillerDimensionsSmall, fillerDimensionsSmall, fillerDimensionsSmall));
        add(rouletteButton);
        add(Box.createHorizontalGlue());
        add(seeDoneButton);

    }

    private void initalizeButtons(){
        ButtonBuilder builder = new ButtonBuilder();

        newTaskButton = builder.buildNewTaskButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT, "New Task");
        rouletteButton = builder.buildRouletteButton(UIFormat.GREEN, UIFormat.WHITE_TEXT, "Roulette");
        seeDoneButton = builder.buildSeeDoneToggleButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT,"See Completed");

    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }

}
