package useCases.interactors;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the AdoptPetUC.
 * Coverage: 100% class, 50% methods, 66% lines.
 * The refreshPet method was not tested as it calls on the PetRefresher class to perform the refresh method.
 * The adoptPet method that takes in two strings as an argument was not tested as the static UserUC singleton used in
 * that method is not declared when the main file is not running, and it calls on the adoptPet method tested below.
 */
public class AdoptPetUCTest {
    User user;
    AdoptPetUC adoptPetUC;

    /**
     * Intialize the user and adoptPetUC before each test
    **/
    @BeforeEach
    public void Setup() {
        user = new User(10, new Pet("alex", "zebra"), new ToDoList(), new DoneList());
        adoptPetUC = new AdoptPetUC();
    }

    /**
     * Test the adoptPet method by adopting a pet
     * Check if the name matches
     **/
    @Test
    public void adoptPetTest() {
        adoptPetUC.adoptPet(user, "Husky", "snow");
        Assertions.assertEquals(user.getPet().getName(), "snow");
    }

    /**
     * Test getPet method by adopting a pet
     **/
    @Test
    public void getPetTest() {
        adoptPetUC.adoptPet(user, "Husky", "bark");
        Assertions.assertEquals(adoptPetUC.getPet().getName(), "bark");
    }
}