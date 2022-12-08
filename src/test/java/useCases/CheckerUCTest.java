package useCases;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class CheckerUCTest {
    User user;
    ToDoList todo;
    Pet pet;

    /**
     * Initialize user
     * Initialize pet with full health (10)
     */
    @BeforeEach
    public void Setup() {
        user = new User();
        pet = new Pet("Cat");
        todo = new ToDoList();
        user.setTodo(todo);
        user.setPet(pet);
    }

    /**
     * Test 1: a missed task with priority medium
     * Pet should lose 2 health
     */
    @Test
    public void CheckerTest1() {
        Task task1 = new Task("CompSci Assignment", "CSC236", LocalDateTime.of
                (2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.MEDIUM);
        todo.addTask(task1);
        CheckerUC checkerUC = new CheckerUC();
        checkerUC.checkLostHealth(user);
        Assertions.assertEquals(user.getPet().getCurrHealth(), 8);
    }

    /**
     * Test 2: a missed task with priority high
     * Pet should lose 3 health
     */
    @Test
    public void CheckerTest2() {
        Task task1 = new Task("CompSci Assignment", "CSC236", LocalDateTime.of
                (2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.HIGH);
        todo.addTask(task1);
        CheckerUC checkerUC = new CheckerUC();
        checkerUC.checkLostHealth(user);
        Assertions.assertEquals(user.getPet().getCurrHealth(), 7);
    }

    /**
     * Test 3: no missed tasks
     * Pet should not lose health
     */
    @Test
    public void CheckerTest3() {
        Task task1 = new Task("CompSci Assignment", "CSC236", LocalDateTime.of
                (2022, Month.DECEMBER, 29, 19, 30, 40),
                Priority.HIGH);
        todo.addTask(task1);
        CheckerUC checkerUC = new CheckerUC();
        checkerUC.checkLostHealth(user);
        Assertions.assertEquals(user.getPet().getCurrHealth(), 10);
    }

    /**
     * Test 3: two missed tasks with priority medium and high
     * Pet should lose 5 health
     */
    @Test
    public void CheckerTest4() {
        Task task1 = new Task("CompSci Assignment", "CSC236", LocalDateTime.of
                (2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.HIGH);
        Task task2 = new Task("Math Midterm 1", "MAT137", LocalDateTime.of(2022, Month.SEPTEMBER
                , 29, 19, 30, 40), Priority.MEDIUM);
        todo.addTask(task1);
        todo.addTask(task2);
        CheckerUC checkerUC = new CheckerUC();
        checkerUC.checkLostHealth(user);
        Assertions.assertEquals(user.getPet().getCurrHealth(), 5);
    }
}
