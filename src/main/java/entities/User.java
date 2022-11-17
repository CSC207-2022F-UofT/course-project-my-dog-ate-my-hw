package entities;
import entities.Pet;

public class User {
    private int Points;
    private Pet MyPet;

    //constructors
    public User (int points) {
        this.Points = points;
    }

    public User (int points, Pet pet) {
        this.Points = points;
        this.MyPet = pet;
    }

    //default constructor with null Pet and 0 points
    public User() {
    }

    //getter methods
    public int getPoints(){
        return Points;
    }

    public Pet getPet() {
        return MyPet;
    }

    //use gains points
    public void GainPoints (int points) {
        Points += points;
    }

    //user loses points; returns false if there are no enough points to lose
    public Boolean LosePoints (int points) {
        if (Points < points) {
            return false;
        }
        Points -= points;
        return true;
    }

    //setter methods
    public void setPet (Pet somePet) {
        this.MyPet = somePet;
    }

    public void setPoints (int points) {
        this.Points = points;
    }

    //override toString method
    public String toString () {
        return "User with points: " + this.Points + ", Pet: " + this.MyPet.getName();
    }
}
