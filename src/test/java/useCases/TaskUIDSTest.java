package useCases;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Code Coverage for TaskUIDS: 100% methods, 100% lines covered
 */
public class TaskUIDSTest {
    Task task1;
    Task task2;

    /*
    Intialize two tasks to parse into TaskUIDS
     */
    @BeforeEach
    public void Setup() {
        task1 = new Task("Math Midterm 1", "MAT137", LocalDateTime.now().plusDays(5),
                Priority.HIGH, AssignmentType.ESSAY);
        task2 = new Task("CompSci Assignment", "CSC236",
                LocalDateTime.now().plusHours(1), Priority.MEDIUM, AssignmentType.ESSAY);
    }

    /*
    Test the data for task1
     */
    @Test
    public void TaskDSTest1() {
        TaskUIDS taskUIDS = new TaskUIDS(task1);
        Assertions.assertEquals(task1.getName(), taskUIDS.name);
        Assertions.assertEquals(task1.getCourse(), taskUIDS.course);
        Assertions.assertEquals(task1.getDeadline().format(DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT)), taskUIDS.deadline);
        Assertions.assertEquals(String.valueOf(task1.getPriority()), taskUIDS.priority);
        Assertions.assertEquals(String.valueOf(task1.getAssignmentType()), taskUIDS.assignmentType);
        Assertions.assertFalse(taskUIDS.completed);
    }

    /*
    Test the data for task2
     */
    @Test
    public void TaskDSTest2() {
        task2.setCompletion(true);
        TaskUIDS taskUIDS = new TaskUIDS(task2);
        Assertions.assertEquals(task2.getName(), taskUIDS.name);
        Assertions.assertEquals(task2.getCourse(), taskUIDS.course);
        Assertions.assertEquals(task2.getDeadline().format(DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT)), taskUIDS.deadline);
        Assertions.assertEquals(String.valueOf(task2.getPriority()), taskUIDS.priority);
        Assertions.assertEquals(String.valueOf(task2.getAssignmentType()), taskUIDS.assignmentType);
        Assertions.assertTrue(taskUIDS.completed);
    }
}
