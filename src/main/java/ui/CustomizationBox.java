package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizationBoxActionPerformed(evt);
            }
        });
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }

    /**
     * Calls a controller when a customization is selected. This will get the use case for the customize pet feature.
     * @param evt the event that will call the ActionListener
     */
    private void customizationBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
