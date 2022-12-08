package presenters;

import useCases.PetOutputBoundary;
import useCases.PetUIDS;

public class PetUpdater implements PetOutputBoundary {
    private static ViewRefresherBoundary viewRefresher;
    public void loadPet(PetUIDS pet) {
        viewRefresher.refresh();
    }
}
