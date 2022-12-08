package entities;

public class Pet {

    // ==PRIVATE VARIABLES==

    // the maximum health of the pet
    private static final int MAX_HEALTH = 10;

    //the current health of the pet
    private int currHealth;

    // the name of the pet
    private final String name;

    // the string associated with the pet skin
    private final String skin;

    // the customization object which keeps track of all items,
    // the currently equipped item, and the equipment status
    private Customization customization;

    // ==CONSTRUCTORS==

    public Pet(String name, String skin){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = new Customization();
    }

    public Pet(String name, String skin, Customization customization){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = customization;
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

    public String getSkin() {
        return skin;
    }

    public Customization getCustomization() { return customization; }

    // ==SETTERS==

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public void setCustomization(Customization customization) {this.customization = customization;}

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

}
