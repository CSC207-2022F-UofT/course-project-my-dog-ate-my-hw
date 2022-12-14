package useCases;

import entities.*;

public class BuyItemUC implements BuyItemInputBoundary{

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param itemName Name of the item the user wants to purchase
     */
    public void buyItem(User user, String itemName) {
        try {
            Pet pet = user.getPet();
            if (pet != null) {
                int cost = pet.equip(itemName);
                if (cost > 0) {
                    if (user.getPoints() >= cost) {
                        Item item = pet.getCustomizations().findItem(itemName);
                        item.Unlock();
                        user.losePoints(cost);
                        pet.equip(itemName);
                    }
                } else if (cost == -1) {
                    System.out.println("Item not in list");
                }
            }
        } catch (AbsentItemNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Another version of buyItem method
     * @param itemName Name of the item to purchase.
     */
    public void buyItem(String itemName){
        buyItem(UserUC.u(), itemName);
    }

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshItem() {
        new PetRefresher().refresh();
    }
}
