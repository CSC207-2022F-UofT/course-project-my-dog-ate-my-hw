package useCases;

import entities.AssignmentType;
import entities.CustomTask;
import entities.Priority;
import entities.Task;

import java.time.LocalDateTime;

public class ModifyTaskUC {
    private Task task;

    public ModifyTaskUC(String taskName) {
        //go through the ToDoList to find the task
        this.task = todo.searchFor(taskName);
    }

    public void changeName(String newName){
        task.setName(newName);
    }

    public void changeCourse(String course){
        task.setCourse(course);
    }

    public void changePriority(Priority priority){
        task.setPriority(priority);
    }

    public void changeDeadline(LocalDateTime date){
        task.setDeadline(date);
        task.setStudyDeadline(date);
    }

    public void changeStudyDeadline(LocalDateTime date){
        task.setStudyDeadline(date);
    }

    public void changeAssignmentType(String assignment){
        ((CustomTask) task).setAssignmentType(AssignmentType.valueOf(assignment));
    }

    public void changeStudyTechnique(String technique){

        ((CustomTask) task).setStudyTechnique(technique);
    }
}

