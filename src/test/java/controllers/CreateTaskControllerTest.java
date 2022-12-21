package controllers;

import entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.CreateTaskInputBoundary;

import java.time.LocalDateTime;

/**
 * Testing the CreateTaskController class.
 * Code coverage for the CreateTaskController class: 100% class, 100% methods, 100% lines
 */
public class CreateTaskControllerTest {

    /**
     * Sets the test conditions by injecting the dependencies of
     * CreateTaskController with the given CreateTaskInputBoundary.
     * @param uc the CreateTaskInputBoundary for the controller to use
     */
    public void setTestConditions(CreateTaskInputBoundary uc){
        CreateTaskController.setUc(uc);
    }

    /**
     * Test for the constructor.
     */
    @Test
    public void ConstructorTest(){
        FakeCreateTaskUC uc = new FakeCreateTaskUC();
        setTestConditions(uc);

        LocalDateTime deadline = LocalDateTime.now();
        String taskName = "name".strip();
        String course = "course".strip();
        String priority = "HIGH";
        String assignmentType = "Essay";

        CreateTaskController controller = new CreateTaskController(
                deadline,
                taskName,
                course,
                priority,
                assignmentType
        );

        Assertions.assertEquals(deadline, controller.deadline);
        Assertions.assertEquals(taskName, controller.name);
        Assertions.assertEquals(course, controller.course);
        Assertions.assertEquals(priority, controller.priority);
        Assertions.assertEquals(assignmentType, controller.assignmentType);
    }

    /**
     * Test for the Create method.
     */
    @Test
    public void CreateTest(){
        FakeCreateTaskUC uc = new FakeCreateTaskUC();
        setTestConditions(uc);

        LocalDateTime deadline = LocalDateTime.now();
        String taskName = "name".strip();
        String course = "course".strip();
        String priority = "HIGH";
        String assignmentType = "Essay";

        CreateTaskController controller = new CreateTaskController(
                deadline,
                taskName,
                course,
                priority,
                assignmentType
        );

        Assertions.assertEquals(uc.deadline, controller.deadline);
        Assertions.assertEquals(uc.name, controller.name);
        Assertions.assertEquals(uc.course, controller.course);
        Assertions.assertEquals(uc.priority, controller.priority);
        Assertions.assertEquals(uc.assignmentType, controller.assignmentType);
    }
}


/**
 * An implementation of the CreateTaskInputBoundary that stores the specific methods
 * that have been run and the values they were run with.
 */
class FakeCreateTaskUC implements CreateTaskInputBoundary{

    public String name;
    public String course;
    public LocalDateTime deadline;
    public String priority;
    public String assignmentType;
    public boolean refreshTaskRan = false;

    public void createTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType){
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.priority = priority;
        this.assignmentType = assignmentType;
    }

    public Task getTask(){
        return null;
    }

    public void refreshTask(){
        this.refreshTaskRan = true;
    }
}
