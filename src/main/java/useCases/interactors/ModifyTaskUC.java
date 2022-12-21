package useCases.interactors;

import entities.*;
import useCases.inputBoundaries.ModifyTaskInputBoundary;
import useCases.refreshers.TasklistRefresher;

import java.time.LocalDateTime;

/**
 * The modify-task use case takes in the task name, deadline, course, priority and assignment type
 * to change the task in the to-do list.
 */
public class ModifyTaskUC implements ModifyTaskInputBoundary {

    private Task task;
    private ToDoList todo;

    /**
     * Default Constructor for the ModifyTaskUC.
     */
    public ModifyTaskUC(){
        task = null;
        todo = null;
    }

    /**
     * Construct for the ModifyTaskUC.
     * @param taskName The name of the task to be modified
     * @param todo the ToDoList this task should be found in to be modified
     */
    public ModifyTaskUC(String taskName, ToDoList todo) {
        this.todo = todo;
        try {
            this.task = todo.searchFor(taskName);
        } catch (AbsentTaskNameException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds a task with the name taskName in the ToDo list of the given user.
     * @param taskName The name of the task that should be searched for
     * @param user The given user
     * @return True if a task with name taskName is found
     */
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
