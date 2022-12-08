package presenters;

import java.util.ArrayList;

public class PetVM {
    public int maxHealth;
    public int currHealth;
    public String name;
    public String skin;
    public String currCustomization;
    public ArrayList<String> customizations;

    public PetVM(int currHealth, int maxHealth, String skin, String petName, int points, String currCustomization, String[] customizations, boolean petAdopted){
        this.currHealth = currHealth;
        this.maxHealth = maxHealth;
        this.skin = skin;
        this.currCustomization = currCustomization;
        this.customizations = new ArrayList<>();

    }
}
