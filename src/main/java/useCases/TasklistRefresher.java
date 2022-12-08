package useCases;

public class TasklistRefresher implements Refresher{

    public void refresh() {
        MainOutputBoundary m = UserUC.UI();
        m.getTasklistOutputBoundary();
    }
}
