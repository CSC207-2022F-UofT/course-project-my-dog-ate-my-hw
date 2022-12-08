package useCases;

import java.util.ArrayList;
import java.util.List;

public class TasklistRefresher{

    public void refresh(List<entities.Task> tasks){
        MainOutputBoundary m = UserUC.UI();

        ArrayList<TaskUIDS> currTasks = new ArrayList<>();

        for (entities.Task t : tasks){
            currTasks.add(new TaskUIDS(t));
        }

        m.getTasklistOutputBoundary().loadTodoList(currTasks);
    }
    public void refresh(){
        refresh(UserUC.u().getToDo().getTaskList());
    }
}
