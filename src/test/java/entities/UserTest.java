package entities;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

/**
 * Test cases for User entity
 * Mainly test gain points and lose points methods
 * Other properties (pet, checklists) will be tested in corresponding test classes
 */
public class UserTest {
    @Test
    public void CreateUserDefaultTest() {
        User user = new User();
        Assertions.assertEquals(0, user.getPoints());
    }

    @Test
    public void CreateUserPointsTest() {
        User user = new User(5);
        Assertions.assertEquals(5, user.getPoints());
    }

    @Test
    public void GainPointsTest() {
        User user = new User(3);
        user.GainPoints(5);
        Assertions.assertEquals(8, user.getPoints());
    }

    @Test
    public void LosePointsTest() {
        User user = new User(3);
        Assertions.assertTrue(user.LosePoints(1));
        Assertions.assertEquals(2,user.getPoints());
    }

    @Test
    public void LoseMorePointsTest() {
        User user = new User(3);
        Assertions.assertFalse(user.LosePoints(5));
        Assertions.assertEquals(3,user.getPoints());
    }

    @Test
    public void SetPointsTest() {
        User user = new User(3);
        user.setPoints(5);
        Assertions.assertEquals(5, user.getPoints());
    }
}
