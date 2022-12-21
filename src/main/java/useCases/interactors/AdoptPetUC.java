package useCases.interactors;

import entities.Pet;
import entities.User;
import useCases.inputBoundaries.AdoptPetInputBoundary;
import useCases.refreshers.PetRefresher;

public class AdoptPetUC implements AdoptPetInputBoundary {

    Pet pet;

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param skin a string representing the selected pet's type
     * @param petName the pet's name
     */
    public void adoptPet(User user, String skin, String petName){
        pet = new Pet(petName, skin);
        user.setPet(pet);
    }

    public void adoptPet(String skin, String petName){
        adoptPet(UserUC.u(), skin, petName);
    }

    public Pet getPet() {
        return pet;
    }

    public void refreshPet(){
        new PetRefresher().refresh();
    }
}
