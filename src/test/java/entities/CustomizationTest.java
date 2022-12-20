package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert;
import java.util.Arrays;

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
    public void TestEmptyCustomizationConstructor() {
        Customization empty = new Customization();
        Assertions.assertNull(empty.getCurrentEquipment());
        Assertions.assertFalse(empty.getIsCurrentlyEquipped());
        Assertions.assertTrue(empty.getPossibleCustomizations().isEmpty());

    }

    @Test
    public void TestNonEmptyCustomizationConstructor() {
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
    public void TestCurrentEquipment() {
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
    public void TestPossibleCustomizations() {
        Customization customization = new Customization(item);
        Assertions.assertTrue(customization.getPossibleCustomizations().contains(item));
    }

    @Test
    public void TestAddEmptyItemCustomization() {
        Assertions.assertTrue(custom.getPossibleCustomizations().isEmpty());
        custom.addEmptyItem();
        Assertions.assertEquals(custom.getPossibleCustomizations().size(), 1);
        Assertions.assertEquals(custom.getCurrentEquipment(), custom.NO_ITEM);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getPossibleCustomizations().get(custom.NO_ITEM_INDEX),
                custom.NO_ITEM);
    }

    @Test
    public void TestAddNonEmptyItemCustomization() {
        Assertions.assertTrue(custom.getPossibleCustomizations().isEmpty());
        custom.addItem(item);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getPossibleCustomizations().get(0), item);
        Assertions.assertEquals(custom.getPossibleCustomizations().size(), 1);
    }

    @Test
    public void TestEquipItemCustomization() {
        custom.equip(item);
        Assertions.assertTrue(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), item);
    }

    @Test
    public void TestEquipEmptyItemCustomization() {
        custom.equip(custom.NO_ITEM);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), custom.NO_ITEM);
    }

    @Test
    public void TestEquipItemLockedCustomization() {
        custom.equip(item2);
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
    }

    @Test
    public void TestDequipItemCustomization() {
        custom.equip(item);
        custom.dequip();
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
        Assertions.assertEquals(custom.getCurrentEquipment(), custom.NO_ITEM);
    }

    @Test
    public void TestDequipNoItemCustomization() {
        custom.dequip();
        Assertions.assertFalse(custom.getIsCurrentlyEquipped());
    }

    @Test
    public void TestGetItemNoItemCustomization() {
        try {
            custom.getItem("NonExistentItem");

            Assert.fail();
        } catch (AbsentItemNameException ex) {
            Assertions.assertEquals("entities.AbsentItemNameException", ex.toString());
        }
    }

    @Test
    public void TestGetItemCustomization() {
        try {
            Assertions.assertEquals(custom2.getItem("princess"), item2);
        }
        catch (AbsentItemNameException ex) {
            Assert.fail();
        }
    }

    @Test
    public void TestToStringArrayCustomization() {
        custom2.addItem(item);
        String[] expected = new String[2];
        expected[1] = "cap";
        expected[0] = "princess(LOCKED)";
        Assertions.assertTrue(Arrays.equals(custom2.toStringArray(), expected));
    }

    @Test
    public void TestToStringArrayEmptyCustomization() {
        Assertions.assertTrue(Arrays.equals(custom.toStringArray(), new String[0]));
    }
}