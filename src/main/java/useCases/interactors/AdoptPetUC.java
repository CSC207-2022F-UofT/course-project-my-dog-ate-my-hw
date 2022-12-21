package useCases.interactors;

import entities.Pet;
import entities.User;
import useCases.inputBoundaries.AdoptPetInputBoundary;
import useCases.refreshers.PetRefresher;

/**
 * Use case interactor class for the use case of adopting a pet. The user may adopt a pet that they become responsible
 * for. Their pet will lose or gain health depending on the user's To-Do list and points.
 */
public class AdoptPetUC implements AdoptPetInputBoundary {

    // The pet to be adopted by the user
    public Pet pet;

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param user the user that adopts the pet
     * @param skin a string representing the selected pet's type
     * @param petName the pet's name
     */
    public void adoptPet(User user, String skin, String petName){
        pet = new Pet(petName, skin);
        user.setPet(pet);
    }

    /**
     * Allow the User singleton to adopt a pet.
     * @param skin : a string representation of this pet's skin
     * @param petName : a string representation of this pet's name
     */
    public void adoptPet(String skin, String petName){
        adoptPet(UserUC.u(), skin, petName);
    }

    /**
     * Return the pet to be adopted.
     * @return : The pet to be adopted.
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Call on the Pet Refresher to refresh the pet in the UI.
     */
    public void refreshPet() {
        new PetRefresher().refresh();
    }
}
