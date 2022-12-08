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
        User user = new User();
        ToDoList todo = new ToDoList();
        user.setTodo(todo);
        todo.addTask(task);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing", user);
        modifyTaskUC.changeName("soc200");
        try {
            Assertions.assertEquals(task, user.getToDo().searchFor("soc200"));
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ChangePriorityTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        User user = new User();
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing", user);
        modifyTaskUC.changePriority(Priority.LOW);
        Assertions.assertEquals(Priority.LOW, task.getPriority());
    }

    @Test
    public void ChangeDeadlineTest() {
        Task task = new Task("testing", "csc207",  LocalDateTime.of(2015,
                12, 10, 11, 59), Priority.HIGH, AssignmentType.EXAM);
        User user = new User();
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing", user);
        LocalDateTime deadline2 =  LocalDateTime.of(2015, 12, 11, 11, 59);
        modifyTaskUC.changeDeadline(deadline2);
        Assertions.assertEquals(deadline2, task.getDeadline());
    }

    @Test
    public void ChangeCourseTest() {
        Task task = new Task("testing", "csc207",  LocalDateTime.of(2015, 12,
                10, 11, 59), Priority.HIGH, AssignmentType.EXAM);
        User user = new User();
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing", user);
        modifyTaskUC.changeCourse("csc108");
        Assertions.assertEquals("csc108", task.getCourse());
    }

    @Test
    public void ChangeAssignmentTest() {
        Task task = new Task("testing", "csc207",  LocalDateTime.of(2015,
                12, 10, 11, 59), Priority.HIGH, AssignmentType.EXAM);
        User user = new User();
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing", user);
        modifyTaskUC.changeAssignmentType(AssignmentType.QUIZ);
        Assertions.assertEquals(AssignmentType.QUIZ, task.getAssignmentType());
    }
}