package useCases;

import entities.Item;
import entities.Customization;

public class BuyItemUC implements BuyItemInputBoundary{

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param itemName Name of the item the user wants to purchase
     */
    public static void buyItem(entities.User user, String itemName){
        Customization customization = user.getPet().getCustomization();
        Item item = customization.getItem(itemName);

        if (user.getPoints() >= item.getPrice() && !item.isUnlocked()) {
            user.LosePoints(item.getPrice());
            item.Unlock();
            if (!customization.isCurrentlyEquipped()){
                customization.equip(item);
            }
            else {
                customization.dequip();
                customization.equip(item);
            }
        }
        else if (item.isUnlocked()) {
            if (!customization.isCurrentlyEquipped()){
                customization.equip(item);
            }
            else {
                customization.dequip();
                customization.equip(item);
            }
        }
    }

    /**
     * Another version of buyItem method
     * @param itemName Name of the item to purchase.
     */
    public static void buyItem(String itemName) {buyItem(User.u(), itemName);}

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshItem() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }
}
