package ui;

import javax.swing.*;
import java.awt.*;

public class TaskUI extends JPanel{

    private static final Dimension fillerDimensions = new Dimension(0, 12);
    private ButtonsPanel buttonsPanel;
    private ScrollPanel scrollPanel;

    public void createTaskUI(String[] tasks) {
        format();

        //TODO: Change tasks from string to task data objects
        scrollPanel = new ScrollPanel();
        scrollPanel.createScrollPanel(tasks);
        buttonsPanel = new ButtonsPanel();
        buttonsPanel.createButtonsPanel();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(buttonsPanel);
        add(new Box.Filler(fillerDimensions, fillerDimensions, fillerDimensions));
        add(scrollPanel);

    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }

}
