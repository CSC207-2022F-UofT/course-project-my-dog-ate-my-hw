package ui;

import javax.swing.*;

public class PetUI extends JPanel{

    private PetDisplayPanel petDisplayPanel;
    private HealthBarPanel healthPanel;
    private PetNamePanel petNamePanel;
    private PointsPanel pointsPanel;
    private ToolPanel toolPanel;
    private JButton adpotPetButton;
    private Title title;

    public void createPetDisplay(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, boolean petAdopted){
        initializeComponents();
        healthPanel.createHealthBar(currHealth, maxHealth);
        petDisplayPanel.createPetPanel(skin, petAdopted);
        petNamePanel.createNamePanel(petName);
        pointsPanel.createPointsPanel(points);
        toolPanel.createToolPanel(customizations);
        title.createTitle();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(title);
        add(petDisplayPanel);
        add(petNamePanel);
        add(healthPanel);
        add(toolPanel);
        add(pointsPanel);

    }

    private void initializeComponents(){
        healthPanel = new HealthBarPanel();
        petDisplayPanel = new PetDisplayPanel();
        petNamePanel = new PetNamePanel();
        pointsPanel = new PointsPanel();
        toolPanel = new ToolPanel();
        title = new Title();
    }


}
