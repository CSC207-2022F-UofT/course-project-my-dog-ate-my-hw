package useCases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuyHatUCTest {

    /** Create a new pet, user, and hat
     * Set user points as 10 and hat price as 7
     * Then test BuyHatUC.buyHat() by buying purchasing the hat
     * User should have 3 points (10 - 7 = 3)
     * The hat should be successfully equipped on the pet
     */

    @Test
    public void BuyHatTest() {
        Pet pet = new Pet("Name", null);
        User user = new User(10, pet);
        Item hat = new Item("Hat", 7);
        BuyHatUC.buyHat(user, hat);
        Assertions.assertEquals(user.getPoints(), 3);
        Assertions.assertSame(pet.getCustomization().current_equipment, hat);
    }
}
