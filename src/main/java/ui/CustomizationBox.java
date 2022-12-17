package ui;

import controllers.BuyItemController;

import javax.swing.*;
import java.awt.*;

/**
 * A JComboBox with the customization options as selectable components
 */
public class CustomizationBox extends JComboBox<String>{

    private static final Dimension preferredSize = new Dimension(70, 24);

    /**
     * Creates and formats a JComboBox with a list of given customizations.
     * @param customizations a String Array of possible combinations that the user can select
     */
    public void createCustomizationBox(String[] customizations){
        setModel(new DefaultComboBoxModel<>(customizations));
        setFont(UIFormat.BUTTON_FONT);
        setForeground(UIFormat.PINK_TEXT);
        addActionListener(this::customizationBoxActionPerformed);
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }

    /**
     * Calls a controller when a customization is selected. This will get the use case for the customize pet feature.
     * @param evt the event that will call the ActionListener
     */
    private void customizationBoxActionPerformed(java.awt.event.ActionEvent evt) {
        BuyItemController controller = new BuyItemController((String) getSelectedItem());
        controller.performPurchase();
    }
}
