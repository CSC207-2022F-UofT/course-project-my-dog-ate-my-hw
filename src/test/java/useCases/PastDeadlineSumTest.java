package useCases;
import entities.Task;
import entities.ToDoList;
import entities.Priority;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.Month;

public class PastDeadlineSumTest {
    // Test method to test the pastDeadLineSum in the ToDoList

    /**
     * Tests that Task.pastDeadline() runs correctly with one task overdue of priority level HIGH.
     *  Create a new TaskList (a list containing tasks)
     *  Create a task past due date with priority HIGH
     *  Add the task to the TaskList
     *  Then test Task.pastDeadline()
     *  Since priority is HIGH, this should result in 3
     */
    @Test
    public void ToDoListTestHigh() {
        ToDoList list = new ToDoList();
        Task one = new Task("one", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.HIGH);
        list.addTask(one);
        ToDoList.pastDeadLineSum();
        Assertions.assertEquals(ToDoList.pastDeadLineSum(), 3);
    }

    /**
     * Tests that Task.pastDeadline() runs correctly with one task overdue of priority level MEDIUM.
     *  Create a new TaskList (a list containing tasks)
     *  Create a task past due date with priority MEDIUM
     *  Add the task to the TaskList
     *  Then test Task.pastDeadline()
     *  Since priority is MEDIUM, this should result in 2
     */
    @Test
    public void ToDoListTestMedium() {
        ToDoList list = new ToDoList();
        Task one = new Task("one", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.HIGH);
        list.addTask(one);
        ToDoList.pastDeadLineSum();
        Assertions.assertEquals(ToDoList.pastDeadLineSum(), 2);
    }

    /**
     * Tests that Task.pastDeadline() runs correctly with one task overdue of priority level LOW.
     *  Create a new TaskList (a list containing tasks)
     *  Create a task past due date with priority LOW
     *  Add the task to the TaskList
     *  Then test Task.pastDeadline()
     *  Since priority is LOW, this should result in 1
     */
    @Test
    public void ToDoListTestLow() {
        ToDoList list = new ToDoList();
        Task one = new Task("one", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.LOW);
        list.addTask(one);
        ToDoList.pastDeadLineSum();
        Assertions.assertEquals(ToDoList.pastDeadLineSum(), 1);
    }


    /**
     * Tests that Task.pastDeadline() runs correctly with tasks overdue of different priority levels.
     *  Create a new TaskList (a list containing tasks)
     *  Create a task past due date with priority HIGH
     *  Create a task past due date with priority MEDIUM
     *  Create a task past due date with priority LOW
     *  Add all the tasks to the TaskList
     *  Then test Task.pastDeadline()
     *  This should result 6 (3 + 2 + 1)
     */
    @Test
    public void ToDoListTestMultiple() {
        ToDoList list = new ToDoList();
        Task one = new Task("one", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.HIGH);
        Task two = new Task("two", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.MEDIUM);
        Task three = new Task("three", "CSC207", LocalDateTime.of(2022, Month.NOVEMBER
                , 29, 19, 30, 40), Priority.LOW);
        list.addTask(one);
        list.addTask(two);
        list.addTask(three);
        ToDoList.pastDeadLineSum();
        Assertions.assertEquals(ToDoList.pastDeadLineSum(), 6);

    }


    /**
     * Tests that Task.pastDeadline() runs correctly with tasks not overdue of different priority levels.
     *  Create a new TaskList (a list containing tasks)
     *  Create a task not past due date with priority HIGH
     *  Create a task not past due date with priority MEDIUM
     *  Create a task not past due date with priority LOW
     *  Add all the tasks to the TaskList
     *  Then test Task.pastDeadline()
     *  This should result in 0
     */
    @Test
    public void ToDoListTestNotPastDeadline() {
        ToDoList list = new ToDoList();
        Task one = new Task("one", "CSC207", LocalDateTime.of(2022, Month.DECEMBER
                , 29, 19, 30, 40), Priority.HIGH);
        Task two = new Task("two", "CSC207", LocalDateTime.of(2022, Month.DECEMBER
                , 29, 19, 30, 40), Priority.MEDIUM);
        Task three = new Task("three", "CSC207", LocalDateTime.of(2022, Month.DECEMBER
                , 29, 19, 30, 40), Priority.LOW);
        list.addTask(one);
        list.addTask(two);
        list.addTask(three);
        ToDoList.pastDeadLineSum();
        Assertions.assertEquals(ToDoList.pastDeadLineSum(), 0);

    }

}
