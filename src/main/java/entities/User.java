package entities;

//the user class stores all information needed for the user
public class User {
    private int points;
    private Pet myPet;
    private ToDoList todo;
    private DoneList done;

    /**
     * Constructor that takes in points as parameter
     * @param points The points of the user
     */
    public User (int points) {
        this.points = points;
    }

    /**
     * Constructor that takes in points and a pet as parameter
     * @param points The points of the user
     * @param pet The pet of the user
     */
    public User (int points, Pet pet) {
        this.points = points;
        this.myPet = pet;
    }

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
     * Default constructor with 0 points and null pet
     */
    public User() {
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
    public void GainPoints (int points) {
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
    public boolean LosePoints (int points) {
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

    /**
     * Setter for the points of the user
     * @param points The points to set
     */
    public void setPoints (int points) {
        this.points = points;
    }

    /**
     * Setter for the todo list of the user
     * @param todo The todolist to set
     */
    public void setTodo (ToDoList todo) {
        this.todo = todo;
    }

    /**
     * Setter for the done list of the user
     * @param done the done list to set
     */
    public void setDone (DoneList done) {
        this.done = done;
    }

    /**
     * Turn the user into a string
     * @return A String that contains the user's points and pet's name
     */
    public String toString () {
        return "User with points: " + this.points + ", Pet: " + this.myPet.getName();
    }
}