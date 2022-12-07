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
     * @param newTask the task to be added to the taskList.
     */
    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Remove the task with the given name from this taskList.
     * @param oldTask the task to be removed from the taskList.
     */
    public void removeTask(Task oldTask) {
        this.taskList.remove(oldTask);
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
