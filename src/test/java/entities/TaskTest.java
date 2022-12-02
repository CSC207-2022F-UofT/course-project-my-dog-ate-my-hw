package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TaskTest {

    // create a task and check that all getters return proper values
    @Test
    public void TaskTestGetters(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 8, 11, 59);
        Task task = new Task("task", "csc207", time, Priority.HIGH);
        Assertions.assertEquals("task", task.getName());
        Assertions.assertEquals("csc207", task.getCourse());
        Assertions.assertEquals(time, task.getDeadline());
        Assertions.assertEquals(Priority.HIGH, task.getPriority());
    }

    // create a task, use setters and check that getters return proper values
    @Test
    public void TaskTestSetters(){
        LocalDateTime time1 = LocalDateTime.of(2022, 12, 7, 11, 59);
        LocalDateTime time2 = LocalDateTime.of(2022, 12, 8, 11, 59);
        Task task = new Task(null, null, time1, null);
        task.setName("task");
        task.setCourse("csc207");
        task.setDeadline(time2);
        task.setPriority(Priority.HIGH);
        task.setDeadline(time2);
        Assertions.assertEquals("task", task.getName());
        Assertions.assertEquals("csc207", task.getCourse());
        Assertions.assertEquals(time2, task.getDeadline());
        Assertions.assertEquals(Priority.HIGH, task.getPriority());
    }

    // create a task past some deadline and verify that task.pastDeadline returns true
    @Test
    public void TaskTestPastDeadline(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task = new Task("task", "csc207", time, Priority.HIGH);
        Assertions.assertTrue(task.pastDeadline());
    }

    // create a task, set it as complete, and check whether task.isCompletion returns true
    @Test
    public void TaskTestCompleted(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 8, 11, 59);
        Task task = new Task("task", "csc207", time, Priority.HIGH);
        task.setCompletion(true);
        Assertions.assertTrue(task.isCompletion());
    }
}
