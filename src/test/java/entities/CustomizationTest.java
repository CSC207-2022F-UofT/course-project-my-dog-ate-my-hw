package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomizationTest {

    // create a customization object with a single unlocked item and verify that
    // the current equipment is item and is currently equipped, check that
    // possible customizations contains the item
    @Test
    public void CustomizationTestBasic(){
        Item item = new Item("hat", "cap", 5, true);
        Customization customization = new Customization(item);
        customization.addItem(item);
        Assertions.assertEquals(customization.current_equipment, item);
        Assertions.assertTrue(customization.is_currently_equipped);
        Assertions.assertTrue(customization.possibleCustomizations().contains(item));
    }
}
