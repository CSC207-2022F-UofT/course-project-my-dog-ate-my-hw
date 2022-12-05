package entities;

// == the user class stores all information needed for the user ==

public class User {

    // ==PRIVATE ATTRIBUTES==
    private int points;
    private Pet myPet;
    private ToDoList todo;
    private DoneList done;

    // ==CONSTRUCTORS==

    public User (int points) {
        this.points = points;
    }

    public User (int points, Pet pet) {
        this.points = points;
        this.myPet = pet;
    }

    public User (int points, Pet pet, ToDoList todo, DoneList done) {
        this.points = points;
        this.myPet = pet;
        this.todo = todo;
        this.done = done;
    }

    // ==DEFAULT CONSTRUCTOR==

    public User() {
    }

    // ==GETTERS==

    public int getPoints(){
        return points;
    }

    public Pet getPet() {
        return myPet;
    }

    public ToDoList getTodo() {
        return this.todo;
    }

    public DoneList getDone() {
        return this.done;
    }

    // ==CLASS METHODS==

    public void GainPoints (int points) {
        this.points += points;
    }

    // user loses points; returns false if there are no enough points to lose
    public Boolean LosePoints (int points) {
        if (this.points < points) {
            return false;
        }
        this.points -= points;
        return true;
    }

    // ==SETTERS==

    public void setPet (Pet somePet) {
        this.myPet = somePet;
    }

    public void setPoints (int points) {
        this.points = points;
    }

    public void setTodo (ToDoList todo) {
        this.todo = todo;
    }

    public void setDone (DoneList done) {
        this.done = done;
    }

    //override toString method
    public String toString () {
        return "User with points: " + this.points + ", Pet: " + this.myPet.getName();
    }
}