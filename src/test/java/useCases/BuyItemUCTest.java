package useCases;
import entities.Customization;
import entities.Item;
import entities.Pet;
import entities.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for BuyItemUC
 * First Test: Try to buy the hat "Straw Hat" with price 3 and points 4
 * The remaining points should be 1
 * Customization should have equipped item
 * Equips Straw Hat
 * Second Test: Try to buy the hat "Cap" with price too high
 * The purchase should be unsuccessful
 * Third Test: Try to buy the hat "Baseball Cap" which is already unlocked
 * The remaining points should be 1
 * Equips Baseball Cap
 */
public class BuyItemUCTest {
    @Test
    public void BuyItemTest() {
        User user = new User();
        Customization customization = new Customization();
        Pet pet = new Pet("dog");
        Item item1 = new Item("Hat", "Straw Hat", 3, false);
        Item item2 = new Item("Hat", "Cap", 5, false);
        Item item3 = new Item("Hat", "Baseball Cap", 1, true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user.setPoints(4);
        user.setPet(pet);
        BuyItemUC.buyItem(user,"Straw Hat");
        Assertions.assertEquals(user.getPoints(), 1);
        Assertions.assertTrue(user.getPet().getCustomization().isCurrentlyEquipped());
        Assertions.assertEquals(user.getPet().getCustomization().currentEquipment().getName(), "Straw Hat");
        BuyItemUC.buyItem(user,"Cap");
        Assertions.assertEquals(user.getPoints(), 1);
        Assertions.assertEquals(user.getPet().getCustomization().currentEquipment().getName(), "Straw Hat");
        BuyItemUC.buyItem(user,"Baseball Cap");
        Assertions.assertEquals(user.getPoints(), 1);
        Assertions.assertEquals(user.getPet().getCustomization().currentEquipment().getName(), "Baseball Cap");
    }
}
