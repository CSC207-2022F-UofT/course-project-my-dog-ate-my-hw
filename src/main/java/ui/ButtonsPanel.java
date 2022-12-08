package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonsPanel extends JPanel {

    private static final Dimension fillerDimensionsSmall = new Dimension(6, 0);
    private Button newTaskButton;
    private ToggleButton editTaskToggle;
    private Button rouletteButton;
    private ToggleButton seeDoneButton;

    public void createButtonsPanel(){
        format();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        initalizeButtons();
        add(newTaskButton);
        add(new Box.Filler(fillerDimensionsSmall, fillerDimensionsSmall, fillerDimensionsSmall));
        add(editTaskToggle);
        add(new Box.Filler(fillerDimensionsSmall, fillerDimensionsSmall, fillerDimensionsSmall));
        add(rouletteButton);
        add(Box.createHorizontalGlue());
        add(seeDoneButton);

    }

    private void initalizeButtons(){
        ButtonBuilder builder = new ButtonBuilder();

        newTaskButton = builder.buildNewTaskButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT, createBevel(UIFormat.BUTTON_PINK), "New Task");
        editTaskToggle = builder.buildEditToggleButton(UIFormat.YEllOW, UIFormat.WHITE_TEXT, createBevel(UIFormat.YEllOW), "Edit Task");
        rouletteButton = builder.buildRouletteButton(UIFormat.GREEN, UIFormat.WHITE_TEXT, createBevel(UIFormat.GREEN), "Roulette");
        seeDoneButton = builder.buildSeeDoneToggleButton(UIFormat.BUTTON_PINK,UIFormat.WHITE_TEXT, createBevel(UIFormat.BUTTON_PINK), "See Completed");

    }
    private Border createBevel(Color background){
        return BorderFactory.createBevelBorder(BevelBorder.RAISED, background.brighter(), background.darker());
    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }

}
