package useCases.interactors;

import entities.*;
import useCases.inputBoundaries.BuyItemInputBoundary;
import useCases.refreshers.PetRefresher;

/**
 * The BuyItemUC class is the interactor for the use case in which the user can use the points they've gained from
 * completing tasks to buy items to accessorize their adopted pet with. This class takes input from the
 * BuyItemInputBoundary.
 */
public class BuyItemUC implements BuyItemInputBoundary {

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param itemName Name of the item the user wants to purchase
     */
    public void buyItem(User user, String itemName) {
        try {
            if (user.getPet() != null) {
                Customization customization = user.getPet().getCustomizations();
                Item item = customization.getItem(itemName);
                if (user.getPoints() >= item.getPrice() && !item.isUnlocked()) {
                    user.losePoints(item.getPrice());
                    item.setUnlocked(true);
                    dequipOrEquip(customization, item);
                }
                else if (item.isUnlocked()) {
                    dequipOrEquip(customization, item);
                }
            }
        }
        catch (AbsentItemNameException e) {
            throw new RuntimeException("Not in customization list", e);
        }
        catch (NullPointerException e) {
            throw new RuntimeException("Something was null", e);
        }
    }

    private void dequipOrEquip(Customization custom, Item item) {
        if (!custom.getIsCurrentlyEquipped()) {
            custom.equip(item);
        }
        else {
            custom.dequip();
            custom.equip(item);
        }
    }

    /**
     * Another version of buyItem method
     * @param itemName Name of the item to purchase.
     */
    public void buyItem(String itemName) {
        buyItem(UserUC.u(), itemName);
    }

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshItem() {
        new PetRefresher().refresh();
    }
}
