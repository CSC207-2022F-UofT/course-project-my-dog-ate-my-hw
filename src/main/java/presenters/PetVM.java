package presenters;

import useCases.DefaultValueData;
import useCases.PetUIDS;

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
        boolean adopted = (pet.skin != null && !pet.skin.equals(DefaultValueData.DEFAULT_SKIN));
        this.currHealth = pet.currHealth;
        this.maxHealth = pet.MAX_HEALTH;
        this.name = pet.name;
        this.skin = pet.skin;
        this.currCustomization = pet.currCustomization;
        this.customizations = pet.customizations;
        this.points = pet.points;
        this.adopted = adopted;
    }

}
