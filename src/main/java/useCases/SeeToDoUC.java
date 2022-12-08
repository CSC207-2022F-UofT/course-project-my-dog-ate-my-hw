package useCases;

public class SeeToDoUC {
    void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getToDo().getTaskList());
    }
}
