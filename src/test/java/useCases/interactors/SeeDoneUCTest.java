package useCases.interactors;

import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.refreshers.FakeMainOutputBoundary;
import useCases.refreshers.FakeTasklistOutputBoundary;
import java.time.LocalDateTime;

/**
 * Test for SeeDoneUC.
 * Coverage: 100% class, 100% methods, 100% lines.
 */
public class SeeDoneUCTest {

    User user;

    /**
     * Create a Task, a DoneList, and a User
     */
    @BeforeEach
    public void Setup(){
        Task task = new Task(
                "task",
                "course",
                LocalDateTime.now().plusYears(3),
                Priority.HIGH,
                AssignmentType.ESSAY
        );
        DoneList doneList = new DoneList();
        doneList.addTask(task);
        user = new User(1, null, new ToDoList(), doneList);
    }

    /**
     * Set the FakeMainOutputBoundary and TasklistOutputBoundary, and call refreshTask()
     * If refreshTask() works, then fakeTasklistOutputBoundary should be set to true
     */
    @Test
    public void RefreshTest(){
        FakeMainOutputBoundary fakeMainOutputBoundary = new FakeMainOutputBoundary();
        FakeTasklistOutputBoundary fakeTasklistOutputBoundary = new FakeTasklistOutputBoundary();
        fakeMainOutputBoundary.setTasklistOutputBoundary(fakeTasklistOutputBoundary);
        UserUC.declare(user);
        UserUC.declareUI(fakeMainOutputBoundary);

        SeeDoneUC seeDoneUC = new SeeDoneUC();
        seeDoneUC.refreshTask();

        Assertions.assertTrue(fakeTasklistOutputBoundary.loadedList);
    }
}