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
    Customization custom2;

    @BeforeEach
    public void setUp() {
        item = new Item("hat", "cap", 5, true);
        item2 = new Item("crown", "princess", 2, false);
        custom = new Customization();
        custom2 = new Customization(item2);
    }

    @Test
    public void EmptyCustomizationConstructorTest() {
        Customization empty = new Customization();
        Assertions.assertNull(empty.getCurrentEquipment());
        Assertions.assertFalse(empty.getIsCurrentlyEquipped());
        Assertions.assertTrue(empty.getPossibleCustomizations().isEmpty());

    }

    @Test
    public void NonEmptyCustomizationConstructorTest() {
        Customization nonEmpty = new Customization(item);
        Assertions.assertEquals(nonEmpty.getCurrentEquipment(), item);
        Assertions.assertTrue(nonEmpty.getIsCurrentlyEquipped());
        Assertions.assertEquals(nonEmpty.getPossibleCustomizations().size(), 1);
        Assertions.assertEquals(nonEmpty.getPossibleCustomizations().get(0), item);
    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is item
     */
    @Test
    public void CurrentEquipmentTest() {
        Customization customization = new Customization(item);
        Assertions.assertEquals(customization.getCurrentEquipment(), item);
        Assertions.assertTrue(customization.getIsCurrentlyEquipped());
        Assertions.assertTrue(customization.getPossibleCustomizations().contains(item));
    }

    /**
     * create a customization object with a single unlocked item and verify that
     * the current equipment is currently equipped
     */
    @Test
    public void TestIsCurrentlyEquipped() {
        Customization customization = new Customization(item);
        Assertions.assertTrue(customization.getIsCurrentlyEquipped());
    }

    /**
     * Create a customization object with a single unlocked item and verify that
     * the current equipment is in possibleCustomizations
     */
    @Test
    public void PossibleCustomizationsTest() {
        Customization customization = new Customization(item);
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
        try {
            Assertions.assertEquals(custom2.getItem("princess"), item2);
        }
        catch (AbsentItemNameException ex) {
            Assertions.fail();
        }
    }

    @Test
    public void ToStringArrayCustomizationTest() {
        custom2.addItem(item);
        String[] expected = new String[2];
        expected[1] = "cap";
        expected[0] = "princess(LOCKED)";
        Assertions.assertArrayEquals(custom2.toStringArray(), expected);
    }

    @Test
    public void ToStringArrayEmptyCustomizationTest() {
        Assertions.assertArrayEquals(custom.toStringArray(), new String[0]);
    }
}