package uiControllers;
import entities.AssignmentType;
import entities.Priority;
import useCases.CreateTaskUC;
import entities.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateTaskController {
    Task task;

    public void performCreateTask(String name, String course, LocalDateTime deadline, Priority priority){
        CreateTaskUC createTaskUC = new CreateTaskUC();
        task = createTaskUC.createTask(name, course, deadline, priority);
        createTaskUC.addToTDL(task);
    }

    public void performCreateTask(String name, String course, LocalDateTime deadline, Priority priority, AssignmentType assignmentType, String studyTechnique){
        CreateTaskUC createTaskUC = new CreateTaskUC();
        task = createTaskUC.createTask(name, course, deadline, priority, studyTechnique, assignmentType);
        createTaskUC.addToTDL(task);
    }

    public CreateTaskController(String name, String course, String deadline, Priority priority) {
        LocalDateTime dueDate = convertString(deadline);
        performCreateTask(name, course, dueDate, priority);
    }

    public CreateTaskController(String name, String course, String deadline, Priority priority, AssignmentType assignmentType, String studyTechnique) {
        LocalDateTime dueDate = convertString(deadline);
        performCreateTask(name, course, dueDate, priority, assignmentType, studyTechnique);
    }

    private LocalDateTime convertString(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

}
