package useCases;

public class SeeToDoUC implements SeeToDoInputBoundary{
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getToDo().getTaskList());
    }
}
