package ui;

import presenters.TaskVM;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TaskScrollPane extends JScrollPane {

    private static final Dimension preferredSize = new Dimension(754, 630);
    private JPanel taskContainer;

    /**
     * Creates a TaskScrollPane
     * @param tasks the tasks that will be added to the scroll pane
     */
    public void createTaskScrollPane(TaskVM[] tasks){
        makeTaskContainer(tasks);
        add(taskContainer);
        formatPane();
    }

    /**
     * Formats scroll pane colors and sizing
     */
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

    /**
     * Makes a panel that has all tasks added to it.
     * @param tasks all the tasks that will be added to the task view
     */
    private void makeTaskContainer(TaskVM[] tasks){
        taskContainer = new JPanel();
        taskContainer.setLayout(new BoxLayout(taskContainer, BoxLayout.PAGE_AXIS));

        if(tasks != null){
        // load in all tasks as panels
        for(TaskVM task : tasks){
            TaskPanel panel = new TaskPanel();
            panel.createTaskPanel(task);
            taskContainer.add(panel);
        }}

        taskContainer.add(Box.createVerticalGlue());
        // format container
        taskContainer.setMaximumSize(new Dimension(754, 32767));
        taskContainer.setMinimumSize(new Dimension(754, 100));
        taskContainer.setPreferredSize(new Dimension(754, 741));
        taskContainer.setBackground(UIFormat.TASK_SCROLL);

    }
}
