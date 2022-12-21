package useCases.interactors;

import useCases.inputBoundaries.SeeToDoInputBoundary;
import useCases.refreshers.TasklistRefresher;

public class SeeToDoUC implements SeeToDoInputBoundary {
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getToDo().getTaskList());
    }
}
