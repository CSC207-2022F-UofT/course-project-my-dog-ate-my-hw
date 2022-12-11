package useCases;

import entities.Pet;

import java.util.ArrayList;

public class PetUIDS {
    public int MAX_HEALTH;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public String[] customizations;
    public int points;

    public PetUIDS(entities.Pet pet){
        points = 0; // Change to points from user
        MAX_HEALTH = Pet.getMaxHealth();
        currHealth = pet.getCurrHealth();
        skin = pet.getSkin();
        if(pet.getCustomization().currentEquipment() != null) {
            currCustomization = pet.getCustomization().currentEquipment().getName();
        } else {
            currCustomization = "None";
        }
        ArrayList<String> cus = new ArrayList<>();
        cus.add("None");
        for(entities.Item i : pet.getCustomization().possibleCustomizations())
            cus.add(i.getName());
        Object[] temp = cus.toArray();
        String[] temp2 = new String[temp.length];
        for(int i = 0; i < temp.length; i++){
            String y = temp[i].toString();
            temp2[i] = y;
        }
        customizations = temp2;
    }
}
