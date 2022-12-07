package useCases;

import entities.Task;

public interface RouletteInputBoundary {

    /**
     * Roulette that returns a randomized task from ToDoList
     * @param user The User
     * @return A randomized task from ToDoList
     */
    public Task Roulette(entities.User user);

    public Task Roulette();

    /**
     * Refresh method that refreshes the UI
     */
    public void RefreshRoulette();
}
