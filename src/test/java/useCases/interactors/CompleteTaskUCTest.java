package useCases.interactors;

import entities.*;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CompleteTaskUCTest {
    User user;
    Task task1;
    Task task2;
    ToDoList toDoList = new ToDoList();
    DoneList doneList = new DoneList();

    /**
     * Create a new Task task1 with high priority and deadline in the future
     * Create a new Task task2 with medium priority and deadline in the past
     * Create a new user with empty toDoList and doneList
     * Test1: test CompleteTaskUC.completeTask() by completing task2
     * toDoList should have one task
     * doneList should have one task
     * task2 is completed after deadline so the user should have 0 point
     * Test2: CompleteTaskUC.completeTask() by completing task1
     * task1 is completed before deadline so the user should have 3 points
     * toDoList should have one task
     * doneList should have one task
     */
    @BeforeEach
    public void Setup() {
        task1 = new Task("Math Midterm 1", "MAT137", LocalDateTime.now().plusDays(5),
                Priority.HIGH, AssignmentType.ESSAY);
        task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        user = new User(10, new Pet("alex", "zebra"), toDoList, doneList);
    }

    @Test
    public void CompleteTaskTest2() {
        task2.setDeadline(task2.getDeadline().minusHours(2));
        CompleteTaskUC completeTaskUC = new CompleteTaskUC();
        completeTaskUC.completeTask("CompSci Assignment", user);
        Assertions.assertEquals(user.getToDo().getTaskList().size(), 1);
        Assertions.assertEquals(user.getDone().getTaskList().size(), 1);
        Assertions.assertEquals(user.getPoints(), 0);
    }

    @Test
    public void CompleteTaskTest1() {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC();
        completeTaskUC.completeTask("Math Midterm 1", user);
        Assertions.assertEquals(user.getPoints(), 3);
        Assertions.assertEquals(user.getToDo().getTaskList().size(), 1);
        Assertions.assertEquals(user.getDone().getTaskList().size(), 1);
    }
}