package presenters;

import useCases.outputBoundaries.PetOutputBoundary;
import useCases.PetUIDS;

public class PetUpdater implements PetOutputBoundary {

    private static ViewRefresherBoundary viewRefresher;

    public static void setViewRefresher(ViewRefresherBoundary vr){
        viewRefresher = vr;
    }

    public void loadPet(PetUIDS pet) {
        viewRefresher.refresh(new PetVM(pet));
    }
}