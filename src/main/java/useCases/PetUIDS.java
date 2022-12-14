package useCases;

import entities.Pet;
import entities.User;

import java.util.ArrayList;

public class PetUIDS {

    // ==DEFAULT VALUES==
    public static final String DEFAULT_CURR_CUSTOM = "";
    public static final String DEFAULT_NAME = "Name";
    public static final int DEFAULT_HEALTH = 10;
    public static final String DEFAULT_SKIN = "None";
    public static final String[] DEFAULT_CUSTOMS = {"None"};
    public static final int DEFAULT_POINTS = 0;

    // ==INSTANCE VARIABLES==
    public int MAX_HEALTH;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public String[] customizations;
    public int points;

    public PetUIDS(entities.Pet pet, User user) {
        MAX_HEALTH = Pet.getMaxHealth();
        if (user != null) {
            points = user.getPoints();
        } else {
            points = DEFAULT_POINTS;
        }
        if (pet != null) {
            currHealth = pet.getCurrHealth();
            skin = pet.getSkin();
            name = pet.getName();
            customizations = pet.getCustomizations().toStringArray();
            if (pet.getEquippedItem() != null) {
                currCustomization = pet.getEquippedItem().getName();
            } else {
                currCustomization = DEFAULT_CURR_CUSTOM;
            }
        } else {
            currCustomization = DEFAULT_CURR_CUSTOM;
            currHealth = DEFAULT_HEALTH;
            skin = DEFAULT_SKIN;
            name = DEFAULT_NAME;
            customizations = DEFAULT_CUSTOMS;
        }
    }
}
