package uiControllers;
import entities.AssignmentType;
import entities.Priority;
import useCases.CreateTaskUC;

import java.time.LocalDateTime;

public class CreateTaskControl {
    String name;
    String course;
    LocalDateTime deadline;
    Priority priority;
    String studyTechniques;
    AssignmentType assignmentType;

    public String getTaskName() {
        return name;
    }
    private void setTaskName (String taskName) {
        this.name = taskName;
    }

    public CreateTaskControl (String name, String course, LocalDateTime deadline, Priority priority, String studyTechniques, AssignmentType assignmentType) {
        this.name = name;
        this.course = course;
        this.assignmentType = assignmentType;
        this.deadline = deadline;
        this.priority = priority;
        this.studyTechniques = studyTechniques;
    }

    public void createTask () {
        CreateTaskUC createTaskUC = new CreateTaskUC();
        createTaskUC.addToTDL(createTaskUC.createTask(name, course, deadline, priority, studyTechniques, assignmentType));
    }
}
