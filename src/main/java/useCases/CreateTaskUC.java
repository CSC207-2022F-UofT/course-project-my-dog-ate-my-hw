package useCases;

import entities.*;

import java.time.LocalDateTime;

/**
 * The use case to create a task in the program.
 */
public class CreateTaskUC implements CreateTaskInputBoundary {
    private Task task;
    private ToDoList todo;

    /**
     * Creates a task based on name, course, deadline and priority then add to to-do list.
     *
     * @param name     the task's name
     * @param course   the task's belonging course
     * @param deadline the task's deadline
     * @param priority the task's priority level
     */
    public void createTask(String name, String course, LocalDateTime deadline, String priority, String
            assignmentType) {
        if (!name.equals("") && !course.equals("")) {
            task = new Task(name, course, deadline, convertPriority(priority), convertAssignment(assignmentType));
            this.addToTDL(task);
        } else {
            throw new InvalidTaskInformationException();
        }
    }

    /**
     * Adds task to the To Do list.
     *
     * @param task the task to be added to the to do list
     */
    private void addToTDL(Task task) {
        todo = UserUC.u().getToDo();
        todo.addTask(task);
    }

    /**
     * Gets the task.
     *
     * @return task
     */
    public Task getTask() {
        return this.task;
    }

    /**
     * Converts priority from string to the enum value.
     * @param priority priority of task
     * @return Enum of priority
     */
    private Priority convertPriority(String priority){return Priority.valueOf(priority);}

    /**
     * Converts assignment type from string to the enum value.
     * @param assignment type of task
     * @return Enum of assignment type
     */
    private AssignmentType convertAssignment(String assignment){return AssignmentType.valueOf(assignment);}

    /**
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        new TasklistRefresher().refresh();
    }
}
