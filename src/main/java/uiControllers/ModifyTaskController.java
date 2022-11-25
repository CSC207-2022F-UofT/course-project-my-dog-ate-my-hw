package uiControllers;
import entities.Priority;
import useCases.ModifyTaskUC;

import java.time.LocalDateTime;

public class ModifyTaskController {
    String taskName;
    String buttonLabel;

    public ModifyTaskController (String taskName) {
        this.taskName = taskName;
    }

    public void modifyTask(String change) {
        ModifyTaskUC modifyTaskUC = new ModifyTaskUC(taskName);
        switch (buttonLabel){
            case "Change Deadline":
                modifyTaskUC.changeDeadline(LocalDateTime.parse(change));
            case "Change Study Deadline":
                modifyTaskUC.changeStudyDeadline(LocalDateTime.parse(change));
            case "Change Course Name":
                modifyTaskUC.changeCourse(change);
            case "Change Task Name":
                modifyTaskUC.changeName(change);
            case "Change Assignment Type":
                modifyTaskUC.changeAssignmentType(change);
            case "Change Study Technique":
                modifyTaskUC.changeStudyTechnique(change);
            case "Change Priority":
                modifyTaskUC.changePriority(Priority.valueOf(change));
        }
    }
}
