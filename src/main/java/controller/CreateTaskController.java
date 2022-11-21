package controller;
import entities.Priority;
import useCase.CreateTaskUC;
import entities.Task;

import java.time.LocalDateTime;

public class CreateTaskController {
    Task task;

    public void PerformCreateTask(String name, String course, LocalDateTime deadline, Priority priority){
        CreateTaskUC createTaskUC = new CreateTaskUC();
        task = createTaskUC.createTask(name, course, deadline, priority);
        createTaskUC.addToTDL(task);
    }

    public CreateTaskController() {
    }

}
