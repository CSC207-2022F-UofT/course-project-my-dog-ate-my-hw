package useCases.inputBoundaries;

import entities.User;

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