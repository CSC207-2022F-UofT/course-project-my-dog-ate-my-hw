package useCases;

import java.time.LocalDateTime;

/**
 * The input boundary for the ModifyTask use case which passes information from the controller.
 */
public interface ModifyTaskInputBoundary {

    /**
     * Create a new task and delete the old one ("modify")
     * @param name task name
     * @param course task course
     * @param deadline task deadline
     * @param priority priority string
     * @param assignmentType assignment type string
     */
    void modifyTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType);

    /**
     * Find and verify that the task exists
     * @param taskName the name of the task to be modified
     * @return whether the task was found or not (boolean)
     */
    boolean findTask(String taskName);

    /**
     * Refreshes the task to update.
     */
    void refreshTask();
}