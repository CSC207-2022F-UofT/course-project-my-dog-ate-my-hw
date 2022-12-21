package useCases.interactors;

import entities.User;
import useCases.DefaultValueData;
import useCases.inputBoundaries.RouletteInputBoundary;
import useCases.refreshers.TasklistRefresher;

import java.util.ArrayList;

/**
 * The RouletteUC implements the use case of showing the user a random task from their toDoList.
 */
public class RouletteUC implements RouletteInputBoundary {

    entities.Task task;

    /**
     * Returns a randomized task in the user's ToDoList
     * @param user The user who performs the action
     */
    public void roulette(User user) {
        if (user.getToDo() != null){
            task = user.getToDo().randomTask();
            if (task == null) {
                task = DefaultValueData.EMPTY_TASK;
            }
        }
    }

    /**
     * Another version of the roulette method
     */
    public void roulette() {roulette(UserUC.u());}

    public entities.Task getTask(){return task;}

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshTask() {
        ArrayList<entities.Task> t = new ArrayList<>();
        t.add(task);
        new TasklistRefresher().refresh(t);
    }
}
