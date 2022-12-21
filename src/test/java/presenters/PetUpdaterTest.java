package presenters;

import entities.DoneList;
import entities.ToDoList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.PetUIDS;
import entities.Pet;
import entities.User;

/**
 * Testing the PetUpdater class.
 * Code coverage for the PetUpdater class: 100% class, 100% methods, 100% lines
 */
public class PetUpdaterTest {

    Pet pet;
    User user;
    PetUIDS petUIDS;
    FakeViewRefresher fakeViewRefresher;

    /**
     * Test for setViewRefresher() and loadPet()
     * If loadPet() works successfully, then setViewRefresher must necessarily work
     * We know that loadPet() works successfully if the fakeViewRefresher successfully
     * refreshes the pet, thus setting refreshedPet to true
     */
    @Test
    public void SetViewRefresherAndLoadPetTest(){
        pet = new Pet("name", "skin");
        user = new User(1, pet, new ToDoList(), new DoneList());
        fakeViewRefresher = new FakeViewRefresher();
        petUIDS = new PetUIDS(pet, user);
        PetUpdater petUpdater = new PetUpdater();
        PetUpdater.setViewRefresher(fakeViewRefresher);
        petUpdater.loadPet(petUIDS);
        Assertions.assertTrue(fakeViewRefresher.refreshedPet);
    }
}

/**
 * An imitator of the ViewRefresher that stores whether the pet was successfully refreshed
 * Used in PetUpdaterTest and TasklistUpdaterTest
 */
class FakeViewRefresher implements ViewRefresherBoundary {

    public PetVM pet;
    public TaskVM[] tasks;
    public TaskVM convertedTask;
    public boolean refreshedPet = false;
    public boolean refreshedTasks = false;

    public void refresh(PetVM pet, TaskVM[] tasks) {
        this.pet = pet;
        this.tasks = tasks;
    }

    public void refresh(TaskVM[] tasks) {
        this.convertedTask = tasks[0];
        this.tasks = tasks;
        this.refreshedTasks = true;
    }

    public void refresh(PetVM pet) {
        this.pet = pet;
        this.refreshedPet = true;
    }
}