package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class TaskUI {

    private Button newTaskButton;
    private ToggleButton editTaskToggle;
    private Button rouletteButton;
    private ToggleButton seeDoneButton;

    private ScrollPanel scrollPanel;

    public void createTaskUI(String[] tasks){
        //TODO: Change tasks from string to task data objects
        scrollPanel = new ScrollPanel();
        scrollPanel.createScrollPanel(tasks);

        ButtonBuilder builder = new ButtonBuilder();

        newTaskButton = builder.buildNewTaskButton(UIFormat.BUTTON_PINK, UIFormat.WHITE_TEXT, createBevel(UIFormat.BUTTON_PINK), "New Task");
        editTaskToggle = builder.buildEditToggleButton(UIFormat.YEllOW, UIFormat.WHITE_TEXT, createBevel(UIFormat.YEllOW), "Edit Task");
        rouletteButton = builder.buildRouletteButton(UIFormat.GREEN, UIFormat.WHITE_TEXT, createBevel(UIFormat.GREEN), "Roulette");
        seeDoneButton = builder.buildSeeDoneToggleButton(UIFormat.BUTTON_PINK,UIFormat.WHITE_TEXT, createBevel(UIFormat.BUTTON_PINK), "See Completed");

    }

    private Border createBevel(Color background){
        return BorderFactory.createBevelBorder(BevelBorder.RAISED, background.brighter(), background.darker());
    }
}
