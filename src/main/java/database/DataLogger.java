package database;

import databaseBoundaries.DataLoggerBoundary;
import java.time.LocalDateTime;

/**
 * This class constructs the UserDB objects to prepare for logging the data
 */
public class DataLogger implements DataLoggerBoundary {
    UserDB user;

    /**
     * Constructor
     */
    public DataLogger(){
        this.user = new UserDB();
    }

    /**
     * Create UserDB object
     */
    public void makeUser(){this.user = new UserDB();}

    /**
     * A Setter for points
     * @param points the number of points the user has
     */
    public void setPoints(int points){
        this.user.points = points;
    }

    /**
     * Create PetDB object
     * @param currHealth the currentHealth
     * @param name the name of the pet
     * @param skin the skinID of the pet
     */
    public void makePet(int currHealth, String name, String skin){
        this.user.myPet.currHealth = currHealth;
        this.user.myPet.name = name;
        this.user.myPet.skin = skin;
    }

    /**
     * Create ItemDB object for customizations
     * @param name the name of the item
     * @param type the type of the item
     * @param price the price of the item
     * @param unlocked the lock-status of the item
     * @param icon the iconID of the item
     */
    public void addCustomization(String name, String type, int price, boolean unlocked, String icon){
        this.user.myPet.customization.customizations.add(new ItemDB(name, type, price, unlocked, icon));
    }

    /**
     * Create currentEquipment object for Customization
     * @param name the name of the current item
     * @param type the type of the current item
     * @param price the price of the current item
     * @param unlocked the lock-status of the current item
     * @param icon the iconID of the current item
     */
    public void setEquip(String name, String type, int price, boolean unlocked, String icon){
        this.user.myPet.customization.currentEquipment = new ItemDB(name, type, price, unlocked, icon);
    }

    /**
     * Create a Task object for ToDoList
     * @param deadline the deadline for the task
     * @param name the name of the task
     * @param course the task course
     * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
     * @param completion the completion-status of the course
     * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
     */
    public void addToDo(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                        String assignmentTypeString){
        this.user.toDo.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
    }

    /**
     * Create a Task object for DoneList
     * @param deadline the deadline for the task
     * @param name the name of the task
     * @param course the task course
     * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
     * @param completion the completion-status of the course
     * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
     */
    public void addDone(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                        String assignmentTypeString){
        this.user.done.add(new TaskDB(deadline, name, course, priorityString, completion, assignmentTypeString));
    }

    /**
     * Save the constructed UserDB object by calling DataSaver.saveUser()
     */
    public void saveUser(){
        DataSaver.saveUser(this.user);
    }

}
