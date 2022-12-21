package useCases.refreshers;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.interactors.UserUC;
import java.time.LocalDateTime;

/**
 * Test for TasklistRefresher.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class TasklistRefresherTest {

    /**
     * Create a ToDoList with a task, a User, a FakeTasklistOutputBoundary, and a FakeMainOutputBoundary,
     * make all necessary declarations and call refresh(), if it works correctly then loadedList should be
     * set to true.
     */
    @Test
    public void RefreshTest(){
        Task task = new Task(
                "task",
                "course",
                LocalDateTime.now().plusYears(3),
                Priority.HIGH,
                AssignmentType.ESSAY
        );
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task);
        User user = new User(1, null, toDoList, new DoneList());
        FakeMainOutputBoundary fakeMainOutputBoundary = new FakeMainOutputBoundary();
        FakeTasklistOutputBoundary fakeTasklistOutputBoundary = new FakeTasklistOutputBoundary();
        fakeMainOutputBoundary.setTasklistOutputBoundary(fakeTasklistOutputBoundary);
        UserUC.declare(user);
        UserUC.declareUI(fakeMainOutputBoundary);
        TasklistRefresher tasklistRefresher = new TasklistRefresher();
        tasklistRefresher.refresh();
        Assertions.assertTrue(fakeTasklistOutputBoundary.loadedList);
    }
}

