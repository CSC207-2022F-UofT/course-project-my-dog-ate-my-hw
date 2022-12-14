package controllers;

import useCases.inputBoundaries.CompleteTaskInputBoundary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteTaskController implements ActionListener {

    private static CompleteTaskInputBoundary uc;
    private final String taskName;
    public static void setUc(CompleteTaskInputBoundary useCase){
        uc = useCase;
    }

    public CompleteTaskController(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        uc.completeTask(taskName);
        uc.refreshCompleteTask();
    }
}
