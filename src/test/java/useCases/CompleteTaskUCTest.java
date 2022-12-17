package useCases;

import entities.*;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

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
        user = new User();
        task1 = new Task("Math Midterm 1", "MAT137", LocalDateTime.of(2022, Month.DECEMBER
                , 29, 19, 30, 40), Priority.HIGH, AssignmentType.ESSAY);
        task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.of(2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.MEDIUM, AssignmentType.ESSAY);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        user.setTodo(toDoList);
        user.setDone(doneList);
    }

    @Test
    public void CompleteTaskTest1() throws AbsentTaskNameException {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC();
        completeTaskUC.completeTask("CompSci Assignment", user);
        Assertions.assertEquals(user.getToDo().getTaskList().size(), 1);
        Assertions.assertEquals(user.getDone().getTaskList().size(), 1);
        Assertions.assertEquals(user.getPoints(), 0);
    }

    @Test
    public void CompleteTaskTest2() throws AbsentTaskNameException {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC();
        completeTaskUC.completeTask("Math Midterm 1", user);
        Assertions.assertEquals(user.getPoints(), 3);
        Assertions.assertEquals(user.getToDo().getTaskList().size(), 1);
        Assertions.assertEquals(user.getDone().getTaskList().size(), 1);
    }
}
