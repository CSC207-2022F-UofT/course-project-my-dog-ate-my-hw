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

    public ModifyTaskUC(String taskName, ToDoList todo) {
        this.todo = todo;
        try {
            this.task = todo.searchFor(taskName);
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean findTask(String taskName, User user) {
        try {
            todo = user.getToDo();
            task = todo.searchFor(taskName);
            return true;
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean findTask (String taskName) {
        return findTask(taskName, UserUC.u());
    }

    /**
     * Changes the task's name.
     *
     * @param newName task's new name
     */
    public void changeName(String newName) {
        if (!newName.equals("") && todo.checkUniqueName(newName)) {
            task.setName(newName);
        }
        else {
            throw new InvalidTaskInformationException();
        }
    }
    /**
     * Changes the task's associated course.
     *
     * @param course task's new course
     */
    public void changeCourse(String course) {
        if (!course.equals("")) {
            task.setCourse(course);
        } else {
            throw new InvalidTaskInformationException();
        }

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
        if (Task.deadlineisValid(date)) {
            task.setDeadline(date);
        } else {
            throw new InvalidTaskInformationException();
        }
    }

    public void changeAssignmentType(String assignmentType){
        task.setAssignmentType(AssignmentType.getAssignmentType(assignmentType));
    }

    /**
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        new TasklistRefresher().refresh();
    }
}