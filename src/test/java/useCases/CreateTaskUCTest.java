package useCases;

import entities.User;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CreateTaskUCTest {
    /**
     * Create a new task and user
     * Set user points as 10, pet begins with 10 health
     * Remove 5 hearts
     * Then test BuyHeartUC.buyHeart() by buying 3 hearts
     * User should have 7 points (10 - 3 = 7)
     * Pet should have 8 hearts (5 + 3 = 8)
     */
    @Test
    public void CreateTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        entities.Pet pet = new Pet("Name");
        entities.User user = new User(10, pet);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.createTask("testing", "csc207", deadline, Priority.HIGH);
        Assertions.assertEquals(user.getTodo().searchFor("testing"), task);
    }

    @Test
    public void CreateCustomTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        CustomTask task = new CustomTask("testing", "csc207", deadline, Priority.HIGH,
                AssignmentType.PROJECT, "just do it");
        entities.Pet pet = new Pet("Name");
        entities.User user = new User(10, pet);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.createTask("testing", "csc207", deadline, Priority.HIGH,
                AssignmentType.PROJECT, "just do it");
        Assertions.assertEquals(user.getTodo().searchFor("testing"), task);
    }
    @Test
    public void AddToTDLTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        entities.ToDoList todo = new ToDoList();
        todo.addTask(task);
        Assertions.assertEquals(todo.searchFor("testing"), task);
    }

    @Test
    public void GetTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        Assertions.assertEquals(task, createTaskUC.getTask());
    }
}