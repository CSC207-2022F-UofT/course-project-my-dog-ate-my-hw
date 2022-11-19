package useCase;

import java.time.LocalDateTime;

import entities.CustomTask;
import entities.Priority;
import entities.Task;
import entities.ToDoList;

public class CreateTaskUC {
    private Task task;
    private ToDoList todo;

    public CreateTaskUC(Task task) {
        this.task = task;
    }

    /**
     * Creates a task.
     *
     * @param name     the task's name
     * @param course   the task's belonging course
     * @param deadline the task's deadline
     * @param priority the task's priority level
     */
    public void createTask(String name, String course, LocalDateTime deadline, Priority priority) {
        task = new Task(name, course, deadline, priority);
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
    public void createCustomTask(String name, String course, LocalDateTime deadline, Priority priority, String studyTechniques, String assignmentType) {
        task = new CustomTask(name, course, deadline, priority, assignmentType, studyTechniques);
    }

    /**
     * Adds task to the To Do list.
     *
     * @param task the task to be added to the to do list
     */
    public void addToTDL(Task task) {
        todo.addTask(task);
    }
}
