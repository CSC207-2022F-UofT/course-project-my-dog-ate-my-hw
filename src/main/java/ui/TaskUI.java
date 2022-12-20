package ui;

import javax.swing.*;
import java.awt.*;
import presenters.TaskVM;

public class TaskUI extends JPanel{

    private static final Dimension fillerDimensions = new Dimension(0, 12);

    public void createTaskUI(TaskVM[] tasks) {
        format();

        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.createScrollPanel(tasks);
        ButtonsPanel buttonsPanel = new ButtonsPanel();
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
