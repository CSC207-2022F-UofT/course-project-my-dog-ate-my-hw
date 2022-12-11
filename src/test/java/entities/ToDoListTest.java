package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class ToDoListTest {
    private ToDoList toDoList;
    private Task task1;
    private LocalDateTime time;

    /**
     * Initialize task1 and toDoList
     * Add task1 to toDoList
     */
    @BeforeEach
    public void Setup() {
        toDoList = new ToDoList();
        time = LocalDateTime.of(2022, 12, 29, 11, 59);
        task1 = new Task("task1", "csc207", time, Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task1);
    }

    /**
     * Check that task1 is in the ToDoList
     */
    @Test
    public void TestAddTask(){
        Assertions.assertTrue(toDoList.getTaskList().contains(task1));
    }

    /**
     * create a ToDoList, add a task, remove it, then check
     * that the task is not in the ToDoList
     */
    @Test
    public void TestRemoveTask(){
        toDoList.removeTask(task1);
        Assertions.assertFalse(toDoList.getTaskList().contains(task1));
    }

    /**
     * Creates two task with identical name
     * CheckUniqueName should return false
     */
    @Test
    public void TestUniqueName(){
        Task task2 = new Task("task1", "csc108", time, Priority.LOW, AssignmentType.ESSAY);
        Assertions.assertFalse(toDoList.checkUniqueName(task2));
    }

    /**
     * Add task1 to toDoList
     * Search for the name of task1
     * Should return task1
     * @throws AbsentTaskNameException If the name does not exist
     */
    @Test
    public void TestSearchTask() throws AbsentTaskNameException {
        Task task2 = toDoList.searchFor("task1");
        Assertions.assertEquals(task2.getCourse(), "csc207");
    }

    /**
     * Generate a random task
     * Since there is only one task in toDoList, it should be task1
     */
    @Test
    public void TestRandomTask() {
        Task task2 = toDoList.randomTask();
        Assertions.assertEquals(task2.getCourse(), "csc207");
    }

    /**
     * Add a task2 with medium priority and past deadline
     * pastDeadlineSum should be 2
     */
    @Test
    public void TestPastDeadlineSum() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.of(2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.MEDIUM, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        Assertions.assertEquals(toDoList.pastDeadLineSum(), 2);
    }

    /**
     * Add a task2 with medium priority and past deadline
     * Add a task3 with high priority and past deadline
     * pastDeadlineSum should be 5
     */
    @Test
    public void TestPastDeadlineSum2() {
        Task task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.of(2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.MEDIUM, AssignmentType.ESSAY);
        Task task3 = new Task("Problem Set", "CSC236",
                LocalDateTime.of(2022, Month.OCTOBER, 29, 19, 30, 40),
                Priority.HIGH, AssignmentType.ESSAY);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        Assertions.assertEquals(toDoList.pastDeadLineSum(), 5);
    }

}
