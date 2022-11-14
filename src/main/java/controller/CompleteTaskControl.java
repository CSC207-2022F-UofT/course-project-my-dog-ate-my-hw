package controller;

import UseCases.CompleteTask;
import UseCases.GainPoints;

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
        CompleteTask completeTask = new CompleteTask(taskName);
        completeTask.addToDl();
        completeTask.removeFromTdl();
        GainPoints gainPoints = new GainPoints();
        gainPoints.Gain();
    }
}
