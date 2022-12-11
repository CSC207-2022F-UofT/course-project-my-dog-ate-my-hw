package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Checklist {
    /**
     * An abstract class containing a list of tasks that and can be manipulated. Tasks can be added or removed from
     * the task list. Tasks can also be searched from the tasklist. The task list can be returned for
     * viewing purposes.
     */

    private List<Task> taskList;

    public Checklist() {
        this.taskList = new ArrayList<>();
    }


    /**
     * Add the given task to taskList. Do not sort the taskList.
     * @param task : the given task to add.
     * @return boolean : true if the task was successfully added, false otherwise.
     */
    public boolean addTask(Task task) {
        this.taskList.add(task);
        return true;
    }

    /**
     * Remove the given task from the taskList.
     * @param task : The given task to be removed.
     */
    public void removeTask(Task task) {
        this.taskList.remove(task);
    }


    /**
     * Return the taskList.
     * @return : The taskList attribute.
     */
    public List<Task> getTaskList() {
        return this.taskList;
    }
}
