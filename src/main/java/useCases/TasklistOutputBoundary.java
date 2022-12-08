package useCases;

import presenters.TaskVM;

import java.util.ArrayList;

public interface TasklistOutputBoundary {
    void loadList(ArrayList<TaskUIDS> tasks);
}
