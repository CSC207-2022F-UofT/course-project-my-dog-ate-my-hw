package entities;

import javax.swing.*;

public class Pet {


    // ==PRIVATE VARIABLES==
    
    // the maximum health of the pet
    private static final int MAX_HEALTH = 10;
    //the current health of the pet
    private int currHealth;
    // the name of the pet
    private final String name;
    // the imageicon associated with the pet
    private final ImageIcon skin;
    private Hat hat;
    
    // the customization object which keeps track of all items,
    // the currently equipped item, and the equipement status
    private final Customization customization;


    // ==CONSTRUCTORS==

    public Pet(String name, ImageIcon skin){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = null; // Need to assign a customization (using file reading likely)
    }

    // ==GETTERS== 

    public static int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getSkin() {
        return skin;
    }


    // ==SETTERS==

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }


    // ==CLASS METHODS==

    public void heal(int healedHealth){
        currHealth += healedHealth;
        if (currHealth > MAX_HEALTH){
            currHealth = MAX_HEALTH;
        }
    }

    public void ouch(int removedHealth){
        currHealth -= removedHealth;
        if (currHealth < 0){
            currHealth = 0;
        }
    }

    // Need some function to assign customizations a value, create Customization list from file or something

    @Override
    public String toString() {
        return name + ": " + currHealth + " hearts";
    }
}
