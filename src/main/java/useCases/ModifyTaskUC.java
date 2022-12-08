package useCases;

import entities.*;

import java.time.LocalDateTime;

/**
 * The modify task use case takes in the task name, deadline, course, priority and assignment type
 * to change the task in the to-do list.
 */
public class ModifyTaskUC implements ModifyTaskInputBoundary{
    private Task task;
    private ToDoList todo;


    public ModifyTaskUC(){
        task = null;
        todo = null;
    }

    /**
     * This constructs the ModifyTaskUC by taking in the string of a task name then finding the task
     * in the to-do list.
     *
     * @param taskName the task name
     */
    public ModifyTaskUC(String taskName){
        new ModifyTaskUC(taskName, UserUC.u().getToDo());
    }


    public ModifyTaskUC(String taskName, ToDoList todo) {
        this.todo = todo;
        try {
            this.task = todo.searchFor(taskName);
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean findTask(String taskName) {
        try {
            task = todo.searchFor(taskName);
            return true;
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Changes the task's name.
     *
     * @param newName task's new name
     */
    public void changeName(String newName) {
            task.setName(newName);
    }
    /**
     * Changes the task's associated course.
     *
     * @param course task's new course
     */
    public void changeCourse(String course) {
        task.setCourse(course);
    }

    /**
     * Changes the task's priority.
     *
     * @param priority task's priority
     */
    public void changePriority(String priority) {
        Priority p = Priority.getPriority(priority);
        task.setPriority(p);
    }

    /**
     * Changes the task's deadline
     *
     * @param date task's deadline
     */
    public void changeDeadline(LocalDateTime date) {
        task.setDeadline(date);
    }

    public void changeAssignmentType(String assignmentType){ task.setAssignmentType(AssignmentType.getAssignmentType(assignmentType));}

    /**
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        new TasklistRefresher().refresh();
    }
}

