package useCases;

import entities.*;

import javax.swing.*;

public class Pet implements ui.Pet{

    entities.Pet pet;

    public Pet(entities.Pet pet){
        this.pet = pet;
    }

    public Pet(String name, String skin, Customization customization){
        this.pet = new entities.Pet(name, skin, customization);
    }

    public Pet(String name){
        this.pet = new entities.Pet(name);
    }

    public int getMaxHealthUI(){
        return 10;
    }

    public int getCurrHealth(){
        return pet.getCurrHealth();
    }


}
