package useCases.inputBoundaries;

/**
 * This is the interface for the use case interactor class for the use case of adopting a pet.
 * The user may adopt a pet that they become responsible for.
 * Their pet will lose or gain health depending on the user's To-Do list and points.
 */
public interface AdoptPetInputBoundary {

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param skin a string representing the selected pet's type
     * @param petName the pet's name
     */
    void adoptPet(String skin, String petName);

    /**
     * Call on the Pet Refresher to refresh the pet in the UI.
     */
    void refreshPet();
}
