package entities;

/**
 * User entity class that stores all the information needed for the user of the program.
 */
public class User {

    // === Private Instance Attributes ===

    // The number of points this user has
    private int points;

    // The pet that this user adopted
    private Pet myPet;

    // The To-Do list for this user
    private final ToDoList todo;

    // The Done list for this user
    private final DoneList done;

    /**
     * Constructor that takes in points, pet and checklists of the user
     * @param points Points of the user
     * @param pet Pet of the user
     * @param todo Todo List of the user
     * @param done Done List of the user
     */
    public User (int points, Pet pet, ToDoList todo, DoneList done) {
        this.points = points;
        this.myPet = pet;
        this.todo = todo;
        this.done = done;
    }

    /**
     * Getter for points
     * @return Points
     */
    public int getPoints(){
        return points;
    }

    /**
     * Getter for the pet
     * @return Pet
     */
    public Pet getPet() {
        return myPet;
    }

    /**
     * Getter for Todo List
     * @return Todo
     */
    public ToDoList getToDo() {
        return this.todo;
    }

    /**
     * Getter for Done List
     * @return Done list
     */
    public DoneList getDone() {
        return this.done;
    }

    /**
     * The user gains points
     * @param points Number of points to add
     */
    public void gainPoints (int points) {
        this.points += points;
    }

    /**
     * The user loses points
     * If the user does not have enough points, returns a false boolean
     * If the user has enough points, returns true and deducts points
     *
     * @param points Points to lose
     * @return Boolean that represents whether the user has enough points to lose or not
     */
    public boolean losePoints(int points) {
        if (this.points < points) {
            return false;
        }
        this.points -= points;
        return true;
    }

    /**
     * Setter for the pet of the user
     * @param somePet The pet to set
     */
    public void setPet (Pet somePet) {
        this.myPet = somePet;
    }
}