package entities;

public interface Checklist {
    /**
     * Interface Checklist will be implemented by lists that contain tasks and can be manipulated.
     */

    void addTask(Task task);
    //Add the given task to a list of tasks

    void removeTask(Task task);
    //Remove the given task from a list of tasks

    Task searchFor(String taskName);
    //Return the task that has a name matching taskName, taskName is unique to the tasks in this list of tasks

 }