package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetTest {

    /**
     * create a pet object and check that getters return proper values
     */
    @Test
    public void PetGettersTest(){
        Customization customization = new Customization();
        Pet pet = new Pet("name", "skin", customization);
        Assertions.assertEquals("name", pet.getName());
        Assertions.assertEquals(customization, pet.getCustomization());
        Assertions.assertEquals(Pet.getMaxHealth(), pet.getCurrHealth());
    }

    /**
     * create a pet, hurt it by 5 hearts, check that final health is 5 hearts
     */
    @Test
    public void PetHarmingTest(){
        Pet pet = new Pet("name", null);
        pet.ouch(5);
        Assertions.assertEquals(5, pet.getCurrHealth());
    }

    /**
     * create a pet, hurt it by 5 hearts, heal 3, check that final is 8
     */
    @Test
    public void PetHealingTest(){
        Pet pet = new Pet("name", null);
        pet.ouch(5);
        pet.heal(3);
        Assertions.assertEquals(8, pet.getCurrHealth());
    }
}
