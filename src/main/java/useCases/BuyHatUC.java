package useCases;

import entities.Item;
import entities.User;
import entities.Customization;

public class BuyHatUC {

    /**
     * Allows the user to buy a hat and updates their points and pet accordingly.
     * @param user the User's name
     * @param hat the Hat the user wants to purchase
     */
    public static void buyHat(User user, Item hat){
        Customization customization = user.getPet().getCustomization();

        if (user.getPoints() >= hat.getPrice() && !hat.isUnlocked()) {
            user.LosePoints(hat.getPrice());
        }
        if (!customization.isCurrentlyEquipped()){
            if (!hat.isUnlocked()) {
                hat.Unlock();
                customization.equip(hat);
            }
            else {
                customization.equip(hat);
                }
        } else if (!hat.isUnlocked()) {
            hat.Unlock();
            customization.dequip();
            customization.equip(hat);
        }
        else {
            customization.dequip();
            customization.equip(hat);
        }
    }
}
