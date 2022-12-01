package useCases;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entities.Priority;
import entities.Task;
import entities.ToDoList;
import entities.DoneList;


public class CompleteTaskUC {
    private Task task;
    /* checklists acquired from DataAccess */
    private ToDoList todo;
    private DoneList done;

    //the use case takes in a String as parameter
    public CompleteTaskUC(String taskName) {
        //go through the TODOlist to find the task
        this.task = todo.searchFor(taskName);
    }

    //Check if the task is finished before studyDeadline
    public Boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadline = task.getStudyDeadline();//StudyDeadline attribute of Task, which is a date/time
        return deadline.isAfter(now);
    }

    //return the task priority
    public Priority getPriority () {
        return task.getPriority();
    }

    //remove the task from ToDolist
    public void removeFromTdl() {
        todo.removeTask(task);
    }

    //add the task to Donelist
    public void addToDl() {
        done.addTask(task);
    }

    //return the arraylist representation of todoList
    public ArrayList<ArrayList<String>> getTodo () {
        //potential method from entity
        return todo.toList();
    }

    //return the arraylist representation of doneList
    public ArrayList<ArrayList<String>> getDone () {
        //potential method from entity
        return done.toList();
    }
}
