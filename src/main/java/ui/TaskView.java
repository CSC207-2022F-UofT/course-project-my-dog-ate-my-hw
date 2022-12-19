package ui;

import controllers.CreateTaskController;
import controllers.ModifyTaskController;
import presenters.TaskVM;
import useCases.DefaultValueData;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Displays a window to change task's name, deadline, course, priority and assignment type.
 */
public class TaskView extends JFrame {
    private static final String[] priority = {"LOW", "MEDIUM","HIGH"};
    private static final String[] assignmentType = {"ESSAY", "PROJECT","EXAM", "QUIZ", "REFLECTION"};
    private final JLabel labelName = new JLabel("Enter name: ");
    private final JLabel labelCourse = new JLabel("Enter course: ");

    private final JLabel labelDeadline = new JLabel("Enter deadline: ");
    private final JLabel labelPriority = new JLabel("Enter Priority: ");
    private final JLabel labelAssignment = new JLabel("Enter Assignment Type: ");
    private final JButton buttonSave = new JButton("Save");
    private final JTextField textName = new JTextField(20);
    private final JTextField textCourse = new JTextField(20);
    private CalendarPanel calendarPanel;
    private JComboBox<String> priorityBox;
    private JComboBox<String> assignmentTypeBox;
    private boolean newTask;
    private String oldName;

    /**
     * Called if a new task is being created
     */
    public void createTaskView(){
        newTask = true;
        layoutTaskView();
        display();
    }

    /**
     * Called if a task is being modified, input areas start with the previously selected values
     * @param task the task being modified.
     */
    public void createTaskView(TaskVM task){
        newTask = false;
        oldName = task.name;
        layoutTaskView();
        textName.setText(task.name);
        textCourse.setText(task.course);
        setSelectedValue(priorityBox, task.priority);
        setSelectedValue(assignmentTypeBox, task.assignmentType);
        calendarPanel.setDate(task.deadline);
        display();
    }

    /**
     * Creates and lays out the TaskView
     */
    public void layoutTaskView() {
        setTitle("Create/Modify Task");

        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add task label and a field to enter to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelName, constraints);

        constraints.gridx = 1;
        newPanel.add(textName, constraints);

        // add course label and a field to enter to the panel
        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelCourse, constraints);

        constraints.gridx = 1;
        newPanel.add(textCourse, constraints);

        // add deadline label and a calendar pop-up to the panel
        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelDeadline, constraints);

        constraints.gridx = 1;
        calendarPanel = new CalendarPanel();
        newPanel.add(calendarPanel.createCalendar(), constraints);

        // add label priority and a priority drop down
        constraints.gridx = 0;
        constraints.gridy = 3;
        newPanel.add(labelPriority, constraints);

        constraints.gridx = 1;
        priorityBox = new JComboBox<>(priority);
        priorityBox.setBounds(80, 50, 140, 20);
        newPanel.add(priorityBox,constraints);

        // add label assignment type and an assignment drop down
        constraints.gridx = 0;
        constraints.gridy = 4;
        newPanel.add(labelAssignment, constraints);

        constraints.gridx = 1;
        assignmentTypeBox = new JComboBox<>(assignmentType);
        assignmentTypeBox.setBounds(80, 50, 140, 20);
        newPanel.add(assignmentTypeBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonSave, constraints);
        buttonSave.addActionListener(e -> {
            callController();
        });

        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Displays the TaskViewWindow
     */
    public void display(){
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        setVisible(true);

    }

    /**
     * Searches for a value in the combobox and sets it as the selected value
     * @param comboBox the combobox box being search in
     * @param value the value being searched for
     */
    private void setSelectedValue(JComboBox comboBox, String value){
        String item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (String) comboBox.getItemAt(i);
            if (item.equalsIgnoreCase(value)){
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private LocalDateTime stringToDate(String textDate){
        LocalDate date = LocalDate.parse(textDate, DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT));
        return date.atTime(DefaultValueData.DEADLINE_HOUR, DefaultValueData.DEADLINE_MIN);
    }

    private void callController() {
        String date = calendarPanel.getDate();
        LocalDateTime dateTime;
        if(newTask){
            try {
                dateTime = stringToDate(date);
                dispose();
                new CreateTaskController(dateTime, textName.getText(), textCourse.getText(),
                        (String) priorityBox.getSelectedItem(),
                        (String) assignmentTypeBox.getSelectedItem());
            } catch (NullPointerException error) {
                throw new RuntimeException("Task Info Not Entered", error);
            }
        } else {
            try {
                dispose();
                dateTime = stringToDate(date);
                new ModifyTaskController(dateTime, textName.getText(), textCourse.getText(),
                        (String) priorityBox.getSelectedItem(), (String) assignmentTypeBox.getSelectedItem(), oldName);
            } catch (NullPointerException error) {
                throw new RuntimeException("Task Info Not Entered", error);
            }
        }
    }

}
