package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomizationTest {

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
