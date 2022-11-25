package useCases;

import entities.DoneList;
import entities.Priority;
import entities.Task;
import entities.ToDoList;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
        task.setAssignmentType(assignment);
    }

    public void changeStudyTechnique(String technique){
        task.setStudyTechnique(technique);
    }
}

