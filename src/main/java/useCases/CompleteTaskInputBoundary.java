package useCases;

import entities.User;

public interface CompleteTaskInputBoundary {

    /**
     * The main method that handles a completed task
     *
     * @param taskName
     */
    static void completeTask(String taskName, User user) {}

    static void completeTask(String taskName) {

    }

    /**
     * The refresh method connected to view
     */
    void refreshCompleteTask();
}