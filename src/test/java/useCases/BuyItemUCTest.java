package useCases;

import entities.*;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuyItemUCTest {

    /** Create a new pet, user, and hat
     * Set user points as 10 and hat price as 7
     * Then test BuyItemUC.buyItem() by buying purchasing the hat
     * User should have 3 points (10 - 7 = 3)
     * The hat should be successfully equipped on the pet
     */
    @Test
    public void BuyItemUCTestBasic() {
        Pet pet = new Pet("Name");
        User user = new User(10, pet);
        Item hat = new Item("Hat", "hat", 7, true);
        BuyItemUC.buyItem(user, hat);
        Assertions.assertEquals(user.getPoints(), 3);
        Assertions.assertSame(pet.getCustomization().current_equipment, hat);
    }
}
