package Entities;

import java.util.List;
import java.util.ArrayList;

public class DoneList {
    //A public class that contains a list of tasks that the user has completed. Tasks are not sorted in this list.
    //Tasks can be added to this list only if it is first checked off the checklist and removed from the ToDoList.
    //Tasks can also be removed from this list if the user wants to add it to its

    private List<Task> doneTasks; //A list of tasks completed by the user.

    /**
     * Initialize an empty DoneList with no tasks in its doneTasks list.
     */
    public DoneList() {
        this.doneTasks = new ArrayList();
    }

    /**
     * Add the given task to the doneTasks list. Do not sort the list.
     * @param completedTask
     */
    public void addTask(Task completedTask) {
        this.doneTasks.add(completedTask);
    }

    public void removeTask(Task uncompletedTask) {
        this.doneTasks.remove(uncompletedTask);
    }
}
