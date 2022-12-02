package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetTest {

    // create a pet object and check that getters return proper values
    @Test
    public void PetGettersTest(){
        Item item = new Item("hat", "yankee", 5, true);
        Customization customization = new Customization(item);

        Pet pet = new Pet("name", customization);

        Assertions.assertEquals("name", pet.getName());
        Assertions.assertEquals(customization, pet.getCustomization());
        Assertions.assertEquals(Pet.getMaxHealth(), pet.getCurrHealth());
    }

    // create a pet, hurt it and heal it, check that final health is correct
    @Test
    public void PetHealingTest(){
        Item item = new Item("hat", "yankee", 5, true);
        Customization customization = new Customization(item);

        Pet pet = new Pet("name", customization);

        // pet has 10 health
        // (10 - 5) + 3 = 8
        // final health should be 8
        pet.ouch(5);
        pet.heal(3);

        Assertions.assertEquals(8, pet.getCurrHealth());
    }
}
