package presenters;

import useCases.MainOutputBoundary;

public class MainViewUpdater implements MainOutputBoundary {

    private PetUpdater petUpdater;
    private TasklistUpdater tasklistUpdater;

    public PetUpdater getPetUpdater() {
        return petUpdater;
    }
}
