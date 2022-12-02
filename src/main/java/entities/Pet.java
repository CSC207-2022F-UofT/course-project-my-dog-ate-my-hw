package entities;

public class Pet {

    // ==PRIVATE ATTRIBUTES==
    
    // the maximum health of the pet
    private static final int MAX_HEALTH = 10;
    
    //the current health of the pet
    private int currHealth;
    
    // the name of the pet
    private final String name;

    // the id associated with the skin
    private final String skin;
    
    // the customization object which keeps track of all items,
    // the currently equipped item, and the equipment status
    private final Customization customization;

    // ==CONSTRUCTORS==
    
    public Pet(String name){
        this.name = name;
        this.skin = null;
        this.currHealth = MAX_HEALTH;
        this.customization = null;
    }

    public Pet(String name, String skin, Customization customization){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = customization; // Need to assign a customization (using file reading likely)
    }

    // ==GETTERS== 

    public static int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public String getName() {
        return name;
    }

    public Customization getCustomization() { return customization; }

    public String getSkin(){
        return skin;
    }

    // ==CLASS METHODS==

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
