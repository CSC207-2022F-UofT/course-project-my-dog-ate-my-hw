package useCases;
import entities.*;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
 * The remaining points should be 4
 * Equips Baseball Cap
 */
public class BuyItemUCTest {
    User user;
    Customization customization;
    Pet pet;
    Item item1;
    Item item2;
    Item item3;

    @BeforeEach
    public void Setup() {
        user = new User();
        customization = new Customization();
        pet = new Pet("dog", null);
        item1 = new Item("Hat", "Straw Hat", 3, false);
        item2 = new Item("Hat", "Cap", 5, false);
        item3 = new Item("Hat", "Baseball Cap", 1, true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user.setPoints(4);
        user.setPet(pet);
    }

    @Test
    public void BuyItemTest1() throws AbsentItemNameException {
        BuyItemUC.buyItem(user,"Straw Hat");
        Assertions.assertEquals(user.getPoints(), 1);

        Assertions.assertEquals(user.getPet().getCustomization().currentEquipment().getName(), "Straw Hat");
    }

    @Test
    public void BuyItemTest2() throws AbsentItemNameException {
        BuyItemUC.buyItem(user,"Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertFalse(user.getPet().getCustomization().isCurrentlyEquipped());
    }

    @Test
    public void BuyItemTest3() throws AbsentItemNameException {
        BuyItemUC.buyItem(user,"Baseball Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertEquals(user.getPet().getCustomization().currentEquipment().getName(), "Baseball Cap");
    }


}