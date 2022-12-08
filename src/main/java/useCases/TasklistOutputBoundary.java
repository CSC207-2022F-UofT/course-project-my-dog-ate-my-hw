package useCases;

import java.util.ArrayList;

public interface TasklistOutputBoundary {
    void loadTodoList(ArrayList<TaskUIDS> todo);
    void loadDoneList(ArrayList<TaskUIDS> done);
}
