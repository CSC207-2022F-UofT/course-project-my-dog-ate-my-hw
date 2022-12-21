package useCases.interactors;

import useCases.inputBoundaries.SeeDoneInputBoundary;
import useCases.refreshers.TasklistRefresher;

public class SeeDoneUC implements SeeDoneInputBoundary {
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getDone().getTaskList());
    }
}
