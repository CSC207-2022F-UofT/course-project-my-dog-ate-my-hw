package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * A JPanel with Pet-Related Buttons
 */
public class ToolPanel extends JPanel {

    // GLOBAL VARIABLES
    private static final Dimension verticalFillerDimensions = new Dimension(0, 51);
    private static final Dimension smallFillerDimensions = new Dimension(6, 0);
    private static final Dimension preferredSize = new Dimension(410, 51);
    CustomizationBox customizationBox;
    Button healButton;

    // METHODS
    public void createToolPanel(String[] customizations){
        format();
        createHealButton();
        createCustomizationBox(customizations);
        makeToolPanelLayout();
    }
    private void makeToolPanelLayout() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(new Box.Filler(smallFillerDimensions, smallFillerDimensions, smallFillerDimensions));
        add(healButton);
        add(new Box.Filler(verticalFillerDimensions, verticalFillerDimensions, verticalFillerDimensions));
        add(Box.createHorizontalGlue());
        add(customizationBox);
        add(new Box.Filler(smallFillerDimensions, smallFillerDimensions, smallFillerDimensions));
    }

    /**
     * Creates a Heal Button
     */
    private void createHealButton(){
        ButtonBuilder builder = new ButtonBuilder();
        healButton = builder.buildHealButton(UIFormat.HEAL_BUTTON, Color.WHITE, "HEAL");
    }

    // Creates a JComboBox that stores Customizations
    private void createCustomizationBox(String[] customizations){
        customizationBox = new CustomizationBox();
        customizationBox.createCustomizationBox(customizations);
    }

    private void format(){
        setBackground(UIFormat.SIDE_PANEL_BACKGROUND);
        setBorder(new SoftBevelBorder(BevelBorder.RAISED, getBackground().brighter(), UIFormat.BUTTON_PINK));
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);

    }


}
