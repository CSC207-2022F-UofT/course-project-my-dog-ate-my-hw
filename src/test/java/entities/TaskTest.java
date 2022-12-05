package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskTest {
    /**
     * Created a new task.
     * Set task name as "testing", course as "csc207", deadline as 2022-11-30, and priority as high.
     * Then tested respective getters and setters for each of those attributes.
     * Also tested if the task can return a string and list representation.
     */
    @Test
    public void CreateTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2022-11-30");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("2022-11-30", formatter);
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        Assertions.assertEquals("testing", task.getName());
        Assertions.assertEquals("csc207", task.getCourse());
        Assertions.assertEquals(dateTime, task.getDeadline());
        Assertions.assertEquals("HIGH", task.getPriority().name());
    }

    @Test
    public void GetDeadlineTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("2025-12-30", formatter);
        Assertions.assertEquals(dateTime, task.getDeadline());
    }

    @Test
    public void SetDeadlineTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        LocalDateTime newdeadline = LocalDateTime.parse("2026-12-30");
        task.setDeadline(newdeadline);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("2026-12-30", formatter);
        Assertions.assertEquals(dateTime, task.getDeadline());
    }

    @Test
    public void GetNameTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "csc207", deadline, Priority.HIGH);
        Assertions.assertEquals("rough draft", task.getName());
    }

    @Test
    public void SetNameTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "csc207", deadline, Priority.HIGH);
        task.setName("final draft");
        Assertions.assertEquals("final draft", task.getName());
    }

    @Test
    public void GetCourseTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "SOC150", deadline, Priority.HIGH);
        Assertions.assertEquals("SOC150", task.getCourse());
    }

    @Test
    public void SetCourseTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "csc207", deadline, Priority.HIGH);
        task.setCourse("PSY100");
        Assertions.assertEquals("PSY100", task.getCourse());
    }

    @Test
    public void GetPriorityTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "SOC150", deadline, Priority.MEDIUM);
        Assertions.assertEquals("MEDIUM", task.getPriority().name());
    }

    @Test
    public void SetPriorityTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "csc207", deadline, Priority.HIGH);
        task.setPriority(Priority.LOW);
        Assertions.assertEquals("LOW", task.getPriority().name());
    }

    @Test
    public void IsCompletionTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("rough draft", "SOC150", deadline, Priority.MEDIUM);
        Assertions.assertFalse(task.isCompletion());
        task.setCompletion(true);
        Assertions.assertTrue(task.isCompletion());
        task.setCompletion(false);
        Assertions.assertFalse(task.isCompletion());
    }


    @Test
    public void PastDeadlineTest() {
        LocalDateTime deadline = LocalDateTime.parse("3025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        Assertions.assertFalse(task.getDeadline().isBefore(LocalDateTime.now()));
        LocalDateTime newdeadline = LocalDateTime.parse("2002-11-20");
        task.setDeadline(newdeadline);
        Assertions.assertTrue(task.getDeadline().isBefore(LocalDateTime.now()));
    }

    @Test
    public void ToStringTest() {
        LocalDateTime deadline = LocalDateTime.parse("3025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        Assertions.assertEquals("testing csc207 3025-12-30 HIGH", task.toString());
    }

    @Test
    public void ToArrayTest() {
        LocalDateTime deadline = LocalDateTime.parse("3025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH);
        String[] res = new String[]{"testing", "csc207", "3025-12-30", "HIGH"};
        Assertions.assertEquals(res, task.taskToList());
    }
}