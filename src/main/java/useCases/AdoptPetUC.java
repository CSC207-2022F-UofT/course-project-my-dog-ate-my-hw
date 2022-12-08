package useCases;

import entities.Pet;

public class AdoptPetUC implements AdoptPetInputBoundary{

    Pet pet;

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param petName the pet's name
     */
    public void adoptPet(String petName, String petIcon){
        UserUC.u().setPet(new Pet(petName, petIcon));
        pet = new Pet(petName, petIcon);
    }

    public void refreshPet(){
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }

    public Pet getPet(){
        return pet;
    }
}
