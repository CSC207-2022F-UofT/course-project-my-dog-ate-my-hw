package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests for the Pet entity class.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class PetTest {

    Pet pet;
    Customization custom;

    //Value of the pet's maximum health used in testing the getMaxHealth method.
    public static final int currentPetMaxHealth = 10;

    @BeforeEach
    public void setUp() {
        custom = new Customization();
        pet = new Pet("alex", "zebra");
    }

    @Test
    public void PetNameConstructorTest() {
        Assertions.assertEquals(pet.getName(), "alex");
        Assertions.assertEquals(pet.getSkin(), "zebra");
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
        Assertions.assertArrayEquals(pet.getCustomizations().toStringArray(),
                pet.getDefaultEquipmentList().toStringArray());
    }

    @Test
    public void PetGetCurrentMaxHealthTest() {
        Assertions.assertEquals(Pet.getMaxHealth(), currentPetMaxHealth);
    }

    @Test
    public void PetSetCustomizationTest() {
        pet.setCustomization(custom);
        Assertions.assertEquals(pet.getCustomizations(), custom);
    }

    @Test
    public void GetDefaultCustomizationsListTest() {
        Item halo = new Item("Hat", "Halo", 1, "", false);
        custom.addEmptyItem();
        custom.addItem(halo);
        Assertions.assertArrayEquals(pet.getDefaultEquipmentList().toStringArray(),
                custom.toStringArray());
    }

    /**
     * create a pet, hurt it by 5 hearts, check that final health is 5 hearts
     */
    @Test
    public void PetHarmingTest() {
        pet.ouch(5);
        Assertions.assertEquals(5, pet.getCurrHealth());
    }

    /**
     * create a pet, hurt it by 5 hearts, heal 3, check that final is 8
     */
    @Test
    public void PetHealingTest() {
        pet.ouch(5);
        pet.heal(3);
        Assertions.assertEquals(8, pet.getCurrHealth());
    }

    @Test
    public void PetHealPastMaxTest() {
        pet.heal(16);
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
    }

    @Test
    public void PetOuchZeroTest() {
        pet.ouch(15);
        Assertions.assertEquals(pet.getCurrHealth(), 0);
    }

    @Test
    public void PetHealToFullTest() {
        pet.healToFull();
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
    }
}
