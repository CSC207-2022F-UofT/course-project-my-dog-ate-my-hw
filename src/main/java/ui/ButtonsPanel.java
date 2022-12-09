package ui;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel with Task-related Buttons. Formats them in a line.
 */
public class ButtonsPanel extends JPanel {

    // GLOBAL VARIABLES
    private static final Dimension fillerDimensionsSmall = new Dimension(6, 0);
    private Button newTaskButton;
    private Button rouletteButton;
    private Button seeDoneButton;
    private Button seeToDoButton;

    // METHODS
    public void createButtonsPanel(){
        format();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        initalizeButtons();
        add(newTaskButton);
        add(new Box.Filler(fillerDimensionsSmall, fillerDimensionsSmall, fillerDimensionsSmall));
        add(rouletteButton);
        add(Box.createHorizontalGlue());
        add(seeToDoButton);
        add(new Box.Filler(fillerDimensionsSmall, fillerDimensionsSmall, fillerDimensionsSmall));
        add(seeDoneButton);

    }

    /**
     * Uses ButtonBuilder to create all Buttons
     */
    private void initalizeButtons(){
        ButtonBuilder builder = new ButtonBuilder();
        newTaskButton = builder.buildNewTaskButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT, "New Task");
        rouletteButton = builder.buildRouletteButton(UIFormat.YEllOW, UIFormat.WHITE_TEXT, "Roulette");
        seeDoneButton = builder.buildSeeDoneButton(UIFormat.GREEN, UIFormat.WHITE_TEXT,"See Completed");
        seeToDoButton = builder.buildSeeToDoButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT,"See ToDo");
    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }

}
