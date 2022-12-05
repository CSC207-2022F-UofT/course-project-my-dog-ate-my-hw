package uiControllers;

import useCases.CompleteTaskInputBoundary;

public class CompleteTaskControl {
    private final CompleteTaskInputBoundary completeTaskInputBoundary;

    public CompleteTaskControl(CompleteTaskInputBoundary completeTaskInputBoundary) {
        this.completeTaskInputBoundary = completeTaskInputBoundary;
    }

    public void CompleteTask(String taskName) {
        CompleteTaskInputBoundary.completeTask(taskName);
        completeTaskInputBoundary.refreshCompleteTask();
    }
}
