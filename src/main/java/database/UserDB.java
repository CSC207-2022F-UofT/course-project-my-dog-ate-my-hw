package database;

import databaseBoundaries.TaskDBBoundary;
import databaseBoundaries.UserDBBoundary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class contains a Serializable User DB object,
 * for saving and loading the User object
 */
public class UserDB implements Serializable, UserDBBoundary {

    private static final long serialVersionUID = 543131667156700401L;

    public int points;
    public PetDB myPet;
    public ArrayList<TaskDB> toDo;
    public ArrayList<TaskDB> done;

    /**
     * Constructor: Check for User to load, if there is none,
     * than proceed with default assignments,
     * else, load and set User
     */
    public UserDB(){
        if (DataSaver.loadUser() == null){
            this.myPet = new PetDB();
            this.toDo = new ArrayList<>();
            this.done = new ArrayList<>();
        } else {
            UserDB user = DataSaver.loadUser();
            this.points = Objects.requireNonNull(user).points;
            this.myPet = user.myPet;
            this.toDo = user.toDo;
            this.done = user.done;
        }
    }

    /**
     * A Getter for myPet
     * @return myPet
     */
    public PetDB getPet(){return this.myPet;}

    /**
     * A Getter for points
     * @return points
     */
    public int getPoints(){return this.points;}

    /**
     * A Getter for ToDoList
     * @return toDo
     */
    public ArrayList<TaskDBBoundary> getToDo(){
        return new ArrayList<>(this.toDo);
    }

    /**
     * A Getter for DoneList
     * @return done
     */
    public ArrayList<TaskDBBoundary> getDone() {
        return new ArrayList<>(this.done);
    }
}
