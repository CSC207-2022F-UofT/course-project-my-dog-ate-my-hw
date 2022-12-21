package presenters;

import entities.AssignmentType;
import entities.Priority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.DefaultValueData;
import useCases.TaskUIDS;
import entities.Task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Testing the TaskVM class.
 * Code coverage for the TaskVM class: 100% class, 100% methods, 100% lines
 */
public class TaskVMTest {

    /**
     * A test to check whether TaskVM() successfully converts
     * a TaskUIDS object
     */
    @Test
    public void ConversionUIDStoVMTest(){
        LocalDateTime deadline = LocalDateTime.now().plusYears(1);
        Task task = new Task(
                "name",
                "course",
                deadline,
                Priority.HIGH,
                AssignmentType.EXAM
        );
        TaskUIDS taskUIDS = new TaskUIDS(task);
        TaskVM taskVM = new TaskVM(taskUIDS);
        Assertions.assertEquals("name", taskVM.name);
        Assertions.assertEquals("course", taskVM.course);
        Assertions.assertEquals(deadline.format(DateTimeFormatter.ofPattern(DefaultValueData.DATE_FORMAT)), taskVM.deadline);
        Assertions.assertEquals(Priority.HIGH.name(), taskVM.priority);
        Assertions.assertEquals(AssignmentType.EXAM.name(), taskVM.assignmentType);
        Assertions.assertEquals(false, taskVM.completed);
    }

}