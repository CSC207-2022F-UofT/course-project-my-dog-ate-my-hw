package useCases;

import entities.User;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CreateTaskUCTest {
    /**
     * Testing create a new task and user
     */
    @Test
    public void CreateTaskTest() throws AbsentTaskNameException {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        entities.Pet pet = new Pet("Name", null);
        entities.User user = new User(10, pet);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.createTask("testing", "csc207", deadline, "HIGH", "PROJECT");
        Assertions.assertEquals(user.getToDo().searchFor("testing"), task);
    }

    @Test
    public void AddToTDLTest() throws AbsentTaskNameException {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        entities.ToDoList todo = new ToDoList();
        todo.addTask(task);
        Assertions.assertEquals(todo.searchFor("testing"), task);
    }

    @Test
    public void GetTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        Assertions.assertEquals(task, createTaskUC.getTask());
    }
}