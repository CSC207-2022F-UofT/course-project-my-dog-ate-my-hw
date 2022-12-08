package entities;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    //Initializing tasks to be used in tests for pastDeadline method
    Task task1;
    Task task2;
    Task task3;
    Task task4;
    Task task5;
    Task task6;

    @Before
    public void setUp() {
        task1 = new CustomTask("test1", "bio",
                LocalDateTime.of(2023, 12, 12, 11, 59), Priority.HIGH,
                AssignmentType.ESSAY, "write");
        task2 = new CustomTask("test2", "chm",
                LocalDateTime.of(2023, 12, 10, 11, 59), Priority.MEDIUM,
                AssignmentType.ESSAY, "write");
        task3 = new CustomTask("test3", "chm",
                LocalDateTime.of(2024, 12, 10, 11, 59), Priority.LOW,
                AssignmentType.ESSAY, "write");
        task4 = new CustomTask("test4", "chm",
                LocalDateTime.of(2022, 11, 10, 11, 59), Priority.HIGH,
                AssignmentType.ESSAY, "write");
        task5 = new CustomTask("test5", "chm",
                LocalDateTime.of(2022, 10, 10, 11, 59), Priority.MEDIUM,
                AssignmentType.ESSAY, "write");
        task6 = new CustomTask("test6", "chm",
                LocalDateTime.of(2022, 9, 10, 11, 59), Priority.LOW,
                AssignmentType.ESSAY, "write");

    }
    @Test(timeout = 50)
    public void TestBeforeDeadlineHigh() {
        assertEquals(task1.pastDeadline(), 0);
    }

    @Test(timeout = 50)
    public void TestBeforeDeadlineMedium() {
        assertEquals(task2.pastDeadline(), 0);
    }

    @Test(timeout = 50)
    public void TestBeforeDeadlineLow() {
        assertEquals(task3.pastDeadline(), 0);
    }

    @Test(timeout = 50)
    public void TestAfterDeadlineHigh() {
        assertEquals(task4.pastDeadline(), 3);
    }

    @Test(timeout = 50)
    public void TestAfterDeadlineMedium() {
        assertEquals(task5.pastDeadline(), 2);
    }

    @Test
    public void TestAfterDeadlineLow() {
        assertEquals(task6.pastDeadline(), 1);
    }


}