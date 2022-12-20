package entities;

/**
 * A list of tasks completed by the user. This class extends Checklist.
 * Tasks in this list may have the same name as they are not searched for.
 */
public class DoneList extends Checklist{

    /**
     * Add the given task to the DoneList's taskList.
     * Mark the given task as completed.
     * @param task : The given task to be added to the DoneList's taskList.
     */
    @Override
    public boolean addTask(Task task) {
        task.setCompletion(true);
        return super.addTask(task);
    }
}
