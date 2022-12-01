package entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomTaskTest {
    @Test
    public void CreateCustomTaskTest() {
        LocalDateTime deadline = LocalDateTime.parse("2022-11-30");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse("2022-11-30", formatter);
        CustomTask task = new CustomTask("testing", "csc207", deadline, Priority.HIGH,
                AssignmentType.PROJECT, "chunk time");
        Assertions.assertEquals("testing", task.getName());
        Assertions.assertEquals("csc207", task.getCourse());
        Assertions.assertEquals(dateTime, task.getDeadline());
        Assertions.assertEquals("HIGH", task.getPriority().name());
        Assertions.assertEquals("PROJECT", task.getAssignmentType().name());
        Assertions.assertEquals("chunk time", task.getStudyTechniques());
    }

    @Test
    public void GetAssignmentTypeTest() {
        LocalDateTime deadline = LocalDateTime.parse("2022-11-30");
        CustomTask task = new CustomTask("reflection", "csc207", deadline, Priority.HIGH,
                AssignmentType.REFLECTION, "chunk time");
        Assertions.assertEquals("REFLECTION", task.getAssignmentType().name());
    }

    @Test
    public void SetAssignmentTest() {
        LocalDateTime deadline = LocalDateTime.parse("2022-11-30");
        CustomTask task = new CustomTask("reflection", "csc207", deadline, Priority.HIGH,
                AssignmentType.REFLECTION, "chunk time");
        task.setAssignmentType(AssignmentType.ESSAY);
        Assertions.assertEquals("ESSAY", task.getAssignmentType().name());
    }

    @Test
    public void GetStudyTechniqueTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        CustomTask task = new CustomTask("reflection", "csc207", deadline, Priority.HIGH,
                AssignmentType.REFLECTION, "just do it");
        Assertions.assertEquals("just do it", task.getStudyTechniques());
    }

    @Test
    public void SetStudyTechniqueTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        CustomTask task = new CustomTask("reflection", "csc207", deadline, Priority.HIGH,
                AssignmentType.REFLECTION, "just do it");
        task.setStudyTechniques("think before you write");
        Assertions.assertEquals("think before your write", task.getStudyTechniques());
    }
    }

