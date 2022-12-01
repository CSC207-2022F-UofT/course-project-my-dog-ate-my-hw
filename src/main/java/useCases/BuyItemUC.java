package useCases;

import entities.Item;
import entities.User;
import entities.Customization;

public class BuyItemUC {

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param item the item the user wants to purchase
     */
    public static void buyItem(User user, Item item){
        Customization customization = user.getPet().getCustomization();

        int price = item.getPrice();
        boolean unlocked = item.isUnlocked();

        if (user.getPoints() >= price && !unlocked) {
            user.LosePoints(price);
        }
        if (!customization.isCurrentlyEquipped()){
            if (unlocked) {
                item.setUnlocked(true);
                customization.equip(item);
            }
        } else if (unlocked) {
            item.setUnlocked(true);
            customization.dequip();
            customization.equip(item);
        }
        else {
            customization.dequip();
            customization.equip(item);
        }
    }
}
