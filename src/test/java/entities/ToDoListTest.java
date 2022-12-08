package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ToDoListTest {

    /**
     * create a ToDoList, add a task, then check
     * that the task is in the ToDoList
     */
    @Test
    public void TestAddTask(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task1);
        Assertions.assertTrue(toDoList.getTaskList().contains(task1));
    }

    /**
     * create a ToDoList, add a task, remove it, then check
     * that the task is not in the ToDoList
     */
    @Test
    public void TestRemoveTask(){
        LocalDateTime time = LocalDateTime.of(2022, 12, 7, 11, 59);
        Task task1 = new Task("task1", "csc207", time, Priority.HIGH);
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task1);
        toDoList.removeTask(task1);
        Assertions.assertFalse(toDoList.getTaskList().contains(task1));
    }

}
