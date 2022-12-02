package controllers;
import useCases.CreateTaskUC;
import entities.Task;

public class CreateTaskControl {
    Task task;

    public Task getTask() {
        return task;
    }

    private void setTask (Task task) {
        this.task = task;
    }

    public CreateTaskControl (Task task) {
        this.task = task;
    }

    public void createTask () {
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.addToTDL(task);
    }

}
