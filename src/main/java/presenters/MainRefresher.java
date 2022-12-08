package presenters;

import useCases.MainOutputBoundary;
import useCases.PetOutputBoundary;

public class MainViewUpdater implements MainOutputBoundary {

    private PetUpdater petUpdater;
    private TasklistUpdater tasklistUpdater;

    public PetUpdater getPetUpdater() {
        return petUpdater;
    }

    @Override
    public PetOutputBoundary getPetOutputBoundary() {
        return getPetUpdater();
    }

    public TasklistUpdater getTasklistUpdater() {
        return tasklistUpdater;
    }
}
