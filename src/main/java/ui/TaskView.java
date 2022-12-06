package ui;

import javax.swing.*;
import java.awt.*;

/**
 * This is the task window that shows the task's name, course, deadline, priority and deadline.
 */
public class TaskView extends JFrame {

    private JLabel labelName = new JLabel("Enter name: ");
    private JLabel labelCourse = new JLabel("Enter course: ");
    private JTextField textName = new JTextField(20);
    private JTextField textCourse = new JTextField(20);
    private JLabel labelDeadline = new JLabel("Enter deadline: ");
    private JLabel labelPriority = new JLabel("Enter Priority: ");
    private JLabel labelAssignment = new JLabel("Enter Assignment Type: ");
    private JButton buttonSave = new JButton("Save");

    private String[] priority = {"LOW", "MEDIUM","HIGH"};
    private String[] assignmentType = {"ESSAY", "PROJECT","EXAM", "QUIZ", "REFLECTION"};

    public TaskView() {
        super("Create/Modify Task");

        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // adds the label of "Enter name: "
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelName, constraints);

        // adds the text field besides name label
        constraints.gridx = 1;
        newPanel.add(textName, constraints);

        //adds the label to enter course
        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelCourse, constraints);

        //adds the text field besides course label
        constraints.gridx = 1;
        newPanel.add(textCourse, constraints);

        //adds the label to enter deadline
        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelDeadline, constraints);

        //calls on the calendar panel to add the calendar popup besides deadline label
        constraints.gridx = 1;
        CalendarPanel calendarPanel = new CalendarPanel();
        newPanel.add(calendarPanel.createCalendar(), constraints);

        //adds the label to enter priority
        constraints.gridx = 0;
        constraints.gridy = 3;
        newPanel.add(labelPriority, constraints);

        //adds a dropdown menu for the priority besides the label
        constraints.gridx = 1;
        JComboBox<String> jComboBox = new JComboBox<>(priority);
        jComboBox.setBounds(80, 50, 140, 20);
        newPanel.add(jComboBox,constraints);

        //adds the label to enter assignment type
        constraints.gridx = 0;
        constraints.gridy = 4;
        newPanel.add(labelAssignment, constraints);

        //adds a dropdown menu for the assignment type besides the label
        constraints.gridx = 1;
        JComboBox<String> jComboBox2 = new JComboBox<>(assignmentType);
        jComboBox.setBounds(80, 50, 140, 20);
        newPanel.add(jComboBox2,constraints);

        //adds a save button
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonSave, constraints);


        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);
    }



    public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskView().setVisible(true);
            }
        });
    }
}