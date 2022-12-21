package controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.SeeToDoInputBoundary;

import java.awt.event.ActionEvent;

/**
 * Testing the SeeToDoController class.
 * Code coverage for the SeeToDoController class: 100% class, 100% methods, 100% lines
 */
public class SeeToDoControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the SeeToDoController with a SeeToDoInputBoundary.
     * @param uc the SeeToDoInputBoundary for the controller to use
     */
    public void setTestConditions(SeeToDoInputBoundary uc){
        SeeToDoController.setUc(uc);
    }

    /**
     * Test of the actionPreformed method of the SeeToDoController.
     */
    @Test
    public void ActionPreformedTest(){
        FakeSeeToDoControllerUC uc = new FakeSeeToDoControllerUC();
        setTestConditions(uc);

        SeeToDoController controller = new SeeToDoController();
        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

        Assertions.assertTrue(uc.refreshTaskRan);
    }

}


/**
 * An imitator of the SeeToDoControllerUC that stores the specific methods
 * that have been run and the values they were run with.
 */
class FakeSeeToDoControllerUC implements SeeToDoInputBoundary{

    public boolean refreshTaskRan = false;

    public void refreshTask() {
        refreshTaskRan = true;
    }
}
