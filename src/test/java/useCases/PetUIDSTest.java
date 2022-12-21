package useCases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the PetUIDS class.
 * Coverage: 100% class, 75% methods, 90% lines.
 * The static method getCurrentPet was not tested because it returns the pet of the UserUC singleton which is not
 * declared until the Main runs, and it calls on the tested non-static constructor but using the UserUC singleton
 * as an argument.
 */
public class PetUIDSTest {
    Pet pet;
    User user;
    Customization customization;
    Item item1;
    Item item2;
    Item item3;
    PetUIDS petUIDS;

    @BeforeEach
    public void Setup() {
        customization = new Customization();
        pet = new Pet("dog", null);
        item1 = new Item("Hat", "Straw Hat", 3, "", false);
        item2 = new Item("Hat", "Cap", 5, "", false);
        item3 = new Item("Hat", "Baseball Cap", 1, "", true);
        customization.addItem(item1);
        customization.addItem(item2);
        customization.addItem(item3);
        pet.setCustomization(customization);
        user = new User(4, pet, new ToDoList(), new DoneList());
    }

    /*
    Default tests that check the data stored in a Default PetUIDS
     */
    @Test
    public void DefaultTest1() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.currHealth, DefaultValueData.DEFAULT_HEALTH);
    }

    @Test
    public void DefaultTest2() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.MAX_HEALTH, DefaultValueData.DEFAULT_HEALTH);
    }

    @Test
    public void DefaultTest3() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.MAX_HEALTH, DefaultValueData.DEFAULT_HEALTH);
    }

    @Test
    public void DefaultTest4() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.points, DefaultValueData.DEFAULT_POINTS);
    }

    @Test
    public void DefaultTest5() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.name, DefaultValueData.DEFAULT_NAME);
    }

    @Test
    public void DefaultTest6() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.skin, DefaultValueData.DEFAULT_SKIN);
    }

    @Test
    public void DefaultTest7() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.currCustomization, DefaultValueData.DEFAULT_CURR_CUSTOM);
    }

    @Test
    public void DefaultTest8() {
        petUIDS = PetUIDS.makeDefaultPet();
        Assertions.assertEquals(petUIDS.customizations, DefaultValueData.DEFAULT_CUSTOMS);
    }

    /*
    Test the data stored in pet
     */
    @Test
    public void PetDSTest() {
        petUIDS = new PetUIDS(pet, user);
        Assertions.assertEquals(pet.getName(), petUIDS.name);
        Assertions.assertEquals(pet.getSkin(), petUIDS.skin);
        Assertions.assertEquals(pet.getCurrHealth(), petUIDS.currHealth);
        Assertions.assertEquals("Straw Hat(LOCKED)", petUIDS.customizations[0]);
    }

    /*
    Test data of null Pet and null User
     */
    @Test
    public void PetDSNullTest() {
        User nullUser = null;
        Pet nullPet = null;
        petUIDS = new PetUIDS(nullPet, nullUser);
        Assertions.assertEquals(petUIDS.currHealth, DefaultValueData.DEFAULT_HEALTH);
        Assertions.assertEquals(petUIDS.points, DefaultValueData.DEFAULT_POINTS);
    }

    @Test
    public void PetDSCustomizationNotNullTest() {
        pet.getCustomizations().equip(item3);
        PetUIDS petUIDS = new PetUIDS(pet, user);
        Assertions.assertEquals(petUIDS.currCustomization, item3.getName());
    }
}