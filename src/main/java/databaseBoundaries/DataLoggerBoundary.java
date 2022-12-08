package databaseBoundaries;

import java.time.LocalDateTime;

/**
 * This class is an interface for the DataLogger
 */
public interface DataLoggerBoundary {

    /**
     * Create UserDB object
     */
    void makeUser();

    /**
     * A Setter for points
     * @param points the number of points the user has
     */
    void setPoints(int points);

    /**
     * Create PetDB object
     * @param currHealth the currentHealth
     * @param name the name of the pet
     * @param skin the skinID of the pet
     */
    void makePet(int currHealth, String name, String skin);

    /**
     * Create ItemDB object for customizations
     * @param name the name of the item
     * @param type the type of the item
     * @param price the price of the item
     * @param unlocked the lock-status of the item
     * @param icon the iconID of the item
     */
    void addCustomization(String name, String type, int price, boolean unlocked, String icon);

    /**
     * Create currentEquipment object for Customization
     * @param name the name of the current item
     * @param type the type of the current item
     * @param price the price of the current item
     * @param unlocked the lock-status of the current item
     * @param icon the iconID of the current item
     */
    void setEquip(String name, String type, int price, boolean unlocked, String icon);

    /**
     * Create a Task object for ToDoList
     * @param deadline the deadline for the task
     * @param name the name of the task
     * @param course the task course
     * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
     * @param completion the completion-status of the course
     * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
     */
    void addToDo(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                 String assignmentTypeString);

    /**
     * Create a Task object for DoneList
     * @param deadline the deadline for the task
     * @param name the name of the task
     * @param course the task course
     * @param priorityString the priority of the course (HIGH, MEDIUM, or LOW)
     * @param completion the completion-status of the course
     * @param assignmentTypeString the assignment type of the course (see AssignmentType enum)
     */
    void addDone(LocalDateTime deadline, String name, String course, String priorityString, boolean completion,
                 String assignmentTypeString);

    /**
     * Save the constructed UserDB object by calling DataSaver.saveUser()
     */
    void saveUser();

}
