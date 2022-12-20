package useCases;

import entities.*;
import java.time.LocalDateTime;

/**
 * The modify-task use case takes in the task name, deadline, course, priority and assignment type
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
     * Create a new task and delete the old one ("modify")
     * @param name task name
     * @param course task course
     * @param deadline task deadline
     * @param priority priority string
     * @param assignmentType assignment type string
     */
    public void modifyTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType){
        User user = UserUC.u();
        modifyTask(name, course, deadline, priority, assignmentType, user);
    }

    /**
     * Create a new task and delete the old one ("modify")
     * @param name task name
     * @param course task course
     * @param deadline task deadline
     * @param priority priority string
     * @param assignmentType assignment type string
     */
    public void modifyTask(String name, String course, LocalDateTime deadline, String priority, String assignmentType, User user){
        CreateTaskUC createTaskUC = new CreateTaskUC();
        todo.removeTask(task);
        createTaskUC.createTask(
                name,
                course,
                deadline,
                priority,
                assignmentType,
                user
        );
    }

    /**
     * Calls on factory to create a refresher.
     */
    public void refreshTask() {
        new TasklistRefresher().refresh();
    }

}