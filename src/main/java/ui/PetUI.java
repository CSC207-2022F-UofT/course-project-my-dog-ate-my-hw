package ui;

public class PetUI {

    private PetDisplayPanel petDisplayPanel;
    private HealthBarPanel healthPanel;
    private PetNamePanel petNamePanel;
    private PointsPanel pointsPanel;
    private ToolPanel toolPanel;

    private void createPetDisplay(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, boolean petAdopted){
        healthPanel.createHealthBar(currHealth, maxHealth);
        petDisplayPanel.createPetPanel(skin, petAdopted);
        petNamePanel.createNamePanel(petName);
        pointsPanel.createPointsPanel(points);
        toolPanel.createToolPanel(customizations);
    }


}
