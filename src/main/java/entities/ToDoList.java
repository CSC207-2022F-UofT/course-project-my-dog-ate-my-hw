package entities;

import java.util.concurrent.ThreadLocalRandom;

/** ToDoList is a public Class that contains a list of tasks that the user has yet to complete, it is a child class
 *  of Checklist. In addition to the inherited methods from Checklist, the ToDoList can be sorted by the deadlines
 *  of the task and the priorities of the task.
 *  ====== Representation invariant ========
 * 1) Every task in the taskList must have a unique name.
 */
public class ToDoList extends Checklist {

    /**
     * Check if the inputted name is unique, meaning it does not match the name of any other task in the taskList.
     *
     * @param newName : The given name to be checked.
     * @return : true if the given name is unique and false otherwise.
     */
    public boolean checkUniqueName(String newName) {
        for (Task addedTask : this.getTaskList())
            if (addedTask.getName().equals(newName)) {
                return false;
            }
        return true;
    }

    /** Add the given task to the taskList if it has a unique name.
     * @param newTask : the given task to add to the taskList.
     * @return boolean : return true if the task was successfully added to the taskList. Return false if the task does
     * not have a unique name and needs a new name.
     */
    @Override
     public boolean addTask(Task newTask) {
         if (checkUniqueName(newTask.getName()) && Task.deadlineisValid(newTask.getDeadline())) {
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
     * @return Task at random index in the taskList. Returns null if list is empty.
     */
    public Task randomTask() {
        switch (super.getTaskList().size()) {
            case 1:
                return super.getTaskList().get(0);
            case 0:
                return null;
            default:
                int randomNum = ThreadLocalRandom.current().nextInt(0, super.getTaskList().size());
                return super.getTaskList().get(randomNum);
        }
    }

    /**
     * Return the sum of the points lost due to tasks being uncompleted past their deadline. The number
     * of points a task will cause someone to lose is based on its priority (high = 3 points, medium = 2 points,
     * low = 1 point).
     * @return the sum of points lost by the user due to tasks uncompleted past their deadline.
     */
    public int pastDeadLineSum() {
        int sumOfLate = 0;
        for (Task task: this.getTaskList()) {
            sumOfLate += task.pastDeadline();
        }
        return sumOfLate;
    }
}
