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
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
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
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
        DoneList doneList = new DoneList();
        doneList.addTask(task1);
        doneList.removeTask(task1);
        Assertions.assertFalse(doneList.getTaskList().contains(task1));
    }

}