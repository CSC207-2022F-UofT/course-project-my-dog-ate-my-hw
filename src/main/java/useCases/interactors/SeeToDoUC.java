package useCases.interactors;

import useCases.inputBoundaries.SeeToDoInputBoundary;
import useCases.refreshers.TasklistRefresher;

/**
 * The SeeToDoUC loads the singleton user, UserUC's toDo list.
 */
public class SeeToDoUC implements SeeToDoInputBoundary {

    /**
     * Sends the toDoList of UserUC to be loaded by the refreshers.
     */
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getToDo().getTaskList());
    }
}
