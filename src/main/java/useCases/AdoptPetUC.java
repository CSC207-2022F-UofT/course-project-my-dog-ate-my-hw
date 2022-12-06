package useCases;

import entities.Pet;
import ui.*;

import javax.swing.*;

public class AdoptPetUC{

    Pet pet;

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param skin a string representing the selected pet's type
     * @param petName the pet's name
     */
    public void adoptPet(String skin, String petName){
        pet = new Pet(petName, skin, null);
    }

    public Pet getPet() {
        return pet;
    }
}
