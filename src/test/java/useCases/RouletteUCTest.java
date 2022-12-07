package useCases;

import entities.Priority;
import entities.Task;
import entities.ToDoList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import entities.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

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
        task1 = new Task("Math Midterm 1", "MAT137", LocalDateTime.of(2022, Month.DECEMBER
                , 29, 19, 30, 40), Priority.HIGH);
        toDoList.addTask(task1);
        user.setTodo(toDoList);
    }

    /**
     * Test 1: Tests RouletteUC by picking from ToDoList
     * Since there's only one task in the list, the picked task must be task1
     */
    @Test
    public void RouletteTest1() {
        RouletteUC rouletteUC = new RouletteUC();
        Task task = rouletteUC.Roulette(user);
        Assertions.assertEquals(task.getName(), task1.getName());
    }

    /**
     * Test 2: Adds another task2 to ToDoList
     * The picked task should either be task1 or task2
     */
    @Test
    public void RouletteTest2() {
        Task task2 = new Task ("CompSci Assignment", "CSC236",
                LocalDateTime.of(2022, Month.OCTOBER, 29, 19, 30, 40), Priority.MEDIUM);
        user.getToDo().addTask(task2);
        RouletteUC rouletteUC = new RouletteUC();
        Task task = rouletteUC.Roulette(user);
        Assertions.assertTrue(task.getName().equals(task1.getName())
                ||task.getName().equals(task2.getName()));
    }

}
