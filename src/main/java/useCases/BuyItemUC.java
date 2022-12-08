package useCases;

import entities.AbsentItemNameException;
import entities.Item;
import entities.Customization;
import entities.User;

public class BuyItemUC implements BuyItemInputBoundary{

    /**
     * Allows the user to buy an item and updates their points and pet accordingly.
     * @param user the User's name
     * @param itemName Name of the item the user wants to purchase
     */
    public static void buyItem(User user, String itemName) throws AbsentItemNameException {
        try {
            Customization customization = user.getPet().getCustomization();
            Item item = customization.getItem(itemName);

            if (user.getPoints() >= item.getPrice() && !item.isUnlocked()) {
                user.LosePoints(item.getPrice());
                item.setUnlocked(true);
                if (!customization.isCurrentlyEquipped()) {
                    customization.equip(item);
                } else {
                    customization.dequip();
                    customization.equip(item);
                }
            } else if (item.isUnlocked()) {
                if (!customization.isCurrentlyEquipped()) {
                    customization.equip(item);
                } else {
                    customization.dequip();
                    customization.equip(item);
                }
            }
        }catch (AbsentItemNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Another version of buyItem method
     * @param itemName Name of the item to purchase.
     */
    public static void buyItem(String itemName) throws AbsentItemNameException {buyItem(UserUC.u(), itemName);}

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshItem() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }
}
