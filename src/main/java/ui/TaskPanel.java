package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    JLabel nameLabel;
    JLabel courseLabel;
    JLabel typeLabel;
    JLabel deadlineLabel;
    JLabel priorityLabel;

    public void createTaskPanel(String name, String course, String type, String deadline, String priority) {
        //TODO: Add edit button to each task. Remove from Buttons Panel
        //TODO: Add checkbox to each task
        initalizeWithFormat(name, course, type, deadline, priority);
        setBackground(UIFormat.TASK_SCROLL);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        add(nameLabel);
        add(courseLabel);
        add(typeLabel);
        add(deadlineLabel);
        add(priorityLabel);
    }

    private void initalizeWithFormat(String name, String course, String type, String deadline, String priority){
        nameLabel = new JLabel(name);
        nameLabel.setFont(UIFormat.BUTTON_FONT);
        courseLabel = new JLabel(course);
        courseLabel.setFont(UIFormat.BUTTON_FONT);
        typeLabel = new JLabel(type);
        typeLabel.setFont(UIFormat.BUTTON_FONT);
        deadlineLabel = new JLabel(deadline);
        deadlineLabel.setFont(UIFormat.BUTTON_FONT);
        priorityLabel = new JLabel(priority);
        priorityLabel.setFont(UIFormat.BUTTON_FONT);

    }
}