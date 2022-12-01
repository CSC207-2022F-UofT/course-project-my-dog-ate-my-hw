package entities;
/*

import java.util.List;
import java.util.ArrayList;
*/

public class ToDoList extends Checklist {
    /**
     * ToDoList is a public Class that contains a list of tasks that the user has yet to complete, it is a child class
     *  of Checklist. In addition to the inherited methods from Checklist, the ToDoList can be sorted by the deadlines
     *  of the task and the priorities of the task.
     *
     *
     *
     *  ====== Representation invariant ========
     *
     * 1) Every task in the taskList must have a unique name.
     */


    /**
     * Check if the task has a unique name, meaning it does not have the same name as any other tasks in the taskList.
     *
     * @param newTask : The given task to be added to the taskList.
     * @return : true if the given task has a unique name and false otherwise.
     */
    public boolean checkUniqueName(Task newTask) {
        for (Task addedTask : this.getTaskList()) {
            if (addedTask.getName() == newTask.getName()) {
                return false;
            }
        }
        return true;
    }

    @Override
    /**
     * Add the given task to the taskList if it has a unique name.
     * @param newTask : the given task to add to the taskList.
     * @return boolean : return true if the task was successfully added to the taskList. Return false if the task does
     * not have a unique name and needs a new name.
     */
     public boolean addTask(Task newTask) {
         if (checkUniqueName(newTask)) {
             super.addTask(newTask);
         }
         return false;
    }

    /**
     * Return a taskList sorted by the deadline of each task. In order of the soonest deadline to the latest
     * deadline.
     * @return List<Task> : a list of the tasks in taskList sorted by the deadlines of the tasks.</Task>
     */

     public void sortedDeadlinesToDo() {
     }
}
