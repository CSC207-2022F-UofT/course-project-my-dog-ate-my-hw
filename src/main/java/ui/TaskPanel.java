package ui;

import controllers.CompleteTaskController;
import presenters.TaskVM;
import useCases.DefaultValueData;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    private static final Dimension preferredSize = new Dimension(754, 80);
    TaskVM task;
    JLabel nameLabel;
    JLabel courseLabel;
    JLabel typeLabel;
    JLabel deadlineLabel;
    JLabel priorityLabel;
    JButton editTask;
    JCheckBox checkBox;

    public void createTaskPanel(TaskVM task) {
        this.task = task;
        format();
        if (task.name.equals(DefaultValueData.EMPTY_TASK.getName())) {
            setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            add(new JLabel(task.name));
        } else {
            setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            initalizeWithFormat(task);
            if (task.completed) {
                createDonePanel();
            } else {
                createToDoPanel();
            }
        }
    }

    public void createDonePanel() {
        add(nameLabel);
        add(courseLabel);
        add(typeLabel);
        add(deadlineLabel);
        add(priorityLabel);
    }

    public void createToDoPanel() {
        createEditButton();
        createCheckBox();
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
        deadlineLabel = new JLabel(task.deadline);
        deadlineLabel.setFont(UIFormat.BUTTON_FONT);
        typeLabel = new JLabel(task.assignmentType);
        typeLabel.setFont(UIFormat.BUTTON_FONT);
        priorityLabel = new JLabel(task.priority);
        priorityLabel.setFont(UIFormat.BUTTON_FONT);
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
        setMaximumSize(preferredSize);
    }
}