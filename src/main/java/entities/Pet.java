package entities;

import javax.swing.*;

public class Pet {

    /* CLASS VARIABLES */

    private static final int MAX_HEALTH = 10;
    private int currHealth;
    private final String name;
    private final ImageIcon skin;
    private final Customization[] customizations;
    private Hat hat;


    /* CONSTRUCTORS */

    public Pet(String name, ImageIcon skin, Customization[] customizations){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customizations = null; // Need to assign a list of available customization (using file reading likely)
    }


    /* GETTERS */

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

    public Hat getHat() {
        return hat;
    }

    public Customization[] getCustomizations() {
        return customizations;
    }


    /* SETTERS */

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public void equipHat(Hat hat){
        this.hat = hat;
    }


    /* CLASS METHODS */

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

}
