package useCases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class RouletteUCTest {
    User user;
    Task task1;
    ToDoList toDoList;

    /**
     * Setup method that adds a task1 to user's ToDoList
     */
    @BeforeEach
    public void Setup() {
        toDoList = new ToDoList();
        user = new User();
        task1 = new Task("Math Midterm 1", "MAT137", LocalDateTime.now().plusDays(5),
                Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task1);
        user.setTodo(toDoList);
        UserUC.declare(user);
    }

    /**
     * Test 1: Tests RouletteUC by picking from ToDoList
     * Since there's only one task in the list, the picked task must be task1
     */
    @Test
    public void RouletteTest1() {
        RouletteUC rouletteUC = new RouletteUC();
        rouletteUC.roulette();
        Task task = rouletteUC.getTask();
        Assertions.assertEquals(task.getName(), task1.getName());
    }

    /**
     * Test 2: Adds another task2 to ToDoList
     * The picked task should either be task1 or task2
     */
    @Test
    public void RouletteTest2() {
        Task task2 = new Task ("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusDays(5), Priority.MEDIUM, AssignmentType.ESSAY);
        user.getToDo().addTask(task2);
        RouletteUC rouletteUC = new RouletteUC();
        rouletteUC.roulette();
        Task task = rouletteUC.getTask();
        Assertions.assertTrue(task.getName().equals(task1.getName())
                ||task.getName().equals(task2.getName()));
    }

}
