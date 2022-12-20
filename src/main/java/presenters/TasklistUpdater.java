package presenters;

import useCases.TaskUIDS;
import useCases.TasklistOutputBoundary;
import java.util.ArrayList;

public class TasklistUpdater implements TasklistOutputBoundary {
    private static ViewRefresherBoundary viewRefresher;

    public static void setViewRefresher(ViewRefresherBoundary vr){
        viewRefresher = vr;
    }

    public void loadList(ArrayList<TaskUIDS> tasks) {
        TaskVM[] sentTasks = new TaskVM[tasks.size()];
        for (int i = 0; i < tasks.size(); i++){
            sentTasks[i] = new TaskVM(tasks.get(i));
        }
        viewRefresher.refresh(sentTasks);
    }
}
