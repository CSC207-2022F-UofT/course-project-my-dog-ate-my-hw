package useCases;

import java.util.ArrayList;

public interface TasklistOutputBoundary {
    void loadTodoList(ArrayList<TaskUI> todo);
    void loadDoneList(ArrayList<TaskUI> done);
}
