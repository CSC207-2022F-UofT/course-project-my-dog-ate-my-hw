package databaseBoundaries;

import java.util.ArrayList;

/**
 * This class is an interface for the UserDB object
 */
public interface UserDBBoundary {

    /**
     * A Getter for the Pet object
     * @return pet
     */
    PetDBBoundary getPet();

    /**
     * A Getter for the points
     * @return points
     */
    int getPoints();

    /**
     * A Getter for the ToDoList object
     * @return toDo
     */
    ArrayList<TaskDBBoundary> getToDo();

    /**
     * A Getter for the DoneList object
     * @return done
     */
    ArrayList<TaskDBBoundary> getDone();

}
