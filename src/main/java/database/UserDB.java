package database;

import databaseBoundaries.TaskDBBoundary;
import databaseBoundaries.UserDBBoundary;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDB implements Serializable, UserDBBoundary {

    public int points;
    public PetDB myPet;
    public ArrayList<TaskDB> todo;
    public ArrayList<TaskDB> done;

    public UserDB(){
        this.myPet = new PetDB();
        this.todo = new ArrayList<>();
        this.done = new ArrayList<>();
    }

    public PetDB getPet(){return this.myPet;}

    public int getPoints(){return this.points;}

    public ArrayList<TaskDBBoundary> getTodo(){
        return new ArrayList<>(this.todo);
    }

    public ArrayList<TaskDBBoundary> getDone() {
        return new ArrayList<>(this.done);
    }
}
