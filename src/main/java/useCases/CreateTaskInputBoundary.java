package useCases;

import entities.Task;
import java.time.LocalDateTime;

/**
 * The input boundary for the CreateTask use case which passes information from the controller.
 */
public interface CreateTaskInputBoundary {

    /**
     * Creates a task based on name, course, deadline and priority.
     *
     * @param name     the task's name
     * @param course   the task's belonging course
     * @param deadline the task's deadline
     * @param priority the task's priority level
     * @param assignmentType the task's assignment type
     */
    void createTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType);

    /**
     * Gets a task.
     *
     * @return task the task.
     */
    Task getTask();

    /**
     * Refreshes the task to update.
     */
    void refreshTask();
}