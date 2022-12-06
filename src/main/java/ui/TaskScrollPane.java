package ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TaskScrollPane extends JScrollPane {

    private JPanel taskContainer;

    public void createTaskScrollPane(String[] tasks){
        formatPane();
        makeTaskContainer(tasks);
    }

    private void formatPane(){
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setViewportView(taskContainer);
        this.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });
    }
    private void makeTaskContainer(String [] tasks){
        //TODO: Must be updated when Stephanie commits her task panel code

        taskContainer.setMaximumSize(new Dimension(754, 32767));
        taskContainer.setMinimumSize(new Dimension(754, 100));
        taskContainer.setPreferredSize(new Dimension(754, 741));

        // Set Layouts TODO: Chnage to box layout, likely will use Stephanie's code
        GroupLayout taskContainerLayout = new GroupLayout(taskContainer);
        taskContainer.setLayout(taskContainerLayout);
        taskContainerLayout.setHorizontalGroup(
                taskContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 754, Short.MAX_VALUE)
        );
        taskContainerLayout.setVerticalGroup(
                taskContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 687, Short.MAX_VALUE)
        );

    }
}
