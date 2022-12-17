package useCases;

import entities.Customization;
import entities.Pet;
import entities.User;

public class PetUIDS {
    // ==DEFAULT VALUES==
    public static final String DEFAULT_CURR_CUSTOM = Customization.NO_ITEM.getName();
    public static final String DEFAULT_NAME = "Name";
    public static final int DEFAULT_HEALTH = 10;
    public static final String DEFAULT_SKIN = "";
    public static final String[] DEFAULT_CUSTOMS = {DEFAULT_CURR_CUSTOM};
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
            if (pet.getCustomizations().getCurrentEquipment() != null) {
                currCustomization = pet.getCustomizations().getCurrentEquipment().getName();
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
