package useCases;

import entities.Pet;

import javax.swing.*;

public class AdoptPetUC implements AdoptPetInputBoundary{


    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param petIcon the image representing the selected pet
     * @param petName the pet's name
     */
    public void adoptPet(ImageIcon petIcon, String petName){
        User.u().setPet(new Pet(petName, petIcon, null));
    }

    public void refreshPet(){
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }
}
