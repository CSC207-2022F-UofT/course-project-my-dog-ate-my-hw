package entities;

import java.util.List;
import java.util.ArrayList;

public class DoneList {
    //A public class that contains a list of tasks that the user has completed. Tasks are not sorted in this list.
    //Tasks can be added to this list only if it is first checked off the checklist and removed from the ToDoList.
    //Tasks can also be removed from this list if the user wants to add it to its

    private ArrayList<Task> doneTasks; //A list of tasks completed by the user.

    /**
     * Initialize an empty DoneList with no tasks in its doneTasks list.
     */
    public DoneList() {
        this.doneTasks = new ArrayList();
    }

    /**
     * Add the given task to the doneTasks list. Do not sort the list.
     * @param completedTask the completed task
     */
    public void addTask(Task completedTask) {
        this.doneTasks.add(completedTask);
    }

    /**
     * Given only a String, search for and remove the task with the given name from this ToDoList
     * @param taskName the task that is to be removed
     */
    public void removeTask(String taskName) {
        this.doneTasks.remove(this.searchFor(taskName));
    }

    /**
     * Remove the task with the given name from this ToDoList
     * @param task the task that is to be removed
     */
    public void removeTask(Task task){this.doneTasks.remove(task);}

    /**
     * Given only a String, search for the task and return it, else return null
     * @param taskName the task that is to be searched
     */
    public Task searchFor(String taskName){
        for (Task task : this.doneTasks){
            if(task.getName().equals(taskName)){
                return task;
            }
        }
        return null;
    }

}
