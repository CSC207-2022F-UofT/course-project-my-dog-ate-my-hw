package useCases;

import entities.*;

import java.time.LocalDateTime;

/**
 * The use case controller to create a task in the program.
 */
public class CreateTaskUC implements CreateTaskInputBoundary {
    private Task task;
    private ToDoList todo;

    public CreateTaskUC() {
    }

    /**
     * Creates a task based on name, course, deadline and priority.
     *
     * @param name     the task's name
     * @param course   the task's belonging course
     * @param deadline the task's deadline
     * @param priority the task's priority level
     */
    public void createTask(String name, String course, LocalDateTime deadline, Priority priority) {
        task = new Task(name, course, deadline, priority);
        todo = User.u().getToDo();
    }

    /**
     * Creates a task.
     *
     * @param name            the task's name
     * @param course          the task's belonging course
     * @param deadline        the task's deadline
     * @param priority        the task's priority level
     * @param assignmentType  the task's type of assignment
     * @param studyTechniques the task's ideal study technique
     */
    public void createTask(String name, String course, LocalDateTime deadline, Priority priority, AssignmentType assignmentType, String studyTechniques) {
        task = new CustomTask(name, course, deadline, priority, assignmentType, studyTechniques);
        todo = User.u().getTodo();
    }

    /**
     * Adds task to the To Do list.
     *
     * @param task the task to be added to the to do list
     */
    public void addToTDL(Task task) {

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
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        RefresherFactory factory = new RefresherFactory();
        factory.createRefresher("Tasklist").refresh();
    }
}
