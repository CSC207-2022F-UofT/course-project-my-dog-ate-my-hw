package useCases;

import entities.User;
import entities.Pet;
import entities.Customization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.swing.*;
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
<<<<<<< HEAD
        Pet pet = new Pet("Name");
=======
        Pet pet = new Pet("Name", null);
>>>>>>> e251dde278572c2f71be32fadd72fb45725fca51
        User user = new User(10, pet);
        pet.ouch(5);
        BuyHeartUC.buyHeart(user, 3);
        Assertions.assertEquals(user.getPoints(), 7);
        Assertions.assertEquals(pet.getCurrHealth(), 8);
    }
<<<<<<< HEAD
=======

>>>>>>> e251dde278572c2f71be32fadd72fb45725fca51
}
