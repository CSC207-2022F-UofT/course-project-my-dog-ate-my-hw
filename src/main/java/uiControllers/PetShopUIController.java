package uiControllers;

import entities.Pet;
import useCases.AdoptPetUC;

public class PetShopUIController {

    Pet pet;

    /**
     * Calls the AdoptPetUC to create a Pet object from the given petIcon and petName.
     * @param petIcon the string representing the icon
     * @param petName the pet's name
     */
    public void performPetAdoption(String petName, String petIcon){
        AdoptPetUC usecase = new AdoptPetUC();
        usecase.adoptPet(petName, petIcon);
        pet = usecase.getPet();
    }

    public Pet getPet() {
        return pet;
    }
}
