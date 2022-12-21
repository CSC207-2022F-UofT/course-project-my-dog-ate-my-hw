package controllers;

import entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import useCases.inputBoundaries.BuyItemInputBoundary;
import java.util.Objects;

/**
 * Testing the BuyItemController class.
 * Code coverage for the BuyItemController class: 100% class, 100% methods, 100% lines
 */
public class BuyItemControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the BuyItemController with a BuyItemInputBoundary.
     * @param uc the BuyItemInputBoundary for the controller to use
     */
    public void setTestConditions(BuyItemInputBoundary uc){
        BuyItemController.setUc(uc);
    }

    /**
     * Test of the performPurchase method of BuyItemController.
     */
    @Test
    public void PerformPurchaseTest(){
        String itemName = "item";
        FakeBuyItemUC uc = new FakeBuyItemUC();
        setTestConditions(uc);
        BuyItemController controller = new BuyItemController(itemName);
        controller.performPurchase();
        Assertions.assertTrue(Objects.equals(uc.itemName, itemName) && uc.refreshItemRan);
    }
}

/**
 * An imitator of the BuyItemUC that stores the specific methods that have been run and the values they were run with.
 */
class FakeBuyItemUC implements BuyItemInputBoundary {

    String itemName;
    User user;
    boolean refreshItemRan = false;

    public void buyItem(User user, String itemName) {
        this.user = user;
        this.itemName = itemName;
    }

    public void buyItem(String itemName){
        this.itemName = itemName;
    }

    public void refreshItem() {
        refreshItemRan = true;
    }
}
