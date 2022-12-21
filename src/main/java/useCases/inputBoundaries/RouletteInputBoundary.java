package useCases.inputBoundaries;

import entities.User;

public interface RouletteInputBoundary {

    /**
     * Roulette that returns a randomized task from ToDoList
     * @param user The User
     */
    void roulette(User user);

    void roulette();

    /**
     * Refresh method that refreshes the UI
     */
    void refreshTask();
}
