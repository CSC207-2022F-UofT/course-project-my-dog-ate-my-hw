package ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TaskScrollPane extends JScrollPane {

    private static final Dimension preferredSize = new Dimension(754, 630);
    private JPanel taskContainer;

    public void createTaskScrollPane(String[] tasks){
        formatPane();
        makeTaskContainer(tasks);
        add(taskContainer);
    }

    private void formatPane(){
        setBackground(UIFormat.TASK_SCROLL);
        setBorder(null);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setViewportView(taskContainer);
        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.LIGHT_GRAY;
            }
        });
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);

    }
    private void makeTaskContainer(String [] tasks){
        //TODO: Must be updated when Stephanie commits her task panel code

        taskContainer = new JPanel();
        taskContainer.setMaximumSize(new Dimension(754, 32767));
        taskContainer.setMinimumSize(new Dimension(754, 100));
        taskContainer.setPreferredSize(new Dimension(754, 741));
        taskContainer.setBackground(UIFormat.TASK_SCROLL);

    }
}
