package useCases;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import database.DataHandler;
import entities.*;

public class CompleteTaskUC {
    private Task task;
    //userUC is responsible for loading and saving data
    private UserUC userUC;
    private User user;

    //the use case takes in a String as parameter
    public CompleteTaskUC(String taskName) throws IOException {
        //go through the TODOlist to find the task
        this.userUC = new UserUC(new DataHandler("src/main/java/database/Database.txt"));
        this.user = userUC.getUser();
        this.task = user.getTodo().searchFor(taskName);
    }

    //Check if the task is finished before studyDeadline
    public boolean finishedBeforeDDL () {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadline = task.getStudyDeadline();//StudyDeadline attribute of Task, which is a date/time
        return (deadline.compareTo(now)>=0);
    }

    //return the task priority
    public Priority getPriority () {
        return task.getPriority();
    }

    //remove the task from ToDolist
    public void removeFromTdl() {
        user.getTodo().removeTask(task);
    }

    //add the task to Donelist
    public void addToDl() {
        user.getDone().addTask(task);
    }

    //invoke UserUC to save data
    public void save() {

    }

    /*
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

     */
}
