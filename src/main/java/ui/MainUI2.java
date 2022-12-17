package ui;

import presenters.TaskVM;

import javax.swing.*;
import java.awt.*;

public class MainUI2 extends JFrame{

    private static final Dimension fillerSizeSmall = new Dimension(15, 733);
    private static final Dimension fillerSizeMid = new Dimension(26, 733);

    public MainUI2(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, String equippedIteam, boolean petAdopted, TaskVM[] tasks){
        refresh(currHealth, maxHealth, skin, petName, points, customizations, equippedIteam, petAdopted, tasks);
    }

    public void refresh(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, String equippedIteam, boolean petAdopted, TaskVM[] tasks){
        format();
        PetUI petUI = new PetUI();
        TaskUI taskUI = new TaskUI();
        petUI.createPetUI(currHealth, maxHealth, skin, petName, points, customizations, petAdopted, equippedIteam);
        taskUI.createTaskUI(tasks);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.add(new Box.Filler(fillerSizeMid, fillerSizeMid, fillerSizeMid));
        mainPanel.add(taskUI);
        mainPanel.add(new Box.Filler(fillerSizeSmall, fillerSizeSmall, fillerSizeSmall));
        mainPanel.add(petUI);
        mainPanel.add(new Box.Filler(fillerSizeMid, fillerSizeMid, fillerSizeMid));
        add(mainPanel);
        mainPanel.setMinimumSize(new java.awt.Dimension(1288, 733));
        setVisible(true);
    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        setMinimumSize(new java.awt.Dimension(1288, 733));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

}
