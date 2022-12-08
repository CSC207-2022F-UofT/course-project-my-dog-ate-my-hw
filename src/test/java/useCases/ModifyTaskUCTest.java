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

    /**
     * Tests that modifyTaskUC.changeName changes the name of the task correctly.
     * Create a new task named "testing"
     * Create a new ToDoList
     * Add the task to the ToDoList
     * Implement the modifyTaskUC.changeName function with the parameter "soc200"
     * This should result in an updated task name "soc200"
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

    /**
     * Tests that modifyTaskUC.changePriority changes the priority of the task correctly.
     * Create a new task with a Priority.HIGH priority
     * Create a new ToDoList
     * Add the task to the ToDoList
     * Implement the modifyTaskUC.changePriority function with the parameter Priority.LOW
     * This should result in an updated priority level : LOW
     */
    @Test
    public void ChangePriorityTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changePriority(Priority.LOW);
        Assertions.assertEquals(Priority.LOW, task.getPriority());
    }

    /**
     * Tests that modifyTaskUC.changeDeadline changes the deadline of the task correctly.
     * Create a new task with the deadline "2025-12-30"
     * Create a new ToDoList
     * Add the task to the ToDoList
     * Implement the modifyTaskUC.changeDeadline function with the parameter "2025-12-19"
     * This should result in the updated deadline : "2025-12-19"
     */
    @Test
    public void ChangeDeadlineTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        LocalDateTime deadline2 = LocalDateTime.parse("2025-12-19");
        modifyTaskUC.changeDeadline(deadline2);
        Assertions.assertEquals(deadline2, task.getDeadline());
    }

    /**
     * Tests that modifyTaskUC.changeCourse changes the name of the course of the task correctly.
     * Create a new task with the course name "csc207"
     * Create a new ToDoList
     * Add the task to the ToDoList
     * Implement the modifyTaskUC.changeCourse function with the parameter "csc108"
     * This should result in the updated course name : "csc108"
     */
    @Test
    public void ChangeCourseTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changeCourse("csc108");
        Assertions.assertEquals("csc108", task.getCourse());
    }

    /**
     * Tests that modifyTaskUC.changeAssignmentType changes the task's assignment type correctly.
     * Create a new task with the assignment type EXAM
     * Create a new ToDoList
     * Add the task to the ToDoList
     * Implement the modifyTaskUC.changeAssignmentType function with the parameter AssignmentType.QUIZ
     * This should result in the updated assignment type : AssignmentType.QUIZ
     */
    @Test
    public void ChangeAssignmentTest() {
        LocalDateTime deadline = LocalDateTime.parse("2025-12-30");
        Task task = new Task("testing", "csc207", deadline, Priority.HIGH, AssignmentType.EXAM);
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC("testing");
        modifyTaskUC.changeAssignmentType(AssignmentType.QUIZ);
        Assertions.assertEquals(AssignmentType.QUIZ, task.getAssignmentType());
    }
}