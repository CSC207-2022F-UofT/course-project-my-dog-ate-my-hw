package controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.SeeDoneInputBoundary;

import java.awt.event.ActionEvent;

/**
 * Testing the SeeDoneController class.
 * Code coverage for the SeeDoneController class: 100% class, 100% methods, 100% lines
 */
public class SeeDoneControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the SeeDoneController with a SeeDoneInputBoundary.
     * @param uc the SeeDoneInputBoundary for the controller to use
     */
    public void setTestConditions(SeeDoneInputBoundary uc){
        SeeDoneController.setUc(uc);
    }

    /**
     * Test of the actionPreformed method of the SeeDoneController.
     */
    @Test
    public void ActionPreformedTest(){
        FakeSeeDoneControllerUC uc = new FakeSeeDoneControllerUC();
        setTestConditions(uc);

        SeeDoneController controller = new SeeDoneController();
        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

        Assertions.assertTrue(uc.refreshTaskRan);
    }

}


/**
 * An imitator of the SeeDoneControllerUC that stores the specific methods
 * that have been run and the values they were run with.
 */
class FakeSeeDoneControllerUC implements SeeDoneInputBoundary{

    public boolean refreshTaskRan = false;

    public void refreshTask() {
        refreshTaskRan = true;
    }
}
