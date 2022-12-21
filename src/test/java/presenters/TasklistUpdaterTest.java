package presenters;

import entities.AssignmentType;
import entities.Priority;
import entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.TaskUIDS;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Testing the TasklistUpdater class.
 * Code coverage for the TasklistUpdater class: 100% class, 100% methods, 100% lines
 */
public class TasklistUpdaterTest {

    TaskUIDS taskUIDS;
    ArrayList<TaskUIDS> tasks;
    FakeViewRefresher fakeViewRefresher;

    @BeforeEach
    public void Setup(){
        LocalDateTime deadline = LocalDateTime.now().plusYears(1);
        Task task = new Task(
                "name",
                "course",
                deadline,
                Priority.HIGH,
                AssignmentType.EXAM
        );
        taskUIDS = new TaskUIDS(task);
        tasks = new ArrayList<>();
        tasks.add(taskUIDS);
        fakeViewRefresher = new FakeViewRefresher();
    }

    /**
     * Test for setViewRefresher() and loadList()
     * If loadList() works successfully, then setViewRefresher must necessarily work
     * We know that loadList() works successfully if the fakeViewRefresher successfully
     * refreshes the list of tasks, thus setting refreshedTasks to true
     */
    @Test
    public void SetViewRefresherTest(){
        TasklistUpdater tasklistUpdater = new TasklistUpdater();
        TasklistUpdater.setViewRefresher(fakeViewRefresher);
        tasklistUpdater.loadList(tasks);
        Assertions.assertTrue(fakeViewRefresher.refreshedTasks);
    }

    /**
     * Test that loadList() successfully converts TaskUIDS object(s)
     * to TaskVM object(s)
     */
    @Test
    public void ConveresionUIDStoVMTest(){
        TasklistUpdater tasklistUpdater = new TasklistUpdater();
        TasklistUpdater.setViewRefresher(fakeViewRefresher);
        tasklistUpdater.loadList(tasks);
        Assertions.assertInstanceOf(TaskVM.class, fakeViewRefresher.convertedTask);
    }
}