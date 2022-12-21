package ui;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;
import presenters.TaskVM;
import useCases.DefaultValueData;
import useCases.TaskUIDS;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskUITest {

    /**
     * Tester for task UI.
     * This should load the task UI a task with the following properties:
     * Name: Test
     * Course: Course
     * Deadline: 2022-12-24
     * Priority: High
     * Assignment Type: Essay
     */
    public static void main(String[] args){


        LocalDate date = LocalDate.parse("2022-12-24", DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT));
        LocalDateTime dateTime = date.atTime(DefaultValueData.DEADLINE_HOUR, DefaultValueData.DEADLINE_MIN);
        TaskVM task = new TaskVM(new TaskUIDS(new Task("Test", "Course", dateTime, Priority.HIGH, AssignmentType.ESSAY)));
        TaskVM[] tasks = {task};


        FakeUIFrame frame = new FakeUIFrame();
        frame.showUI(tasks);


    }
}

/**
 * A JFrame to insert the task UI into without issue.
 */
class FakeUIFrame extends JFrame {
    public void showUI(TaskVM[] tasks){
        setBackground(UIFormat.MAIN_PANEL_BACKGROUND);
        setMinimumSize(new java.awt.Dimension(1288, 733));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        TaskUI taskUI = new TaskUI();
        taskUI.createTaskUI(tasks);
        add(taskUI);

        setVisible(true);
    }
}
