package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for User entity.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class UserTest {

    User user;
    Pet pet;
    ToDoList toDo;
    DoneList done;
    @BeforeEach
    public void setUp() {
        pet = new Pet("alex", "zebra" );
        toDo = new ToDoList();
        done = new DoneList();
        user = new User(10, pet, toDo, done);
    }

    @Test
    public void ConstructorUserTest() {
        Assertions.assertEquals(user.getPoints(), 10);
        Assertions.assertEquals(user.getToDo(), toDo);
        Assertions.assertEquals(user.getDone(), done);
        Assertions.assertEquals(user.getPet(), pet);
    }

    /**
     * create a user and gain points, check that final point count is correct
     */
    @Test
    public void GainPointsTest() {
        user.gainPoints(5);
        Assertions.assertEquals(15, user.getPoints());
    }

    /** 
     * create a user and lose points, check that final point count is correct
     */
    @Test
    public void LosePointsTest() {
        Assertions.assertTrue(user.losePoints(5));
        Assertions.assertEquals(user.getPoints(), 5);
    }

    /**
     * check that user cannot lose more points than they have
     */
    @Test
    public void LoseMorePointsTest() {
        Assertions.assertFalse(user.losePoints(15));
        Assertions.assertEquals(10,user.getPoints());
    }

    @Test
    public void SetPetUserTest() {
        user.setPet(pet);
        Assertions.assertEquals(user.getPet(), pet);
    }
}
