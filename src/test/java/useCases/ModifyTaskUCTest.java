package useCases;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ModifyTaskUCTest {
    /**
     * Create a new task and user
     * Change task's name, deadline, course, priority, and assignment types.
     */

    @Test
    public void ChangeNameTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changeName("soc200");
        Assertions.assertEquals("soc100", task.getName());
    }

    @Test
    public void ChangePriorityTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changePriority(Priority.LOW.toString());
        Assertions.assertEquals(Priority.LOW, task.getPriority());
    }

    @Test
    public void ChangeDeadlineTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        LocalDateTime deadline2 = LocalDateTime.parse("2025-12-19");
        modifyTaskUC.changeDeadline(deadline2);
        Assertions.assertEquals(deadline2, task.getDeadline());
    }

    @Test
    public void ChangeCourseTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changeCourse("csc108");
        Assertions.assertEquals("csc108", task.getCourse());
    }

    @Test
    public void ChangeAssignmentTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changeAssignmentType(AssignmentType.QUIZ.toString());
        Assertions.assertEquals(AssignmentType.QUIZ, task.getAssignmentType());
    }
}