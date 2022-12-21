package controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.ModifyTaskInputBoundary;

import java.time.LocalDateTime;

/**
 * Testing the ModifyTaskController class.
 * Code coverage for the ModifyTaskController class: 100% class, 100% methods, 100% lines
 */
public class ModifyTaskControllerTest {

    /**
     * Sets the test conditions by injecting the dependencies of
     * ModifyTaskController with the given ModifyTaskInputBoundary.
     * @param uc the ModifyTaskInputBoundary for the controller to use
     */
    public void setTestConditions(ModifyTaskInputBoundary uc){
        ModifyTaskController.setUc(uc);
    }

    /**
     * Test for the constructor.
     */
    @Test
    public void ConstructorTest(){
        FakeModifyTaskUC uc = new FakeModifyTaskUC();
        setTestConditions(uc);

        LocalDateTime deadline = LocalDateTime.now();
        String taskName = "name".strip();
        String course = "course".strip();
        String priority = "HIGH";
        String assignmentType = "Essay";
        String oldName = "oldname";

        ModifyTaskController controller = new ModifyTaskController(
                deadline,
                taskName,
                course,
                priority,
                assignmentType,
                oldName
        );

        Assertions.assertEquals(deadline, controller.deadline);
        Assertions.assertEquals(taskName, controller.name);
        Assertions.assertEquals(course, controller.course);
        Assertions.assertEquals(priority, controller.priority);
        Assertions.assertEquals(assignmentType, controller.assignmentType);
    }

    /**
     * Test for the Modify method when the test is not found.
     */
    @Test
    public void ModifyFalseTest(){
        FakeModifyTaskUC uc = new FakeModifyTaskUC();
        setTestConditions(uc);

        uc.taskFound = false;

        LocalDateTime deadline = LocalDateTime.now();
        String taskName = "name".strip();
        String course = "course".strip();
        String priority = "HIGH";
        String assignmentType = "Essay";
        String oldName = "oldName";

        ModifyTaskController controller = new ModifyTaskController(
                deadline,
                taskName,
                course,
                priority,
                assignmentType,
                oldName
        );

        Assertions.assertNull(uc.deadline);
        Assertions.assertNull(uc.name);
        Assertions.assertNull(uc.course);
        Assertions.assertNull(uc.priority);
        Assertions.assertNull(uc.assignmentType);
        Assertions.assertTrue(uc.refreshTaskRan);
    }

    /**
     * Test for the Modify method when the test is found.
     */
    @Test
    public void ModifyTrueTest(){
        FakeModifyTaskUC uc = new FakeModifyTaskUC();
        setTestConditions(uc);

        uc.taskFound = true;

        LocalDateTime deadline = LocalDateTime.now();
        String taskName = "name".strip();
        String course = "course".strip();
        String priority = "HIGH";
        String assignmentType = "Essay";
        String oldName = "oldName";

        ModifyTaskController controller = new ModifyTaskController(
                deadline,
                taskName,
                course,
                priority,
                assignmentType,
                oldName
        );

        Assertions.assertEquals(uc.deadline, controller.deadline);
        Assertions.assertEquals(uc.name, controller.name);
        Assertions.assertEquals(uc.course, controller.course);
        Assertions.assertEquals(uc.priority, controller.priority);
        Assertions.assertEquals(uc.assignmentType, controller.assignmentType);
        Assertions.assertTrue(uc.refreshTaskRan);
    }
}


/**
 * An implementation of the ModifyTaskInputBoundary that stores the specific methods
 * that have been run and the values they were run with.
 */
class FakeModifyTaskUC implements ModifyTaskInputBoundary{

    public String name;
    public String course;
    public LocalDateTime deadline;
    public String priority;
    public String assignmentType;
    public boolean taskFound;
    public boolean refreshTaskRan = false;

    public void modifyTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType){
        this.name = name;
        this.course = course;
        this.deadline = deadline;
        this.priority = priority;
        this.assignmentType = assignmentType;
    }

    public boolean findTask(String name){
        return taskFound;
    }

    public void refreshTask(){
        this.refreshTaskRan = true;
    }
}
