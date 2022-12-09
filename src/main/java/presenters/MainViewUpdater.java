package presenters;

import useCases.MainOutputBoundary;
import useCases.PetOutputBoundary;
import useCases.TasklistOutputBoundary;

public class MainViewUpdater implements MainOutputBoundary {

    private PetUpdater petUpdater;
    private TasklistUpdater tasklistUpdater;

    public MainViewUpdater(){
        petUpdater = new PetUpdater();
        tasklistUpdater = new TasklistUpdater();
    }
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

    public TasklistOutputBoundary getTasklistOutputBoundary(){
        return tasklistUpdater;
    }
}
