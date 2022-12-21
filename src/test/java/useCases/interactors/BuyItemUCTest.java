package useCases.interactors;

import entities.*;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for BuyItemUC
 * Coverage: 100% class, 33% methods, 90% lines.
 * The refreshPet method was not tested since it calls on the PetRefresher to perform the refresh.
 * The buyItem method that does not take in a user entity was not tested because it calls on the buyItem method using
 * the UserUC singleton as the user argument, and the UserUC singleton is not declared until Main is running.
 */
public class BuyItemUCTest {
    User user;
    Customization customization;
    Pet pet;
    Item item1;
    Item item2;
    Item item3;
    BuyItemUC uc;

    @BeforeEach
    public void Setup() {
        customization = new Customization();
        pet = new Pet("dog", null);
        item1 = new Item("Hat", "Straw Hat", 3, "", false);
        item2 = new Item("Hat", "Cap", 5, "", false);
        item3 = new Item("Hat", "Baseball Cap", 1, "", true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user = new User(4, pet, new ToDoList(), new DoneList());
        uc = new BuyItemUC();
    }

    @Test
    public void BuyItemTest1() {
        uc.buyItem(user,"Straw Hat");
        Assertions.assertEquals(user.getPoints(), 1);
        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment().getName(), "Straw Hat");
    }

    @Test
    public void BuyItemTest2() {
        uc.buyItem(user,"Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertFalse(user.getPet().getCustomizations().getIsCurrentlyEquipped());
    }

    @Test
    public void BuyItemTest3() {
        uc.buyItem(user,"Baseball Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment().getName(),
                "Baseball Cap");
    }

    @Test
    public void BuyItemTestDequipUnlocked() {
        user.getPet().getCustomizations().equip(item1);
        uc.buyItem(user, "Baseball Cap");
        Assertions.assertEquals(user.getPoints(), 4);
        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment(), item3);
    }

    @Test
    public void BuyItemTestDequipLocked() {
        user.getPet().getCustomizations().equip(item3);
        uc.buyItem(user, "Straw Hat");
        Assertions.assertEquals(user.getPoints(), 1);
        Assertions.assertEquals(user.getPet().getCustomizations().getCurrentEquipment(), item1);
    }

    @Test
    public void BuyItemNullPointerTest() {
        try {
            uc.buyItem(UserUC.u(), "Straw Hat");
            Assertions.fail();
        }
        catch (RuntimeException ex) {
            Assertions.assertTrue(ex.toString().contains("Something was null"));
        }
    }

    @Test
    public void BuyItemAbsentItemTest() {
        try {
            uc.buyItem(user, "Crown");
            Assertions.fail();
        }
        catch (RuntimeException ex) {
            Assertions.assertTrue(ex.toString().contains("Not in customization list"));
        }
    }
}
