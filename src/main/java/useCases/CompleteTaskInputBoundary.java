package useCases;

import entities.User;

public interface CompleteTaskInputBoundary {

    /**
     * The main method that handles a completed task
     *
     * @param taskName
     */
    void completeTask(String taskName, User user);

    void completeTask(String taskName);

    /**
     * The refresh method connected to view
     */
    void refreshCompleteTask();
}