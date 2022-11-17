package uiControllers;

import entities.Pet;

import javax.swing.*;

public class PetShopUIController {

    Pet pet;

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param petIcon the image representing the selected pet
     * @param petName the pet's name
     */
    public void adoptPet(ImageIcon petIcon, String petName){
        pet = new Pet(petName, petIcon);
    }

    public Pet getPet() {
        return pet;
    }
}
