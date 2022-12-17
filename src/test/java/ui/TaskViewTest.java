package ui;

import controllers.CreateTaskController;
import controllers.ModifyTaskController;
import entities.AssignmentType;
import entities.Priority;
import entities.Task;
import presenters.TaskVM;
import useCases.CreateTaskInputBoundary;
import useCases.ModifyTaskInputBoundary;
import useCases.TaskUIDS;

import java.time.LocalDateTime;

public class TaskViewTest {


    /**
     * Tester for making a task UI.
     */
    public static void main(String[] args){
        setFakeUseCases();
        if(false) {
            TaskView v = new TaskView();
            v.createTaskView();
        }
        else{
            TaskVM t = new TaskVM(new TaskUIDS(new Task(
                    "task_name", "course_name", LocalDateTime.now(), Priority.MEDIUM, AssignmentType.ESSAY
            )));
            TaskView v = new TaskView();
            v.createTaskView(t);
        }
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
 * the model, they values given to them by the TaskView.
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

    public void changeName(String name){
        System.out.println("Name: " + name);
    }

    public void changeCourse(String course){
        System.out.println("Course: " + course);
    }

    public void changePriority(String priority){
        System.out.println("Priority: " + priority);
    }

    public void changeDeadline(LocalDateTime deadline){
        System.out.println("Deadline: " + deadline.toString());
    }

    public void changeAssignmentType(String as){
        System.out.println("Assignment Type: " + as);
    }

    public boolean findTask(String name){return true;}

    public void refreshTask(){}

    public entities.Task getTask(){return null;}

}