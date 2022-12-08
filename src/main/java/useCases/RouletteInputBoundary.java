package useCases;

import entities.Task;
import entities.User;

public interface RouletteInputBoundary {

    /**
     * Roulette that returns a randomized task from ToDoList
     * @param user The User
     * @return A randomized task from ToDoList
     */
    public void roulette(User user);

    public void roulette();

    /**
     * Refresh method that refreshes the UI
     */
    public void refreshTask();
}
