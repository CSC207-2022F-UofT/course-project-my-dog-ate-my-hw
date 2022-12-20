package useCases;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ModifyTaskUCTest {
    /**
     * Create a new task and user
     * Change task's name, deadline, course, priority, and assignment types.
     */

    @Test
    public void ChangeNameTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.PROJECT);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.changeName("soc200");
        Assertions.assertEquals("soc200", task.getName());
    }

    @Test
    public void ChangePriorityTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.changePriority(Priority.LOW.toString());
        Assertions.assertEquals(Priority.LOW, task.getPriority());
    }

    @Test
    public void ChangeDeadlineTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        LocalDateTime deadline2 = LocalDate.parse("2025-12-19").atStartOfDay();
        modifyTaskUC.changeDeadline(deadline2);
        Assertions.assertEquals(deadline2, task.getDeadline());
    }

    @Test
    public void ChangeCourseTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.changeCourse("csc108");
        Assertions.assertEquals("csc108", task.getCourse());
    }

    @Test
    public void ChangeAssignmentTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.changeAssignmentType(AssignmentType.QUIZ.toString());
        Assertions.assertEquals(AssignmentType.QUIZ, task.getAssignmentType());
    }
}
