package useCases;

public class SeeDoneUC {

    public void refreshTask(){
        new TasklistRefresher().refresh(UserUC.u().getDone().getTaskList());
    }
}
