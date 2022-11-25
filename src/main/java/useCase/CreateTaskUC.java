package useCase;

import java.time.LocalDateTime;

import entities.*;

public class CreateTaskUC {
    private Task task;
    private ToDoList todo;

    public CreateTaskUC() {
    }

    /**
     * Creates a task.
     *
     * @param name     the task's name
     * @param course   the task's belonging course
     * @param deadline the task's deadline
     * @param priority the task's priority level
     * @return the created task
     */
    public Task createTask(String name, String course, LocalDateTime deadline, Priority priority) {
        task = new Task(name, course, deadline, priority);
        return task;
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
    public Task createTask(String name, String course, LocalDateTime deadline, Priority priority, String studyTechniques, AssignmentType assignmentType) {
        task = new CustomTask(name, course, deadline, priority, assignmentType, studyTechniques);
        return task;
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