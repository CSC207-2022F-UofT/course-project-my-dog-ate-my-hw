package controllers;

import useCases.ModifyTaskInputBoundary;
import java.time.LocalDateTime;

public class ModifyTaskController {
    private static ModifyTaskInputBoundary uc;
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignmentType;
    public String oldName;

    public static void setUc(ModifyTaskInputBoundary useCase){ uc = useCase; }

    public ModifyTaskController(LocalDateTime deadline, String name, String course, String priority, String assignmentType, String oldName){
        this.deadline = deadline;
        this.name = name.strip();
        this.course = course.strip();
        this.priority = priority;
        this.assignmentType = assignmentType;
        this.oldName = oldName.strip();
        modify();
        uc.refreshTask();
    }

    public void modify(){
        if(uc.findTask(oldName)) {
            uc.modifyTask(name, course, deadline, priority, assignmentType);
        }
    }

}
