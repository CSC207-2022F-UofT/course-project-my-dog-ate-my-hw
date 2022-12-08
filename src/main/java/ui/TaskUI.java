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

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TaskUI task = new TaskUI();
        String[] s = new String[1];
        task.createTaskUI(s);
        testFrame.add(task);
        testFrame.setMinimumSize(new java.awt.Dimension(450, 733));

        testFrame.setLocationRelativeTo(null);

        testFrame.setVisible(true);
    }
}
