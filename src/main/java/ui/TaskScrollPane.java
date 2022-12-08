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
        setMaximumSize(preferredSize);
        setBorder(BorderFactory.createLineBorder(UIFormat.YEllOW, 2));
    }
    private void makeTaskContainer(String [] tasks){
        taskContainer = new JPanel();
        //TODO: Add ability for Container to load in all tasks in tasks. Use TaskPanel to create a task panel for each task
        taskContainer.setMaximumSize(new Dimension(754, 32767));
        taskContainer.setMinimumSize(new Dimension(754, 100));
        taskContainer.setPreferredSize(new Dimension(754, 741));
        taskContainer.setBackground(UIFormat.TASK_SCROLL);

    }
}
