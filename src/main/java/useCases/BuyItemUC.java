package useCases;

import entities.*;

public class BuyItemUC implements BuyItemInputBoundary{

    /**
     * (For Testing) Allows the user to buy an item and updates their points and pet accordingly.
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
                    if (!customization.getIsCurrentlyEquipped()) {
                        customization.equip(item);
                    } else {
                        customization.dequip();
                        customization.equip(item);
                    }
                } else if (item.isUnlocked()) {
                    if (!customization.getIsCurrentlyEquipped()) {
                        customization.equip(item);
                    } else {
                        customization.dequip();
                        customization.equip(item);
                    }
                }
            }
        } catch (AbsentItemNameException e) {
            throw new RuntimeException("Not in customization list", e);
        } catch (NullPointerException e) {
            throw new RuntimeException("Something was null", e);
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
