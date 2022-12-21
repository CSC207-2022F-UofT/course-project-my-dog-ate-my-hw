package useCases.interactors;

import entities.DoneList;
import entities.ToDoList;
import entities.User;
import entities.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BuyHeartUC interactor.
 * Coverage: 100% class, 50% methods, 86% lines.
 * The refreshPet method was not tested as it calls on the PetRefresher to perform the refresh of the UI.
 * The buyHeart method that takes in no arguments was not tested as the UserUC singleton is not declared until the main
 * of the program is running and that method calls on the tested buyHearts method.
 */
public class BuyHeartUCTest {

    /** Create a new pet and user
     * Set user points as 10, pet begins with 10 health
     * Remove 5 hearts
     * Then test BuyHeartUC.buyHeart() by buying 3 hearts
     * User should have 7 points (10 - 3 = 7)
     * Pet should have 8 hearts (5 + 3 = 8)
     */
    @Test
    public void BuyHeartTest() {
        Pet pet = new Pet("Name", "skin");
        User user = new User(10, pet, new ToDoList(), new DoneList());
        pet.ouch(5);
        BuyHeartUC uc = new BuyHeartUC();
        uc.buyHeart(user, 3);
        Assertions.assertEquals(user.getPoints(), 7);
        Assertions.assertEquals(pet.getCurrHealth(), 8);
    }

    @Test
    public void BuyHeartReviveTest() {
        Pet pet = new Pet("Name", "skin");
        pet.ouch(Pet.getMaxHealth());
        User user = new User(20, pet, new ToDoList(), new DoneList());
        pet.ouch(Pet.getMaxHealth());
        BuyHeartUC uc = new BuyHeartUC();
        uc.buyHeart(user, 10);
        Assertions.assertEquals(user.getPoints(), 0);
        Assertions.assertEquals(pet.getCurrHealth(), Pet.getMaxHealth());
    }
}
