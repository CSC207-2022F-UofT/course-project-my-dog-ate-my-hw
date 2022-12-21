package useCases.interactors;

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
        User user = new User(10, new Pet("alex", "zebra"), todo, new DoneList());
        UserUC.declare(user);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.modifyTask(
                "newname",
                "csc207",
                deadline,
                Priority.HIGH.toString(),
                AssignmentType.PROJECT.name()
        );
        Assertions.assertEquals("newname", todo.getTaskList().get(0).getName());
    }

    @Test
    public void ChangePriorityTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        User user = new User(10, new Pet("alex", "zebra"), todo, new DoneList());
        UserUC.declare(user);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.modifyTask(
                "testing",
                "csc207",
                deadline,
                Priority.LOW.toString(),
                AssignmentType.EXAM.name()
                );
        Assertions.assertEquals(Priority.LOW, todo.getTaskList().get(0).getPriority());
    }

    @Test
    public void ChangeDeadlineTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        User user = new User(10, new Pet("alex", "zebra"), todo, new DoneList());
        UserUC.declare(user);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        LocalDateTime deadline2 = LocalDate.parse("2025-12-19").atStartOfDay();
        modifyTaskUC.modifyTask(
                "testing",
                "csc207",
                deadline2,
                Priority.HIGH.toString(),
                AssignmentType.EXAM.name()
        );
        Assertions.assertEquals(deadline2, todo.getTaskList().get(0).getDeadline());
    }

    @Test
    public void ChangeCourseTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        User user = new User(10, new Pet("alex", "zebra"), todo, new DoneList());
        UserUC.declare(user);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.modifyTask(
                "testing",
                "csc108",
                deadline,
                Priority.HIGH.toString(),
                AssignmentType.EXAM.name()
        );
        Assertions.assertEquals("csc108", todo.getTaskList().get(0).getCourse());
    }

    @Test
    public void ChangeAssignmentTest() {
        LocalDateTime deadline = LocalDate.parse("2025-12-30").atStartOfDay();
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ToDoList todo = new ToDoList();
        todo.addTask(task);
        User user = new User(10, new Pet("alex", "zebra"), todo, new DoneList());
        UserUC.declare(user);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing",todo);
        modifyTaskUC.modifyTask(
                "testing",
                "csc207",
                deadline,
                Priority.HIGH.toString(),
                AssignmentType.QUIZ.toString()
        );
        Assertions.assertEquals(AssignmentType.QUIZ, todo.getTaskList().get(0).getAssignmentType());
    }
}
