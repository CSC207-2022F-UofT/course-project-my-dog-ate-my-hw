package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class PetUI extends JPanel{

    private static final Dimension fillerSizeSmall = new Dimension(0, 6);
    private static final Dimension fillerSizeMid = new Dimension(0, 12);

    private PetDisplayPanel petDisplayPanel;
    private HealthBarPanel healthPanel;
    private PetNamePanel petNamePanel;
    private PointsPanel pointsPanel;
    private ToolPanel toolPanel;
    private Title title;

    public void createPetUI(int currHealth, int maxHealth, String skin, String petName, int points, String[] customizations, boolean petAdopted, String currentEquipment){
        format();

        initializeComponents();
        healthPanel.createHealthBar(currHealth, maxHealth);
        petDisplayPanel.createPetPanel(skin, currentEquipment, currHealth, petAdopted);
        petNamePanel.createNamePanel(petName);
        pointsPanel.createPointsPanel(points);
        toolPanel.createToolPanel(customizations);
        title.createTitle();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createHorizontalGlue());
        add(new Box.Filler(fillerSizeMid, fillerSizeMid, fillerSizeMid));
        add(title);
        add(new Box.Filler(fillerSizeMid, fillerSizeMid, fillerSizeMid));
        add(petDisplayPanel);
        add(new Box.Filler(fillerSizeSmall, fillerSizeSmall, fillerSizeSmall));
        add(petNamePanel);
        add(new Box.Filler(fillerSizeSmall, fillerSizeSmall, fillerSizeSmall));
        add(healthPanel);
        add(new Box.Filler(fillerSizeSmall, fillerSizeSmall, fillerSizeSmall));
        add(toolPanel);
        add(new Box.Filler(fillerSizeSmall, fillerSizeSmall, fillerSizeSmall));
        add(pointsPanel);
        add(new Box.Filler(fillerSizeMid, fillerSizeMid, fillerSizeMid));
    }

    private void initializeComponents(){
        healthPanel = new HealthBarPanel();
        petDisplayPanel = new PetDisplayPanel();
        petNamePanel = new PetNamePanel();
        pointsPanel = new PointsPanel();
        toolPanel = new ToolPanel();
        title = new Title();
    }

    private void format(){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
    }

}
