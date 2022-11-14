package entities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ItemTest {

    @Test
    public void CreateItemDefaulTest() {
        Item item = new Item();
        Assertions.assertEquals(1, item.price);
        Assertions.assertFalse(item.unlocked);
    }

    @Test
    public void CreateItemNameAndPriceTest() {
        Item item = new Item("Name", 10);
        Assertions.assertEquals("Name", item.name);
        Assertions.assertEquals(10, item.price);
        Assertions.assertFalse(item.unlocked);
    }

    @Test
    public void CreateItemNameAndPriceAndUnlockedTest() {
        Item item = new Item("Name", 10, true);
        Assertions.assertEquals("Name", item.name);
        Assertions.assertEquals(10, item.price);
        Assertions.assertTrue(item.unlocked);
    }

    @Test
    public void CreateItemNameAndPriceAndTypeTest() {
        Item item = new Item("Hat", "Name", 10);
        Assertions.assertEquals("Hat", item.type);
        Assertions.assertEquals("Name", item.name);
        Assertions.assertEquals(10, item.price);
        Assertions.assertFalse(item.unlocked);
    }

    @Test
    public void CreateItemNameAndPriceAndTypeAndUnlockedTest() {
        Item item = new Item("Hat", "Name", 10, true);
        Assertions.assertEquals("Hat", item.type);
        Assertions.assertEquals("Name", item.name);
        Assertions.assertEquals(10, item.price);
        Assertions.assertTrue(item.unlocked);
    }

    @Test
    public void CreateItemNameAndPriceAndTypeAndUnlockedAndIconTest() {
        ImageIcon icon = new ImageIcon();
        Item item = new Item("Hat", "Name", 10, icon, true);
        Assertions.assertEquals("Hat", item.type);
        Assertions.assertEquals("Name", item.name);
        Assertions.assertEquals(10, item.price);
        Assertions.assertEquals(icon, item.icon);
        Assertions.assertTrue(item.unlocked);
    }

    @Test
    public void UnlockTest() {
        Item item = new Item();
        item.Unlock();
        Assertions.assertTrue(item.unlocked);
    }

    @Test
    public void LockTest() {
        Item item = new Item();
        item.Unlock();
        item.Lock();
        Assertions.assertFalse(item.unlocked);
    }

    @Test
    public void SetTypeTest() {
        Item item = new Item();
        item.setType("Hat");
        Assertions.assertEquals("Hat", item.type);
    }

    @Test
    public void SetNameTest() {
        Item item = new Item();
        item.setName("Name");
        Assertions.assertEquals("Name", item.name);
    }

    @Test
    public void SetPriceTest() {
        Item item = new Item();
        item.setPrice(10);
        Assertions.assertEquals(10, item.price);
    }

    @Test
    public void SetIconTest() {
        Item item = new Item();
        ImageIcon icon = new ImageIcon();
        item.setIcon(icon);
        Assertions.assertEquals(icon, item.icon);
    }
}
