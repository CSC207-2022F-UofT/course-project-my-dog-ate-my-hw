package useCases.inputBoundaries;

/**
 * The SeeToDoInputBoundary is the input boundary to allow the user to see their todo list.
 */
public interface SeeToDoInputBoundary {

    /**
     * Loads the toDoList of the user.
     */
    void refreshTask();
}
