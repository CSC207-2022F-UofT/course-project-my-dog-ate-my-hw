package useCases;

import entities.Pet;

public class AdoptPetUC implements AdoptPetInputBoundary{

    /**
     * Creates a Pet object from the given petIcon and petName.
     * @param petName the pet's name
     */
    public void adoptPet(String petName){
        User.u().setPet(new Pet(petName, null, null));
    }

    public void refreshPet(){
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Pet").refresh();
    }

}
