package useCases.inputBoundaries;

/**
 * The SeeDoneInputBoundary is the input boundary to allow the user to see their Done list.
 */
public interface SeeDoneInputBoundary {

    /**
     * Loads the doneList of the user.
     */
    void refreshTask();
}
