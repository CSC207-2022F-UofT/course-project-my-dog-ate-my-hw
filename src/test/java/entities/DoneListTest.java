package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class DoneListTest {

    /**
     * create a DoneList, add a task, then check
     * that the task is in the DoneList
     */
    @Test
    public void TestAddTask(){
        LocalDateTime time = LocalDateTime.now().plusMonths(1);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH, AssignmentType.ESSAY);
        task1.setCompletion(true);
        DoneList doneList = new DoneList();
        doneList.addTask(task1);
        Assertions.assertTrue(doneList.getTaskList().contains(task1));
    }

    /**
     * create a DoneList, add a task, remove it, then check
     * that the task is not in the DoneList
     */
    @Test
    public void TestRemoveTask(){
        LocalDateTime time = LocalDateTime.now().plusMonths(1);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH, AssignmentType.ESSAY);
        DoneList doneList = new DoneList();
        doneList.addTask(task1);
        doneList.removeTask(task1);
        Assertions.assertFalse(doneList.getTaskList().contains(task1));
    }

}
