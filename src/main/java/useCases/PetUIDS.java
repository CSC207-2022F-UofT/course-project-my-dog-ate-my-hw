package useCases;

import entities.Pet;

import java.util.ArrayList;

public class PetUIDS {
    public int MAX_HEALTH;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public ArrayList<String> customizations;
    public int points;

    public PetUIDS(entities.Pet pet){
        points = 0; // Change to points from user
        MAX_HEALTH = Pet.getMaxHealth();
        currHealth = pet.getCurrHealth();
        skin = pet.getSkin();
        currCustomization = pet.getCustomization().currentEquipment().getName();
        ArrayList<String> cus = new ArrayList<>();
        cus.add("None");
        for(entities.Item i : pet.getCustomization().possibleCustomizations())
            cus.add(i.getName());
        customizations = cus;
    }
}
