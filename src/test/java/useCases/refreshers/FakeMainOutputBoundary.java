package useCases.refreshers;

import useCases.outputBoundaries.MainOutputBoundary;
import useCases.outputBoundaries.PetOutputBoundary;
import useCases.outputBoundaries.TasklistOutputBoundary;

/**
 * A FakeMainOutputBoundary for testing refreshers
 */
public class FakeMainOutputBoundary implements MainOutputBoundary {

    PetOutputBoundary petOutputBoundary;
    TasklistOutputBoundary tasklistOutputBoundary;

    public void setPetOutputBoundary(PetOutputBoundary newPetOutputBoundary) {
        petOutputBoundary = newPetOutputBoundary;
    }

    public PetOutputBoundary getPetOutputBoundary() {
        return petOutputBoundary;
    }

    public void setTasklistOutputBoundary(TasklistOutputBoundary newTasklistOutputBoundary) {
        tasklistOutputBoundary = newTasklistOutputBoundary;
    }

    public TasklistOutputBoundary getTasklistOutputBoundary() {
        return tasklistOutputBoundary;
    }
}
