package useCases;

import entities.*;

import javax.swing.*;

public class User implements ui.User {

    entities.User user;

    public User(entities.User user){
        this.user = user;
    }

    public User (int points, entities.Pet pet) {
        this.user = new entities.User(points, pet);
    }

    public User (int points) {
        this.user = new entities.User(points);
    }

    //default constructor with null Pet and 0 points
    public User() {
        new entities.User();
    }

    public void adoptPet(String petIcon, String petName){
        AdoptPetUC usecase = new AdoptPetUC();
        usecase.adoptPet(petIcon, petName);
        this.setPet(usecase.getPet());
    }

    public void setPet(entities.Pet pet){
        this.user.setPet(pet);
    }

    public entities.Pet getPet(){
        return this.user.getPet();
    }

    public Pet getPetUI(){
        return new Pet(this.getPet());
    }
}
