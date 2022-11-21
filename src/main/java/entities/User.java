package entities;

/* We have decided that the User class does not need checklists as attributes,
* as use cases that need to access User.java only deal with points and pet*/
public class User {
    private int points;
    private Pet myPet;

    //constructors
    public User (int points) {
        this.points = points;
    }
    
    public User (int points, Pet pet) {
        this.points = points;
        this.myPet = pet;
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

    //override toString method
    public String toString () {
        return "User with points: " + this.points + ", Pet: " + this.myPet.getName();
    }
}
