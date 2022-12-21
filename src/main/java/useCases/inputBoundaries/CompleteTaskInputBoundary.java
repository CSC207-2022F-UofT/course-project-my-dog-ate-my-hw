package useCases.inputBoundaries;

import entities.User;

/**
 * The CompleteTaskInputBoundary interface is the input boundary for the use case in which the user can complete
 * a task they have finished.
 */
public interface CompleteTaskInputBoundary {

    /**
     * The main method that handles a completed task
     *
     * @param taskName the name of the task
     */
    void completeTask(String taskName, User user);

    void completeTask(String taskName);

    /**
     * The refresh method connected to view
     */
    void refreshCompleteTask();
}