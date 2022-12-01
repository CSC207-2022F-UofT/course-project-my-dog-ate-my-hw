package useCases;

public interface CompleteTaskInputBoundary {

    /**
     * The main method that handles a completed task
     *
     * @param taskName
     */
    static void completeTask(String taskName, entities.User user) {

    }

    /**
     * The refresh method connected to view
     */
    void refreshTasklist();
}