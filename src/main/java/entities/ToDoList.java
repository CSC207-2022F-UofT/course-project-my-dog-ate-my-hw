package entities;
/*

import java.util.List;
import java.util.ArrayList;
*/

import java.util.concurrent.ThreadLocalRandom;

public class ToDoList extends Checklist {
    /** ToDoList is a public Class that contains a list of tasks that the user has yet to complete, it is a child class
     *  of Checklist. In addition to the inherited methods from Checklist, the ToDoList can be sorted by the deadlines
     *  of the task and the priorities of the task.
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
            if (addedTask.getName().equals(newTask.getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    /** Add the given task to the taskList if it has a unique name.
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
     * Return the task in the taskList that has the given name. The names of tasks are unique.
     * @param taskName : the name of the task being searched for.
     * @return : a task with the given name or throw an AbsentTaskNameException if there is no task with
     * the given name.
     */

    public Task searchFor(String taskName) throws AbsentTaskNameException {
        for (Task task : super.getTaskList()) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        throw new AbsentTaskNameException();
    }

    /**
     * Randomize a task in the list
     * @return Task at random index in the taskList
     */
    public Task randomTask() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, super.getTaskList().size());
        return super.getTaskList().get(randomNum);
    }

    /**
     * Return the sum of the points lost due to tasks being incompleted past their deadline. The number
     * of points a task will cause someone to lose is based on its priority (high = 3 points, medium = 2 points,
     * low = 1 point).
     * @return the sum of points lost by the user due to tasks uncompleted past their deadline.
     */
    public int pastDeadLineSum() {
        int sumOfLate = 0;
        for (Task task: this.taskList) {
            sumOfLate += task.pastDeadline();
        }
        return sumOfLate;
    }

}
