package entities;

import java.util.List;

//the user class stores all information needed for the user
public class User {
    private int points;
    private Pet myPet;
    private ToDoList todo;
    private DoneList done;

    //constructors
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

    //default constructor with null Pet and 0 points
    public User() {
    }

    //getter methods
    public int getPoints(){
        return points;
    }

    public Pet getPet() {
        return myPet;
    }

    public List<Task> getToDo() {
        return this.todo.getTaskList();
    }

    public List<Task> getDone() {
        return this.done.getTaskList();
    }

    //user gains points
    public void GainPoints (int points) {
        this.points += points;
    }

    //user loses points; returns false if there are no enough points to lose
    public Boolean LosePoints (int points) {
        if (this.points < points) {
            return false;
        }
        this.points -= points;
        return true;
    }

    //setter methods
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