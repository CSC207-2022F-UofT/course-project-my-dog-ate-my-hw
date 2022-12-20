package controllers;

import useCases.ModifyTaskInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ModifyTaskController {
    private static ModifyTaskInputBoundary uc;
    public LocalDateTime deadline;
    public String name;
    public String course;
    public String priority;
    public String assignenmentType;
    public String oldName;

    public static void setUc(ModifyTaskInputBoundary useCase){ uc = useCase; }

    public ModifyTaskController(LocalDateTime deadline, String name, String course, String priority, String assignenmentType, String oldName){
        this.deadline = deadline;
        this.name = name.strip();
        this.course = course.strip();
        this.priority = priority;
        this.assignenmentType = assignenmentType;
        this.oldName = oldName.strip();
        modify();
        uc.refreshTask();
    }

    public void modify(){
        if(uc.findTask(oldName)) {
            uc.changeName(name);
            uc.changeCourse(course);
            uc.changeDeadline(deadline);
            uc.changePriority(priority);
            uc.changeAssignmentType(assignenmentType);
        }
    }

}
