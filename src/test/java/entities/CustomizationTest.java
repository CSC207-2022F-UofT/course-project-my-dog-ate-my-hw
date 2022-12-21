package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CustomizationTest {
    /**
     * JUnit tests for the customization entity class.
     * Coverage: 100% class, 100% methods, 100% lines
     */

    Item item;
    Item item2;
    Customization custom;

    @BeforeEach
    public void setUp() {
        item = new Item("hat", "cap", 5, "", true);
        item2 = new Item("crown", "princess", 2, "", false);
        custom = new Customization();
    }

    @Test
    public void EmptyCustomizationConstructorTest() {
        Customization empty = new Customization();
        Assertions.assertNull(empty.getCurrentEquipment());
        Assertions.assertFalse(empty.getIsCurrentlyEquipped());
        Assertions.assertTrue(empty.getPossibleCustomizations().isEmpty());

    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is item
     */
    @Test
    public void CurrentEquipmentTest() {
        Customization customization = new Customization();
        customization.addItem(item);
        customization.equip(item);
        Assertions.assertEquals(customization.getCurrentEquipment(), item);
        Assertions.assertTrue(customization.getIsCurrentlyEquipped());
        Assertions.assertTrue(customization.getPossibleCustomizations().contains(item));
    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is currently equipped
     */
    @Test
    public void IsCurrentlyEquippedTest() {
        Customization customization = new Customization();
        customization.addItem(item);
        Assertions.assertFalse(customization.getIsCurrentlyEquipped());
    }

    /**
     * Create a customization object with a single unlocked item and verify that
     * the current equipment is in possibleCustomizations
     */
    @Test
    public void PossibleCustomizationsTest() {
        Customization customization = new Customization();
        customization.addItem(item);
        Assertions.assertTrue(customization.getPossibleCustomizations().contains(item));
    }

    @Test
    public void AddEmptyItemCustomizationTest() {
        Assertions.assertTrue(custom.getPossibleCustomizations().isEmpty());
        custom.addEmptyItem();
        Assertions.assertEquals(custom.getPossibleCustomizations().size(), 1);
        Assertions.assertEquals(custom.getCurrentEquipment(), Customization.NO_ITEM);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getPossibleCustomizations().get(Customization.NO_ITEM_INDEX),
                Customization.NO_ITEM);
    }

    @Test
    public void AddNonEmptyItemCustomizationTest() {
        Assertions.assertTrue(custom.getPossibleCustomizations().isEmpty());
        custom.addItem(item);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getPossibleCustomizations().get(0), item);
        Assertions.assertEquals(custom.getPossibleCustomizations().size(), 1);
    }

    @Test
    public void EquipItemCustomizationTest() {
        custom.equip(item);
        Assertions.assertTrue(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), item);
    }

    @Test
    public void EquipEmptyItemCustomizationTest() {
        custom.equip(Customization.NO_ITEM);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), Customization.NO_ITEM);
    }

    @Test
    public void EquipItemLockedCustomizationTest() {
        custom.equip(item2);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
    }

    @Test
    public void DequipItemCustomizationTest() {
        custom.equip(item);
        custom.dequip();
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), Customization.NO_ITEM);
    }

    @Test
    public void DequipNoItemCustomizationTest() {
        custom.dequip();
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
    }

    @Test
    public void GetItemNoItemCustomizationTest() {
        try {
            custom.getItem("NonExistentItem");
            Assertions.fail();
        } catch (AbsentItemNameException ex) {
            Assertions.assertEquals("entities.AbsentItemNameException", ex.toString());
        }
    }

    @Test
    public void GetItemCustomizationTest() {
        custom.addItem(item2);
        try {
            Assertions.assertEquals(custom.getItem("princess"), item2);
        }
        catch (AbsentItemNameException ex) {
            Assertions.fail();
        }
    }

    @Test
    public void ToStringArrayCustomizationTest() {
        custom.addItem(item);
        custom.addItem(item2);
        String[] expected = new String[2];
        expected[0] = "cap";
        expected[1] = "princess(LOCKED)";
        Assertions.assertArrayEquals(custom.toStringArray(), expected);
    }

    @Test
    public void ToStringArrayEmptyCustomizationTest() {
        Assertions.assertArrayEquals(custom.toStringArray(), new String[0]);
    }
}