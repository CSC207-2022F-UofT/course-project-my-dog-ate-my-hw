package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ToDoList {
    // ToDoList is a public Class that contains a list of tasks that the user has yet to complete. Tasks can be added
    // or removed from this taskList, the taskList is not sorted but a sorted list based on different attributes
    // can be returned for display purposes.
    private List<Task> taskList; //A list of tasks yet to be completed by the User

    /**
     * Initialize an empty ToDOList with no tasks in its taskList.
     */
    public ToDoList() {
        this.taskList = new ArrayList();
    }

    /**
     * Add the given task to this ToDoList's taskList.
     * @param newTask
     */
    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Remove the task with the given name from this
     * @param oldTask
     */
    public void removeTask(String taskName) {
        this.taskList.remove(task);
    }

    /**
     * Randomize a task in the list
     * @return Task at random index in the taskList
     */
    public Task randomTask() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, super.getTaskList().size());
        return super.getTaskList().get(randomNum);
    }
}
