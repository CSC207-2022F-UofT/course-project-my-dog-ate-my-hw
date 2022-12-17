package controllers;

import useCases.AdoptPetInputBoundary;
import useCases.BuyItemInputBoundary;

public class BuyItemController {
    private static BuyItemInputBoundary uc;
    private String itemName;

    public static void setUc(BuyItemInputBoundary useCase){
        uc = useCase;
    }
    public BuyItemController(String itemName){
        this.itemName = itemName;
    }

    public void performPurchase(){
        uc.buyItem(itemName);
    }
}
