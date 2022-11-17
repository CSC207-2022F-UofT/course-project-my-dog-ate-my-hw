package controllers;

import useCases.CompleteTaskUC;
import useCases.GainPointsUC;

public class CompleteTaskControl {
    String taskName;

    //returns class variable taskName
    public String getTaskName() {
        return taskName;
    }

    private void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    //activate use cases
    public void CompleteTask (String taskName) {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC(taskName);
        completeTaskUC.addToDl();
        completeTaskUC.removeFromTdl();
        GainPointsUC gainPointsUC = new GainPointsUC(completeTaskUC);
        gainPointsUC.Gain();
    }
}
