package useCases;

import entities.User;

import java.util.ArrayList;

public class RouletteUC implements RouletteInputBoundary{

    entities.Task task;

    /**
     * Returns a randomized task in the user's ToDoList
     * @param user The user who performs the action
     */
    public void roulette(User user) {
        task = user.getToDo().randomTask();
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
