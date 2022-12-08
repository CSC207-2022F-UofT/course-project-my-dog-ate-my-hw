package presenters;

import useCases.PetUIDS;

import java.util.ArrayList;

public class PetVM {
    public int maxHealth;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public String[] customizations;
    public int points;
    public boolean adopted;

    public PetVM(PetUIDS pet){
        PetVM(
                pet.currHealth,
                pet.MAX_HEALTH,
                pet.skin,
                pet.name,
                pet.points,
                pet.currCustomization,
                pet.customizations,
                true
        );
    }

    public PetVM(int currHealth, int maxHealth, String skin, String petName, int points, String currCustomization, String[] customizations, boolean petAdopted){
        this.currHealth = currHealth;
        this.maxHealth = maxHealth;
        this.skin = skin;
        this.currCustomization = currCustomization;
        this.customizations = customizations;
        this.points = points;
        this.adopted = petAdopted;
    }
}
