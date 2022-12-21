package useCases.outputBoundaries;

import useCases.TaskUIDS;

import java.util.ArrayList;

public interface TasklistOutputBoundary {
    void loadList(ArrayList<TaskUIDS> tasks);
}
