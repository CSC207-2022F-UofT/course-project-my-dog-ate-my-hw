package useCases.inputBoundaries;

import entities.User;

/**
 * The RouletteInputBoundary is the input boundary for the use case of showing
 * the user a random task from their toDoList.
 */
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
