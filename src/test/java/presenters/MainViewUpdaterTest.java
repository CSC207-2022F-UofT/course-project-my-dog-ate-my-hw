package presenters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testing the MainViewUpdater class.
 * N.B. There is no dependency injection for this test, since there is nothing to set.
 * Code coverage for the MainViewUpdater class: 100% class, 100% methods, 100% lines
 */
public class MainViewUpdaterTest {

    /**
     * Test that getPetUpdater() correctly returns an instance of the PetUpdater class
     */
    @Test
    public void GetPetUpdaterTest(){
        MainViewUpdater mainViewUpdater = new MainViewUpdater();
        Assertions.assertInstanceOf(PetUpdater.class, mainViewUpdater.getPetUpdater());
    }

    /**
     * Test that getPetOutputBoundary() correctly returns an instance of the PetUpdater class
     */
    @Test
    public void GetPetOutputBoundaryTest(){
        MainViewUpdater mainViewUpdater = new MainViewUpdater();
        Assertions.assertInstanceOf(PetUpdater.class, mainViewUpdater.getPetOutputBoundary());
    }

    /**
     * Test that getTasklistOutputBoundary() correctly returns an instance of the TasklistUpdater class
     */
    @Test
    public void GetTasklistUpdaterTest(){
        MainViewUpdater mainViewUpdater = new MainViewUpdater();
        Assertions.assertInstanceOf(TasklistUpdater.class, mainViewUpdater.getTasklistOutputBoundary());
    }

}