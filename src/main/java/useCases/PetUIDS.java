package useCases;

import entities.Pet;
import entities.User;
import useCases.interactors.UserUC;

public class PetUIDS {

    // ==INSTANCE VARIABLES==
    public int MAX_HEALTH;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public String[] customizations;
    public int points;

    public PetUIDS(Pet pet, User user) {
        MAX_HEALTH = Pet.getMaxHealth();
        if (user != null) {
            points = user.getPoints();
        } else {
            points = DefaultValueData.DEFAULT_POINTS;
        }
        if (pet != null) {
            currHealth = pet.getCurrHealth();
            skin = pet.getSkin();
            name = pet.getName();
            customizations = pet.getCustomizations().toStringArray();
            if (pet.getCustomizations().getCurrentEquipment() != null) {
                currCustomization = pet.getCustomizations().getCurrentEquipment().getName();
            }
            else {
                currCustomization = DefaultValueData.DEFAULT_CURR_CUSTOM;
            }
        } else {
            currCustomization = DefaultValueData.DEFAULT_CURR_CUSTOM;
            currHealth = DefaultValueData.DEFAULT_HEALTH;
            skin = DefaultValueData.DEFAULT_SKIN;
            name = DefaultValueData.DEFAULT_NAME;
            customizations = DefaultValueData.DEFAULT_CUSTOMS;
        }
    }

    private PetUIDS(){
        currCustomization = DefaultValueData.DEFAULT_CURR_CUSTOM;
        currHealth = DefaultValueData.DEFAULT_HEALTH;
        skin = DefaultValueData.DEFAULT_SKIN;
        name = DefaultValueData.DEFAULT_NAME;
        customizations = DefaultValueData.DEFAULT_CUSTOMS;
        MAX_HEALTH = Pet.getMaxHealth();
        points = DefaultValueData.DEFAULT_POINTS;
    }

    public static PetUIDS makeDefaultPet(){
        return new PetUIDS();
    }

    public static PetUIDS getCurrentPet(){
        User user = UserUC.u();
        Pet pet = user.getPet();
        return new PetUIDS(pet, user);
    }
}
