package useCases;

import entities.Pet;

import javax.swing.*;

public class User extends entities.User implements ui.User {

    public User (int points) {
        super(points);
    }

    public User (int points, Pet pet) {
        super(points, pet);
    }

    //default constructor with null Pet and 0 points
    public User() {
        super();
    }

    public void adoptPet(ImageIcon petIcon, String petName){
        AdoptPetUC usecase = new AdoptPetUC();
        usecase.adoptPet(petIcon, petName);
        this.setPet(usecase.getPet());
    }

    public ui.Pet getPetUI(){
        return (ui.Pet) this.getPet();
    }
}
