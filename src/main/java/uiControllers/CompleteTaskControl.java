package uiControllers;

import useCases.CompleteTaskUC;
import useCases.GainPointsUC;

public class CompleteTaskControl {
    //the UI passed the Task name to controller
    String taskName;

    //returns class variable taskName
    public String getTaskName() {
        return taskName;
    }

    private void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public CompleteTaskControl (String taskName) {
        this.taskName = taskName;
    }

    //activate use cases
    public void CompleteTask () {
        CompleteTaskUC completeTaskUC = new CompleteTaskUC(taskName);
        completeTaskUC.addToDl();
        completeTaskUC.removeFromTdl();
        GainPointsUC gainPointsUC = new GainPointsUC(completeTaskUC);
        gainPointsUC.Gain();
    }

}
