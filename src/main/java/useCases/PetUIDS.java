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

    public PetUIDS(entities.Pet pet){
        MAX_HEALTH = Pet.getMaxHealth();
        currHealth = pet.getCurrHealth();
        skin = pet.getSkin();
        currCustomization = pet.getCustomization().currentEquipment().getIcon();
        ArrayList<String> cus = new ArrayList<>();
        cus.add("None");
        for(entities.Item i : pet.getCustomization().possibleCustomizations())
            cus.add(i.getIcon());
        customizations = cus;
    }
}
