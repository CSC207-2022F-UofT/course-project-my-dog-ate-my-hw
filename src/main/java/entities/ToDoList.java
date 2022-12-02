package entities;

import java.util.List;
import java.util.ArrayList;

public class ToDoList {
    // ToDoList is a public Class that contains a list of tasks that the user has yet to complete. Tasks can be added
    // or removed from this taskList, the taskList is not sorted but a sorted list based on different attributes
    // can be returned for display purposes.

    private List<Task> taskList; //A list of tasks yet to be completed by the User

    /**
     * Initialize an empty ToDOList with no tasks in its taskList.
     */
    public ToDoList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Add the given task to this ToDoList's taskList.
     * @param newTask the new task that is to be created
     */
    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Remove the task with the given name from this ToDoList
     * @param task the task that is to be removed
     */
    public void removeTask(Task task){this.taskList.remove(task); }

    /**
     * Given only a String, search for and remove the task with the given name from this ToDoList
     * @param taskName the task that is to be removed
     */
    public void removeTask(String taskName) {
        this.taskList.remove(this.searchFor(taskName));
    }

    /**
     * Given only a String, search for the task and return it, else return null
     * @param taskName the task that is to be searched
     */
    public Task searchFor(String taskName){
        for (Task task : this.taskList){
            if(task.getName().equals(taskName)){
                return task;
            }
        }
        return null;
    }

}
