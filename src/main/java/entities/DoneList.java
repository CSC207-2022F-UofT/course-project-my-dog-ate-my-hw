package entities;

public class DoneList extends Checklist{
    /**
     * A list of tasks completed by the user. This class extends Checklist.
     * Tasks in this list may have the same name as they are not searched for.
     */

    @Override
    public boolean addTask(Task task) {
        task.setCompletion(true);
        return super.addTask(task);
    }
}
