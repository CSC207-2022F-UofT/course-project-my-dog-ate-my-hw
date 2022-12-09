package useCases;

public class SeeDoneUC implements SeeDoneInputBoundary{
    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getDone().getTaskList());
    }
}
