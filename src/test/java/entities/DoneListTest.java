package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class DoneListTest {

    // create a DoneList, add 3 tasks, remove task 2 and 3, then check
    // that task1 is in the DoneList and task 2 and 3 are not
    @Test
    public void DoneListBasicTest(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
        Task task2 = new Task("task2", "csc207", time, Priority.HIGH);
        Task task3 = new Task("task3", "csc207", time, Priority.HIGH);

        task1.setCompletion(true);

        DoneList dl = new DoneList();
        dl.addTask(task1);
        dl.addTask(task2);
        dl.addTask(task3);
        dl.removeTask(task2);
        dl.removeTask(task3.getName());

        Assertions.assertEquals(dl.searchFor(task1.getName()), task1);
        Assertions.assertNull(dl.searchFor(task2.getName()));
        Assertions.assertNull(dl.searchFor(task3.getName()));
    }

}
