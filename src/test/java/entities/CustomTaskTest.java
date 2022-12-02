package entities;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomTaskTest {

    // create a CustomTask and check that getters return proper values
    @Test
    public void CustomTaskGettersTest(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 8, 11, 59);
        CustomTask customTask = new CustomTask("task", "csc207", time, Priority.HIGH, AssignmentType.ESSAY, null);
        Assertions.assertEquals("task", customTask.getName());
        Assertions.assertEquals("csc207", customTask.getCourse());
        Assertions.assertEquals(time, customTask.getDeadline());
        Assertions.assertEquals(Priority.HIGH, customTask.getPriority());
        Assertions.assertEquals(AssignmentType.ESSAY, customTask.getAssignmentType());
        Assertions.assertNull(customTask.getStudyTechniques());
    }

    // create a CustomTask and set new values, check that getters return proper values
    @Test
    public void CustomTaskTestSetters(){
        LocalDateTime time1 = LocalDateTime.of(2022, 12, 7, 11, 59);
        LocalDateTime time2 = LocalDateTime.of(2022, 12, 8, 11, 59);

        CustomTask customTask = new CustomTask(null, null, time1, null, null, null);

        customTask.setName("task");
        customTask.setCourse("csc207");
        customTask.setDeadline(time2);
        customTask.setPriority(Priority.HIGH);
        customTask.setDeadline(time2);
        customTask.setAssignmentType(AssignmentType.ESSAY);
        customTask.setStudyTechniques("test");

        Assertions.assertEquals("task", customTask.getName());
        Assertions.assertEquals("csc207", customTask.getCourse());
        Assertions.assertEquals(time2, customTask.getDeadline());
        Assertions.assertEquals(Priority.HIGH, customTask.getPriority());
        Assertions.assertEquals(AssignmentType.ESSAY, customTask.getAssignmentType());
        Assertions.assertEquals("test", customTask.getStudyTechniques());
    }

    // create a CustomTask with a past deadline, check that customTask.pastDeadline returns true
    @Test
    public void CustomTaskTestPastDeadline(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        CustomTask customTask = new CustomTask("task", "csc207", time, Priority.HIGH, AssignmentType.ESSAY, null);
        Assertions.assertTrue(customTask.pastDeadline());
    }

    // create a CustomTask and set completion as true, check that customTask.isCompletion returns true
    @Test
    public void CustomTaskTestCompleted(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 8, 11, 59);
        CustomTask customTask = new CustomTask("task", "csc207", time, Priority.HIGH, AssignmentType.ESSAY, null);
        customTask.setCompletion(true);
        Assertions.assertTrue(customTask.isCompletion());
    }
}
