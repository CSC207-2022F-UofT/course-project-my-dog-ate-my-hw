package ui;

import controllers.CompleteTaskController;
import presenters.TaskVM;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class TaskPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(754, 100);
    TaskVM task;
    JLabel nameLabel;
    JLabel courseLabel;
    JLabel typeLabel;
    JLabel deadlineLabel;
    JLabel priorityLabel;
    JButton editTask;
    JCheckBox checkBox;

    public void createTaskPanel(TaskVM task) {
        //TODO: Add edit button to each task. Remove from Buttons Panel
        //TODO: Add checkbox to each task
        this.task = task;
        format();
        initalizeWithFormat(task);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        add(checkBox);
        add(nameLabel);
        add(courseLabel);
        add(typeLabel);
        add(deadlineLabel);
        add(priorityLabel);
        add(editTask);
    }

    private void initalizeWithFormat(TaskVM task){
        nameLabel = new JLabel(task.name);
        nameLabel.setFont(UIFormat.BUTTON_FONT);
        courseLabel = new JLabel(task.course);
        courseLabel.setFont(UIFormat.BUTTON_FONT);
        deadlineLabel = new JLabel(task.deadline.toString());
        deadlineLabel.setFont(UIFormat.BUTTON_FONT);
        typeLabel = new JLabel(task.assignenmentType);
        typeLabel.setFont(UIFormat.BUTTON_FONT);
        priorityLabel = new JLabel(task.priority);
        priorityLabel.setFont(UIFormat.BUTTON_FONT);
        createEditButton();
        createCheckBox();
    }

    private void createEditButton(){
        ButtonBuilder builder = new ButtonBuilder();
        editTask = builder.buildEditButton(UIFormat.YEllOW, UIFormat.WHITE_TEXT, "Edit Task", task);
    }

    private void createCheckBox(){
        checkBox = new JCheckBox();
        checkBox.addActionListener(new CompleteTaskController(nameLabel.getText()));
    }

    private void format(){
        setBackground(UIFormat.TASK_SCROLL);
        setMinimumSize(preferredSize);
        setPreferredSize(preferredSize);
    }
}