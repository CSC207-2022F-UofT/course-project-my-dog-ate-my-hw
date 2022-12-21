package useCases.refreshers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.PetUIDS;
import useCases.interactors.UserUC;
import useCases.outputBoundaries.PetOutputBoundary;
import entities.User;
import entities.Pet;
import entities.ToDoList;
import entities.DoneList;

/**
 * Test for PetRefresher.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class PetRefresherTest {

    /**
     * Create a User, a FakeMainOutputBoundary, a FakePetOutputBoundary,
     * and make all necessary declarations, then, if refresh() works,
     * loadedPet should be set to true, and if the pet was converted correctly
     * then the name should remain the same.
     */
    @Test
    public void RefreshTest(){
        Pet pet = new Pet("name", "skin");
        User user = new User(1, pet, new ToDoList(), new DoneList());
        FakeMainOutputBoundary fakeMainOutputBoundary = new FakeMainOutputBoundary();
        FakePetOutputBoundary fakePetOutputBoundary = new FakePetOutputBoundary();
        fakeMainOutputBoundary.setPetOutputBoundary(fakePetOutputBoundary);
        UserUC.declare(user);
        UserUC.declareUI(fakeMainOutputBoundary);
        PetRefresher petRefresher = new PetRefresher();
        petRefresher.refresh();
        Assertions.assertTrue(fakePetOutputBoundary.loadedPet);
        Assertions.assertEquals("name", fakePetOutputBoundary.pet.name);
    }
}

/**
 * A FakePetOutputBoundary that stores whether loadPet has been run
 */
class FakePetOutputBoundary implements PetOutputBoundary {

    boolean loadedPet = false;
    PetUIDS pet;

    public void loadPet(PetUIDS pet) {
            this.pet = pet;
            loadedPet = true;
    }
}