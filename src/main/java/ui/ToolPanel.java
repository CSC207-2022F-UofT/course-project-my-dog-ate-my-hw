package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolPanel extends JPanel {

    JComboBox customizationBox;
    Button healButton;

    public void createToolPanel(String[] customizations){
        this.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(245, 202, 195)));
        createHealButton();
        createCustomizationBox(customizations);
        makeToolPanelLayout();
    }
    private void makeToolPanelLayout(){
        GroupLayout toolPanelLayout = new GroupLayout(this);
        this.setLayout(toolPanelLayout);
        toolPanelLayout.setHorizontalGroup(
                toolPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, toolPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(healButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customizationBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        toolPanelLayout.setVerticalGroup(
                toolPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, toolPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(toolPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(customizationBox)
                                        .addComponent(healButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private void createHealButton(){
        ButtonBuilder builder = new ButtonBuilder();
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, UIFormat.HEAL_BUTTON.brighter(), UIFormat.HEAL_BUTTON.darker());
        healButton = builder.buildHealButton(UIFormat.HEAL_BUTTON, Color.WHITE, border, "HEAL");
    }

    private void createCustomizationBox(String[] customizations){
        customizationBox = new JComboBox<>(new DefaultComboBoxModel<>(customizations));
        customizationBox.setFont(UIFormat.BUTTON_FONT);
        customizationBox.setForeground(UIFormat.PINK_TEXT);
        customizationBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizationBoxActionPerformed(evt);
            }
        });
    }
    private void customizationBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
