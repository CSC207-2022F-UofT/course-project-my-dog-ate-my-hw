package Entities;
import Entities.Pet;

public class User {
    int Points;
    Pet MyPet;
    Checklist TODOlist;
    Checklist DONElist;

    public int getPoints(){
        return Points;
    }

    public Pet getPet() {
        return MyPet;
    }

    public Checklist getTODOlist() {
        return TODOlist;
    }

    public Checklist getDONElist() {
        return DONElist;
    }

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

    public void setTODOlist (Checklist someList) {
        this.TODOlist = someList;
    }

    public void setDONElist (Checklist someList) {
        this.DONElist = someList;
    }
}
