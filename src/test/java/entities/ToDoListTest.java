package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

/**
 * Tests for the ToDoList entity class.
 * Coverage: 100% class, 100% methods, 100% lines
 */
public class ToDoListTest {
    private ToDoList toDoList;
    private Task task1;

    /**
     * Initialize task1 and toDoList
     * Add task1 to toDoList
     */
    @BeforeEach
    public void Setup() {
        toDoList = new ToDoList();
        task1 = new Task("task1", "csc207", LocalDateTime.now().plusDays(5), Priority.HIGH,
                AssignmentType.ESSAY);
        toDoList.addTask(task1);
    }

    /**
     * Check that task1 is in the ToDoList
     */
    @Test
    public void AddTaskTest(){
        Assertions.assertTrue(toDoList.getTaskList().contains(task1));
    }

    /**
     * create a ToDoList, add a task, remove it, then check
     * that the task is not in the ToDoList
     */
    @Test
    public void RemoveTaskTest(){
        toDoList.removeTask(task1);
        Assertions.assertFalse(toDoList.getTaskList().contains(task1));
    }

    /**
     * Creates two task with identical name
     * CheckUniqueName should return false
     */
    @Test
    public void NonUniqueNameTest() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
        Task task3 = new Task("Problem Set", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        Assertions.assertFalse(toDoList.checkUniqueName("task1"));
        Assertions.assertFalse(toDoList.checkUniqueName("CompSci Assignment"));
    }

    @Test
    public void UniqueNameTest() {
        Assertions.assertTrue(toDoList.checkUniqueName("task2"));
    }

    /**
     * Add task1 to toDoList
     * Search for the name of task1
     * Should return task1
     */
    @Test
    public void SearchTaskTest() {
        try {
            Assertions.assertEquals(toDoList.searchFor("task1"), task1);
        }
        catch (AbsentTaskNameException ex) {
            Assertions.fail();
        }
    }

    @Test
    public void SearchTaskExceptionTest() {
        try {
            toDoList.searchFor("task2");
            Assertions.fail();
        }
        catch (AbsentTaskNameException ex) {
            Assertions.assertEquals(ex.toString(), "entities.AbsentTaskNameException");
        }
}


    /**
     * Generate a random task
     * Since there is only one task in toDoList, it should be task1
     */
    @Test
    public void RandomTaskTest() {
        Task task2 = toDoList.randomTask();
        Assertions.assertEquals(task2.getCourse(), "csc207");
    }

    @Test
    public void RandomTaskNullTest() {
        toDoList.removeTask(task1);
        Assertions.assertNull(toDoList.randomTask());
    }

    @Test
    public void RandomTaskMoreThanOneTest() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
        Task task3 = new Task("Problem Set", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        Task random = toDoList.randomTask();
        Assertions.assertTrue(toDoList.getTaskList().contains(random));
    }

    /**
     * Add a task2 with medium priority and past deadline
     * pastDeadlineSum should be 2
     */
    @Test
    public void PastDeadlineSumTest() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        task2.setDeadline(task2.getDeadline().minusHours(2));
        Assertions.assertEquals(toDoList.pastDeadLineSum(), 2);
    }

    /**
     * Add a task2 with medium priority and past deadline
     * Add a task3 with high priority and past deadline
     * pastDeadlineSum should be 5
     */
    @Test
    public void PastDeadlineSum2Test() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
        Task task3 = new Task("Problem Set", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        task2.setDeadline(task2.getDeadline().minusHours(2));
        task3.setDeadline(task3.getDeadline().minusHours(2));
        Assertions.assertEquals(toDoList.pastDeadLineSum(), 5);
    }
}
