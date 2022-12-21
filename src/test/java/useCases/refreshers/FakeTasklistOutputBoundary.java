package useCases.refreshers;

import useCases.TaskUIDS;
import useCases.outputBoundaries.TasklistOutputBoundary;
import java.util.ArrayList;

/**
 * A FakeTasklistOutputBoundary that stores whether loadList has been run
 */
public class FakeTasklistOutputBoundary implements TasklistOutputBoundary {

    public boolean loadedList = false;
    ArrayList<TaskUIDS> tasks;

    public void loadList(ArrayList<TaskUIDS> tasks) {
        this.tasks = tasks;
        this.loadedList = true;
    }
}
