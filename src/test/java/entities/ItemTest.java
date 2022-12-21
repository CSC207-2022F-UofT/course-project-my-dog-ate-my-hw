package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Item Entity class.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class ItemTest {

    /**
     * create a default item
     */

    @Test
    public void CreateItemIconTest() {
        Item item3 = new Item("headpiece", "crown", 3, "picture", false);
        Assertions.assertEquals(item3.getIcon(), "picture");
    }

    /**
     * create an unlocked item with a type, name, and price
     */
    @Test
    public void CreateItemNameAndPriceAndTypeAndUnlockedTest() {
        Item item = new Item("Hat", "Name", 10, "icon", true);
        Assertions.assertEquals("Hat", item.getType());
        Assertions.assertEquals("Name", item.getName());
        Assertions.assertEquals(10, item.getPrice());
        Assertions.assertTrue(item.isUnlocked());
    }

    /**
     * create an unlocked item and check whether item.isUnlocked returns true
     */
    @Test
    public void UnlockTest() {
        Item item = new Item("hat", "crown", 10, "icon", false);
        item.setUnlocked(true);
        Assertions.assertTrue(item.isUnlocked());
    }

    /**
     * create an unlocked item and then lock it, check whether item.isUnlocked returns false
     */
    @Test
    public void LockTest() {
        Item item = new Item("hat", "crowness", 10, "icon", true);
        item.setUnlocked(false);
        Assertions.assertFalse(item.isUnlocked());
    }
}
