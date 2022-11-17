package entities;

public class User {
    int Points;
    Pet MyPet;

    public User (int points) {
        this.Points = points;
    }
    
    public User (int points, Pet pet) {
        this.Points = points;
        this.MyPet = pet;
    }
    
    public int getPoints(){
        return Points;
    }

    public Pet getPet() {
        return MyPet;
    }
    
    // TODO: UNCOMMENT WHEN TODOlist and DONElist entities are merged into main
    
    // public Checklist getTODOlist() {
    //     return TODOlist;
    // }
    
    // public Checklist getDONElist() {
    //     return DONElist;
    // }

    public void GainPoints (int points) {
        Points += points;
    }

    public Boolean LosePoints (int points) {
        if (Points < points) {
            return false;
        }
        Points -= points;
        return true;
    }

    public void setPet (Pet somePet) {
        this.MyPet = somePet;
    }

    public String toString () {
        return "User with points: " + this.Points + ", Pet: " + this.MyPet.getName();
    }
}
