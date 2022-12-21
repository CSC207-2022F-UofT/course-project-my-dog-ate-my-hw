package controllers;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.CompleteTaskInputBoundary;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * Testing the CompleteTaskController class.
 * Code coverage for the BuyHeartController class: 100% class, 100% methods, 100% lines
 */
public class CompleteTaskControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the
     * CompleteTaskController with a CompleteTaskInputBoundary.
     * @param uc the CompleteTaskInputBoundary for the controller to use
     */
    public void setTestConditions(CompleteTaskInputBoundary uc){
        CompleteTaskController.setUc(uc);
    }

    /**
     * Test of the actionPreformed method.
     */
    @Test
    public void ActionPreformedTest(){
        FakeCompleteTaskUC uc = new FakeCompleteTaskUC();
        setTestConditions(uc);

        String taskName = "task";
        CompleteTaskController controller = new CompleteTaskController(taskName);

        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
        Assertions.assertTrue(Objects.equals(uc.taskName, taskName) && uc.refreshCompleteTaskRan);
    }
}

/**
 * An imitator of the CompleteTaskUC that stores the specific methods that have been run.
 */
class FakeCompleteTaskUC implements CompleteTaskInputBoundary{

    public User user;
    public String taskName;
    public boolean refreshCompleteTaskRan = false;

    public void completeTask(String taskName, User user){
        this.user = user;
        this.taskName = taskName;
    }

    public void completeTask(String taskName){
        this.taskName = taskName;
    }

    public void refreshCompleteTask(){
        refreshCompleteTaskRan = true;
    }
}
