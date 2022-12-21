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
        customization = new Customization();
        pet = new Pet("dog", "skin");
        item1 = new Item("Hat", "Straw Hat", 3, "", false);
        item2 = new Item("Hat", "Cap", 5, "", false);
        item3 = new Item("Hat", "Baseball Cap", 1, "", true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user = new User(10, pet, new ToDoList(), new DoneList());
    }

    @Test
    public void BuyItemTest1() {
        BuyItemUC buyItemUC = new BuyItemUC();
        buyItemUC.buyItem(user,"Straw Hat");
        Assertions.assertEquals(user.getPoints(), 1);

        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment().getName(), "Straw Hat");
    }

    @Test
    public void BuyItemTest2() {
        BuyItemUC buyItemUC = new BuyItemUC();
        buyItemUC.buyItem(user,"Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertFalse(user.getPet().getCustomizations().getIsCurrentlyEquipped());
    }

    @Test
    public void BuyItemTest3() {
        BuyItemUC buyItemUC = new BuyItemUC();
        buyItemUC.buyItem(user,"Baseball Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment().getName(), "Baseball Cap");
    }


}
