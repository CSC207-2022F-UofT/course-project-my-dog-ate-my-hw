package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomizationTest {

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is item
     */
    @Test
    public void TestCurrentEquipment(){
        Item item = new Item("hat", "cap", 5, true);
        Customization customization = new Customization(item);
        customization.addItem(item);
        Assertions.assertEquals(customization.currentEquipment, item);
        Assertions.assertTrue(customization.isCurrentlyEquipped);
        Assertions.assertTrue(customization.possibleCustomizations().contains(item));
    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is currently equipped
     */
    @Test
    public void TestIsCurrentlyEquipped(){
        Item item = new Item("hat", "cap", 5, true);
        Customization customization = new Customization(item);
        customization.addItem(item);
        Assertions.assertTrue(customization.isCurrentlyEquipped);
    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is in possibleCustomizations
     */
    @Test
    public void TestPossibleCustomizations(){
        Item item = new Item("hat", "cap", 5, true);
        Customization customization = new Customization(item);
        customization.addItem(item);
        Assertions.assertTrue(customization.possibleCustomizations().contains(item));
    }

}
