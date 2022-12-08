package database;

import databaseBoundaries.TaskDBBoundary;
import databaseBoundaries.UserDBBoundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class UserDB implements Serializable, UserDBBoundary {

    private static final long serialVersionUID = 1L;

    public int points;
    public PetDB myPet;
    public ArrayList<TaskDB> todo;
    public ArrayList<TaskDB> done;

    public UserDB(){
        if (DataSaver.loadUser() == null){
            this.myPet = new PetDB();
            this.todo = new ArrayList<>();
            this.done = new ArrayList<>();
        } else {
            this.points = Objects.requireNonNull(DataSaver.loadUser()).points;
            this.myPet = Objects.requireNonNull(DataSaver.loadUser()).myPet;
            this.todo = Objects.requireNonNull(DataSaver.loadUser()).todo;
            this.done = Objects.requireNonNull(DataSaver.loadUser()).done;
        }
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
