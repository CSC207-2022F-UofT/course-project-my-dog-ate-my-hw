package useCases;

public class TasklistRefresher implements Refresher{

    public void refresh() {
        MainOutputBoundary m = User.UI();
        m.getTasklistOutputBoundary();
    }
}
