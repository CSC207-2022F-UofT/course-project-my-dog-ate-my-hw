package controllers;

import useCases.AdoptPetInputBoundary;
import useCases.BuyItemInputBoundary;

import java.util.regex.Pattern;

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
        uc.buyItem(convertItemName(itemName));
        uc.refreshItem();
    }

    /**
     * Returns the item name with any locked status (LOCKED) removed
     * @param itemName name of item
     * @return name with no locked status
     */
    private String convertItemName(String itemName){
        return itemName.replaceFirst("[(][A-Z]*[)]$", "");
    }
}
