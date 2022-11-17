package uiControllers;

import entities.Pet;
import useCases.AdoptPetUC;

import javax.swing.*;

public class PetShopUIController {

    Pet pet;

    /**
     * Calls the AdoptPetUC to create a Pet object from the given petIcon and petName.
     * @param petIcon the image representing the selected pet
     * @param petName the pet's name
     */
    public void performPetAdoption(ImageIcon petIcon, String petName){
        AdoptPetUC usecase = new AdoptPetUC();
        usecase.adoptPet(petIcon, petName);
        pet = usecase.getPet();
    }

    public Pet getPet() {
        return pet;
    }
}
