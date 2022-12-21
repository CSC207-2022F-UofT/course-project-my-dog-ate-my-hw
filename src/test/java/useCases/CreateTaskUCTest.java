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
        LocalDateTime deadline = LocalDateTime.now().plusYears(5);
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        entities.Pet pet = new Pet("Name", "skin");
        entities.User user = new User(10, pet, new ToDoList(), new DoneList());
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.createTask("testing", "csc207", deadline, "HIGH", "PROJECT", user);
        Task createdTask = user.getToDo().searchFor("testing");
        // Testing that values are equal
        Assertions.assertEquals(task.getName(), createdTask.getName());
        Assertions.assertEquals(task.getCourse(), createdTask.getCourse());
        Assertions.assertEquals(task.getDeadline(), createdTask.getDeadline());
        Assertions.assertEquals(task.getPriority().toString(), createdTask.getPriority().toString());
        Assertions.assertEquals(task.getAssignmentType().toString(), createdTask.getAssignmentType().toString());
    }

    @Test
    public void AddToTDLTest() throws AbsentTaskNameException {
        LocalDateTime deadline = LocalDateTime.now().plusYears(5);
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        entities.ToDoList todo = new ToDoList();
        todo.addTask(task);
        Assertions.assertEquals(todo.searchFor("testing"), task);
    }

    @Test
    public void GetTaskTest() {
        User user = new User(10, new Pet("alex", "zebra"), new ToDoList(), new DoneList());
        LocalDateTime deadline = LocalDateTime.now().plusYears(5);
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.createTask(task.getName(), task.getCourse(), task.getDeadline(), task.getPriority().toString(),
                task.getAssignmentType().toString(), user);
        // Testing that values are equal
        Assertions.assertEquals(task.getName(), createTaskUC.getTask().getName());
        Assertions.assertEquals(task.getCourse(), createTaskUC.getTask().getCourse());
        Assertions.assertEquals(task.getDeadline(), createTaskUC.getTask().getDeadline());
        Assertions.assertEquals(task.getPriority().toString(), createTaskUC.getTask().getPriority().toString());
        Assertions.assertEquals(task.getAssignmentType().toString(), createTaskUC.getTask().getAssignmentType().toString());
    }
}