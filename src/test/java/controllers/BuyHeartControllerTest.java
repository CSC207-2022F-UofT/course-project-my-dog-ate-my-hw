package controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import useCases.inputBoundaries.BuyHeartInputBoundary;

import java.awt.event.ActionEvent;

/**
 * Testing the BuyHeartController class.
 * Code coverage for the BuyHeartController class: 100% class, 100% methods, 100% lines
 */
public class BuyHeartControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the BuyHeartController with a BuyHeartInputBoundary.
     * @param uc the BuyHeartInputBoundary for the controller to use
     */
    public void setTestConditions(BuyHeartInputBoundary uc){
        BuyHeartController.setUc(uc);
    }

    /**
     * Test of the actionPreformed method of BuyHeartController.
     */
    @Test
    public void ActionPreformedTest(){
        FakeBuyHeartUC uc = new FakeBuyHeartUC();
        setTestConditions(uc);
        BuyHeartController controller = new BuyHeartController();
        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
        Assertions.assertTrue(uc.buyHeartsRan && uc.refreshPetRan);
    }
}

/**
 * An imitator of the BuyHeartUC that stores the specific methods that have been run.
 */
class FakeBuyHeartUC implements BuyHeartInputBoundary {

    boolean buyHeartsRan = false;
    boolean refreshPetRan = false;

    public void buyHeart() {
        buyHeartsRan = true;
    }

    public void refreshPet() {
        refreshPetRan = true;
    }
}
