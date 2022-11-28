package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolPanel extends JPanel {

    JComboBox customizationBox;
    Button healButton;

    private void makeToolPanel(){
        this.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(245, 202, 195)));
        ButtonBuilder builder = new ButtonBuilder();
        builder.buildHealButton(// TODO);
        customizationBox.setModel(new DefaultComboBoxModel<>(loadCustomizations()));
        customizationBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizationBoxActionPerformed(evt);
            }
        });
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

    private String[] loadCustomizations(){
        return new String[]{"Customization", "Hat"};
    }

    private void customizationBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
