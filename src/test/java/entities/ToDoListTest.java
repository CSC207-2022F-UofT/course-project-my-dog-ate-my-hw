package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ToDoListTest {

    // create a ToDoList, add 3 tasks, remove task 2 and 3, then check
    // that task1 is in the ToDoList and task 2 and 3 are not
    @Test
    public void ToDoListBasicTest(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 8, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
        Task task2 = new Task("task2", "csc207", time, Priority.HIGH);
        Task task3 = new Task("task3", "csc207", time, Priority.HIGH);

        ToDoList tdl = new ToDoList();
        tdl.addTask(task1);
        tdl.addTask(task2);
        tdl.addTask(task3);
        tdl.removeTask(task2);
        tdl.removeTask(task3.getName());

        Assertions.assertEquals(tdl.searchFor(task1.getName()), task1);
        Assertions.assertNull(tdl.searchFor(task2.getName()));
        Assertions.assertNull(tdl.searchFor(task3.getName()));
    }

}
