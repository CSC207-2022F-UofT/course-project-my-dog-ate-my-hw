package controllers;

import useCases.CompleteTaskUC;
import useCases.GainPointsUC;

public class CompleteTaskControl {
    Task task;

    //returns class variable taskName
    public Task getTask() {
        return task;
    }

    private void setTask (Task task) {
        this.task = task;
    }

    public CompleteTaskControl (Task task) {
        this.task = task;
    }
    //activate use cases
    public void CompleteTask () {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC(task);
        completeTaskUC.addToDl();
        completeTaskUC.removeFromTdl();
        GainPointsUC gainPointsUC = new GainPointsUC(completeTaskUC);
        gainPointsUC.Gain();
    }
}
