package useCases.interactors;

import useCases.inputBoundaries.SeeDoneInputBoundary;
import useCases.refreshers.TasklistRefresher;

/**
 * The SeeDoneUC loads the singleton user, UserUC's Done list.
 */
public class SeeDoneUC implements SeeDoneInputBoundary {

    /**
     * Sends the doneList of UserUC to be loaded by the refreshers.
     */
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getDone().getTaskList());
    }
}
