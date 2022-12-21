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
    Customization custom2;

    //Value of the pet's maximum health used in testing the getMaxHealth method.
    public static final int currentPetMaxHealth = 10;

    @BeforeEach
    public void setUp() {
        custom = new Customization();
        custom2 = new Customization();
        pet = new Pet("alex", "zebra", custom);
    }

    /**
     * create a pet object and check that getters return proper values
     */
    @Test
    public void PetGettersTest() {
        Assertions.assertEquals("alex", pet.getName());
        Assertions.assertEquals(custom, pet.getCustomizations());
        Assertions.assertEquals(Pet.getMaxHealth(), pet.getCurrHealth());
    }

    @Test
    public void PetNameConstructorTest() {
        Pet pet1 = new Pet("alexis");
        Assertions.assertEquals(pet1.getName(), "alexis");
        Assertions.assertEquals(pet1.getSkin(), "");
        Assertions.assertEquals(pet1.getCurrHealth(), Pet.getMaxHealth());
        Assertions.assertArrayEquals(pet1.getCustomizations().toStringArray(),
                pet1.getDefaultEquipmentList().toStringArray());
    }

    @Test
    public void PetSkinConstructorTest() {
        Pet pet2 = new Pet("alexandra", "mottled");
        Assertions.assertEquals(pet2.getName(), "alexandra");
        Assertions.assertEquals(pet2.getSkin(), "mottled");
        Assertions.assertEquals(pet2.getCurrHealth(), Pet.getMaxHealth());
        Assertions.assertArrayEquals(pet2.getCustomizations().toStringArray(),
                pet2.getDefaultEquipmentList().toStringArray());
    }

    @Test
    public void PetCustomizationConstructorTest() {
        Assertions.assertEquals(pet.getName(), "alex");
        Assertions.assertEquals(pet.getSkin(), "zebra");
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
        Assertions.assertEquals(pet.getCustomizations(), custom);
    }

    @Test
    public void PetGetCurrentMaxHealthTest() {
        Assertions.assertEquals(Pet.getMaxHealth(), currentPetMaxHealth);
    }

    @Test
    public void PetSetCustomizationTest() {
        pet.setCustomization(custom2);
        Assertions.assertEquals(pet.getCustomizations(), custom2);
    }

    @Test
    public void PetGetAndSetCurrentHealthTest() {
        pet.setCurrHealth(20);
        Assertions.assertEquals(pet.getCurrHealth(), 20);
    }

    @Test
    public void GetDefaultCustomizationsListTest() {
        Item halo = new Item("Hat", "Halo", 1, false);
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
        pet.setCurrHealth(5);
        pet.heal(3);
        Assertions.assertEquals(8, pet.getCurrHealth());
    }

    @Test
    public void PetHealPastMaxTest() {
        pet.setCurrHealth(5);
        pet.heal(16);
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
    }

    @Test
    public void PetOuchZeroTest() {
        pet.ouch(15);
        Assertions.assertEquals(pet.getCurrHealth(), 0);
    }
}
