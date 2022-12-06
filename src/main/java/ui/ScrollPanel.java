package ui;

import javax.swing.*;

/**
 * This object contains a JScrollPane which contains all TaskPanels.
 */
public class ScrollPanel extends JPanel {

    private TaskScrollPane scrollPane;
    public void createScrollPanel(String[] tasks){
        //TODO: Change tasks to task data object
        scrollPane = new TaskScrollPane();
        scrollPane.createTaskScrollPane(tasks);
        GroupLayout taskPanelLayout = new GroupLayout(this);
        this.setLayout(taskPanelLayout);
        taskPanelLayout.setHorizontalGroup(
                taskPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(taskPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane)
                                .addContainerGap())
        );
        taskPanelLayout.setVerticalGroup(
                taskPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(taskPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }
}
