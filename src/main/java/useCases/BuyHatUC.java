package useCases;

import entities.Hat;
import entities.Item;
import entities.Pet;
import entities.User;
import entities.Customization;

public class BuyHatUC {

    Hat hat;

    /**
     * Allows the user ot buy a hat and updates their points and pet accordingly.
     * @param user the User's name
     * @param hat the Hat the user wants to purchase
     */
    public void buyHat(User user, Item hat){
        Pet pet = user.getPet();

        if (user.getPoints() >= hat.price) {
            user.LosePoints(hat.price);
        }
        if Customization.customizations.







    }
}
