package ui;

import javax.swing.*;

public class MainUI2 extends JFrame{

    private JPanel titlePanel;




    private void makeTitlePanel(){
        JLabel titleLabel = new JLabel("DOG ATE MY HOMEWORK");
        titleLabel.setFont(UIFormat.TITLE_FONT);
        titleLabel.setForeground(UIFormat.GREEN_TEXT);
        titlePanel.setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    private void formatTitlePanel(){

    }
}
