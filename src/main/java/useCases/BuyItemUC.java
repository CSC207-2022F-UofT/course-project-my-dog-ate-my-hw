package useCases;

import entities.Item;
import entities.Customization;

public class BuyItemUC {

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param item the item the user wants to purchase
     */
    public static void buyItem(entities.User user, Item item){
        Customization customization = user.getPet().getCustomization();

        if (user.getPoints() >= item.getPrice() && !item.isUnlocked()) {
            user.LosePoints(item.getPrice());
        }
        if (!customization.isCurrentlyEquipped()){
            if (!item.isUnlocked()) {
                item.Unlock();
                customization.equip(item);
            }
            else {
                customization.equip(item);
                }
        } else if (!item.isUnlocked()) {
            item.Unlock();
            customization.dequip();
            customization.equip(item);
        }
        else {
            customization.dequip();
            customization.equip(item);
        }
    }

    /**
     * Another version of buyItem method
     * @param item the item to purchase
     */
    public static void buyItem(Item item) {buyItem(User.u(), item);}


}
