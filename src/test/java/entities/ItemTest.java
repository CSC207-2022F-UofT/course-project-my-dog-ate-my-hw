package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void CreateItemDefaulTest() {
        Item item = new Item();
        Assertions.assertEquals(1, item.getPrice());
        Assertions.assertFalse(item.isUnlocked());
    }

    @Test
    public void CreateItemNameAndPriceAndTypeAndUnlockedTest() {
        Item item = new Item("Hat", "Name", 10, true);
        Assertions.assertEquals("Hat", item.getType());
        Assertions.assertEquals("Name", item.getName());
        Assertions.assertEquals(10, item.getPrice());
        Assertions.assertTrue(item.isUnlocked());
    }

    @Test
    public void UnlockTest() {
        Item item = new Item();
        item.Unlock();
        Assertions.assertTrue(item.isUnlocked());
    }

    @Test
    public void LockTest() {
        Item item = new Item();
        item.Unlock();
        item.Lock();
        Assertions.assertFalse(item.isUnlocked());
    }

    @Test
    public void SetTypeTest() {
        Item item = new Item();
        item.setType("Hat");
        Assertions.assertEquals("Hat", item.getType());
    }

    @Test
    public void SetNameTest() {
        Item item = new Item();
        item.setName("Name");
        Assertions.assertEquals("Name", item.getName());
    }

    @Test
    public void SetPriceTest() {
        Item item = new Item();
        item.setPrice(10);
        Assertions.assertEquals(10, item.getPrice());
    }
}
