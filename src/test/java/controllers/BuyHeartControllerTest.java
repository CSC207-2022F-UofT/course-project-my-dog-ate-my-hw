package controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import useCases.inputBoundaries.BuyHeartInputBoundary;

import java.awt.event.ActionEvent;

public class BuyHeartControllerTest {

    public void setTestConditions(BuyHeartInputBoundary uc){
        BuyHeartController.setUc(uc);
    }

    @Test
    public void ActionPreformedTest(){
        FakeBuyHeartUC uc = new FakeBuyHeartUC();
        setTestConditions(uc);
        BuyHeartController controller = new BuyHeartController();
        controller.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
        Assertions.assertTrue(uc.buyHeartsRan && uc.refreshPetRan);
    }
}

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
