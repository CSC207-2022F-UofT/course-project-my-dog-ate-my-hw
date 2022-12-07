package useCases;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;

import java.time.LocalDateTime;

/**
 * The input boundary for the ModifyTask use case which passes information from the controller.
 */
public interface ModifyTaskInputBoundary {

    /**
     * Changes the task's name.
     *
     * @param newName task's new name
     */
    void changeName(String newName);

    /**
     * Changes the task's associated course.
     *
     * @param course task's new course
     */
    void changeCourse(String course);

    /**
     * Changes the task's priority.
     *
     * @param priority task's priority
     */

    void changePriority(Priority priority);

    /**
     * Changes the task's deadline
     *
     * @param date task's deadline
     */
    void changeDeadline(LocalDateTime date);

    /**
     * Changes the task's assignment type.
     *
     * @param assignmentType the task's assignment type.
     */
    void changeAssignmentType(AssignmentType assignmentType);

    /**
     * Refreshes the task to update.
     */
    void refreshTask();
}