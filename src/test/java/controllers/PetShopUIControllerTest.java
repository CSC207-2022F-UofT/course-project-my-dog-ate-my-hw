package controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.inputBoundaries.AdoptPetInputBoundary;

/**
 * Testing the PetShopUIControllerTest class.
 * Code coverage for the BuyHeartController class: 100% class, 100% methods, 100% lines
 */
public class PetShopUIControllerTest {

    /**
     * Sets the test conditions by injecting the dependency of the PetShopUIController with a AdoptPetInputBoundary.
     * @param uc the AdoptPetInputBoundary for the controller to use
     */
    public void setTestConditions(AdoptPetInputBoundary uc){
        PetShopUIController.setUc(uc);
    }

    /**
     * Test of the preformPetAdoption method of the PetShopUIController.
     */
    @Test
    public void PreformPetAdoptionTest(){
        FakeAdoptPetUC uc = new FakeAdoptPetUC();
        setTestConditions(uc);

        String petName = "asdfasdf";
        String skin = "skin";

        PetShopUIController controller = new PetShopUIController();
        controller.performPetAdoption(skin, petName);

        Assertions.assertEquals(petName, uc.petName);
        Assertions.assertEquals(skin, uc.skin);
        Assertions.assertTrue(uc.refreshPetRan);
    }
}


/**
 * An implementation of the AdoptPetInputBoundary that stores the specific methods
 * that have been run and the values they were run with.
 */
class FakeAdoptPetUC implements AdoptPetInputBoundary{

    public String skin;
    public String petName;
    public boolean refreshPetRan = false;

    @Override
    public void adoptPet(String skin, String petName) {
        this.skin = skin;
        this.petName = petName;
    }

    public void refreshPet() {
        refreshPetRan = true;
    }
}
