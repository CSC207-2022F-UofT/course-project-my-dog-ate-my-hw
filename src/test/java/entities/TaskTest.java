package entities;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    /**
     *
     */

    Task task;
    Task task2;

    @Before
    public void setUp() throws Exception {
        task = new CustomTask("test1", "bio",
                LocalDateTime.of(2023, 12, 12, 11, 59), Priority.HIGH,
                AssignmentType.ESSAY, "write");
        task2 = new CustomTask("test3", "chm",
                LocalDateTime.of(2023, 12, 10, 11, 59), Priority.MEDIUM,
                AssignmentType.ESSAY, "write");
    }
    @Test(timeout = 50)
    public void TestBeforeDeadlineHigh() {
        assertEquals(task.pastDeadline(), 0);
    }


}
///TODO test for before deadline High priority,
// TODO test before deadline Medium priority
//TODO test before deadline low priority
//Should be zero for all priorities before deadline
//TODO test after deadline for all priorities