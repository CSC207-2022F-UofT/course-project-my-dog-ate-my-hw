package ui;

import controllers.CreateTaskController;
import controllers.ModifyTaskController;
import useCases.CreateTaskInputBoundary;
import useCases.ModifyTaskInputBoundary;
import java.time.LocalDateTime;

public class TaskViewTest {

    /**
     * Tester for making a task UI.
     */
    public static void main(String[] args){
        setFakeUseCases();
        TaskView v = new TaskView();
        v.createTaskView();
    }

    /**
     * Sets the conditions for the tests.
     */
    public static void setFakeUseCases(){
        CreateTaskController.setUc(new UseCaseFaker());
        ModifyTaskController.setUc(new UseCaseFaker());
    }
}

/**
 * UseCaseFaker is a class meant to imitate the methods of the CreateTaskUC and ModifyTaskUC but instead of changing
 * the model, the values given to them by the TaskView.
 */
class UseCaseFaker implements CreateTaskInputBoundary, ModifyTaskInputBoundary {
    public void createTask(String name, String course, LocalDateTime deadline, String priority, String
            assignmentType){
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Deadline: " +  deadline.toString());
        System.out.println("Priority: " + priority);
        System.out.println("Assignment Type: " + assignmentType);
    }

    /**
     * Create a new task and delete the old one ("modify")
     *
     * @param name           task name
     * @param course         task course
     * @param deadline       task deadline
     * @param priority       priority string
     * @param assignmentType assignment type string
     */
    public void modifyTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType) {
        System.out.println("Name: " + name + "\nCourse: " + course + "\nDeadline: " + deadline + "\nPriority: " +
                priority + "\nAssignment Type: " + assignmentType);
    }

    public boolean findTask(String name){return true;}

    public void refreshTask(){}

    public entities.Task getTask(){return null;}

}