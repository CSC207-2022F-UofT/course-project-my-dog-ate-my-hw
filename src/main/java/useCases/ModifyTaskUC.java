package useCases;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;

import java.time.LocalDateTime;

/**
 * The modify task use case takes in the task name, deadline, course, priority and assignment type
 * to change the task in the to-do list.
 */
public class ModifyTaskUC implements ModifyTaskInputBoundary{
    private Task task;

    /**
     * This constructs the ModifyTaskUC by taking in the string of a task name then finding the task
     * in the to-do list.
     *
     * @param taskName the task name
     */

    public ModifyTaskUC(String taskName) {
        this.task = todo.searchFor(taskName);
    }

    /**
     * Changes the task's name.
     *
     * @param newName task's new name
     */
    public void changeName(String newName) {
        task.setName(newName);
    }

    /**
     * Changes the task's associated course.
     *
     * @param course task's new course
     */
    public void changeCourse(String course) {
        task.setCourse(course);
    }

    /**
     * Changes the task's priority.
     *
     * @param priority task's priority
     */
    public void changePriority(Priority priority) {
        task.setPriority(priority);
    }

    /**
     * Changes the task's deadline
     *
     * @param date task's deadline
     */
    public void changeDeadline(LocalDateTime date) {
        task.setDeadline(date);
    }

    /**
     * Changes the task's assignment type.
     *
     * @param assignmentType the task's assignment type.
     */
    public void changeAssignmentType(AssignmentType assignmentType) {
        task.setAssignmentType(assignmentType);
    }

    /**
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Tasklist").refresh();
    }
}

