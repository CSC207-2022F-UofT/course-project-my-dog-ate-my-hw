package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TaskTest {

    /**
     * Created a new task.
     * Set task name as "testing", course as "csc207", deadline as 2022-11-30, and priority as high.
     * Then tested respective getters and setters for each of those attributes.
     * Also tested if the task can return a string and list representation.
     */
    //Initializing tasks to be used in tests for pastDeadline method
    Task task1;
    Task task2;
    Task task3;
    Task task4;
    Task task5;
    Task task6;
    @BeforeEach
    public void setUp() {

        task1 = new Task("test1", "bio", LocalDateTime.now().plusYears(3), Priority.HIGH,
                AssignmentType.ESSAY);
        task2 = new Task("test2", "chm", LocalDateTime.now().plusYears(2), Priority.MEDIUM,
                AssignmentType.ESSAY);
        task3 = new Task("test3", "chm", LocalDateTime.now().plusYears(1), Priority.LOW,
                AssignmentType.ESSAY);
        task4 = new Task("test4", "chm", LocalDateTime.now().minusMonths(1), Priority.HIGH,
                AssignmentType.ESSAY);
        task5 = new Task("test5", "chm", LocalDateTime.now().minusMonths(2), Priority.MEDIUM,
                AssignmentType.ESSAY);
        task6 = new Task("test6", "chm", LocalDateTime.now().minusMonths(3), Priority.LOW,
                AssignmentType.ESSAY);
    }


    @Test
    public void GetNameTest() {
        Assertions.assertEquals("test6", task6.getName());
    }

    @Test
    public void SetNameTest() {
        Task task = new Task("rough draft", "csc207",
                LocalDateTime.now().plusMonths(1), Priority.HIGH, AssignmentType.PROJECT);
        task.setName("final draft");
        Assertions.assertEquals("final draft", task.getName());
    }

    @Test
    public void GetCourseTest() {
        Task task = new Task("rough draft", "SOC150", LocalDateTime.now().plusMonths(1),
                Priority.HIGH, AssignmentType.PROJECT);
        Assertions.assertEquals("SOC150", task.getCourse());
    }

    @Test
    public void SetCourseTest() {
        Task task = new Task("rough draft", "csc207", LocalDateTime.now().plusMonths(1),
                Priority.HIGH, AssignmentType.PROJECT);
        task.setCourse("PSY100");
        Assertions.assertEquals("PSY100", task.getCourse());
    }

    @Test
    public void GetPriorityTest() {
        Task task = new Task("rough draft", "SOC150", LocalDateTime.now().plusMonths(1),
                Priority.MEDIUM, AssignmentType.PROJECT);
        Assertions.assertEquals("MEDIUM", task.getPriority().name());
    }

    @Test
    public void SetPriorityTest() {
        Task task = new Task("rough draft", "csc207",
                LocalDateTime.now().plusMonths(1), Priority.HIGH, AssignmentType.PROJECT);
        task.setPriority(Priority.LOW);
        Assertions.assertEquals("LOW", task.getPriority().name());
    }

    @Test
    public void GetAssignmentTypeTest() {
        Task task = new Task("rough draft", "SOC150",
                LocalDateTime.now().plusMonths(1), Priority.MEDIUM, AssignmentType.PROJECT);
        Assertions.assertEquals("PROJECT", task.getAssignmentType().name());
    }

    @Test
    public void SetAssignmentTypeTest() {
        Task task = new Task("rough draft", "csc207",
                LocalDateTime.now().plusMonths(1), Priority.HIGH, AssignmentType.PROJECT);
        task.setAssignmentType(AssignmentType.ESSAY);
        Assertions.assertEquals("ESSAY", task.getAssignmentType().name());
    }

    @Test
    public void IsCompletionTest() {
        Task task = new Task("rough draft", "SOC150",
                LocalDateTime.now().plusMonths(1), Priority.MEDIUM, AssignmentType.PROJECT);
        Assertions.assertFalse(task.isCompletion());
        task.setCompletion(true);
        Assertions.assertTrue(task.isCompletion());
        task.setCompletion(false);
        Assertions.assertFalse(task.isCompletion());
    }


    @Test
    public void ToStringTest() {
        LocalDateTime deadline = LocalDateTime.now().plusMonths(1);
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        Assertions.assertEquals("testing csc207 " + deadline + " HIGH", task.toString());
    }

    @Test
    public void TestBeforeDeadlineHigh() {
        Assertions.assertEquals(task1.pastDeadline(), 0);
    }

    @Test
    public void TestBeforeDeadlineMedium() {
        Assertions.assertEquals(task2.pastDeadline(), 0);
    }

    @Test
    public void TestBeforeDeadlineLow() {
        Assertions.assertEquals(task3.pastDeadline(), 0);
    }

    @Test
    public void TestAfterDeadlineHigh() {
        Assertions.assertEquals(task4.pastDeadline(), 3);
    }

    @Test
    public void TestAfterDeadlineMedium() {
        Assertions.assertEquals(task5.pastDeadline(), 2);
    }

    @Test
    public void TestAfterDeadlineLow() {
        Assertions.assertEquals(task6.pastDeadline(), 1);
    }
}