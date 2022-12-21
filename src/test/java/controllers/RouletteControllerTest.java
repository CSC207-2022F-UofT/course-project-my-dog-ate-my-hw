package controllers;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.RouletteInputBoundary;

import java.awt.event.ActionEvent;

/**
 * Testing the RouletteController class.
 * Code coverage for the RouletteController class: 100% class, 100% methods, 100% lines
 */
public class RouletteControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the RouletteController with a RouletteInputBoundary.
     * @param uc the RouletteInputBoundary for the controller to use
     */
    public void setTestConditions(RouletteInputBoundary uc){
        RouletteController.setUc(uc);
    }

    /**
     * Test for the action preformed function.
     */
    @Test
    public void ActionPreformedTest(){
        FakeRouletteUC uc = new FakeRouletteUC();
        setTestConditions(uc);

        RouletteController controller = new RouletteController();
        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));

        Assertions.assertTrue(uc.refreshTaskRan);
        Assertions.assertTrue(uc.rouletteRan);
    }
}


/**
 * An imitator of the RouletteUC that stores the specific methods that have been run and the values they were run with.
 */
class FakeRouletteUC implements RouletteInputBoundary{

    public User user;
    public boolean rouletteRan = false;
    public boolean refreshTaskRan = false;

    public void roulette() {
        rouletteRan = true;
    }


    public void roulette(User user) {
        rouletteRan = true;
        this.user = user;
    }


    public void refreshTask() {
        refreshTaskRan = true;
    }
}
