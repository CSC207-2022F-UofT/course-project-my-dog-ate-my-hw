package entities;

/**
 * Entity class for the pet of the User. User's can adopt a pet. Their pet can gain health and customizations.
 * Their pet can also lose health until it dies. Pets can return their health, attributes, and customizations.
 */
public class Pet {

    // === Private Static Variable ===

    // the maximum health of the pet
    private static final int MAX_HEALTH = 10;

    // === Private Instance Attributes

    //the current health of the pet
    private int currHealth;

    // The name of the pet
    private final String name;

    // The string associated with the pet
    private final String skin;

    // The customization object which keeps track of all items this pet can be equipped, the equipped item and status
    private Customization customization;

    /**
     * Construct a pet with the given name. Give it the maximum health and a default equipment list of customizations.
     * @param name : The String representation of the given pet name.
     */
    public Pet(String name) {
        this.name = name;
        this.skin = "";
        this.currHealth = MAX_HEALTH;
        this.customization = getDefaultEquipmentList();
    }

    /**
     * Construct a pet with the given name and skin, set its health to the default maximum and set its customizations
     * the default equipment list.
     * @param name : A string representation of the name given to this pet
     * @param skin : A string representation of the skin given to this pet
     */
    public Pet(String name, String skin){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = getDefaultEquipmentList();
    }

    /**
     * Construct a pet with the given name, skin, and customization. Set its health do the default maximum health.
     * @param name : String of the given name
     * @param skin : String of the given skin
     * @param customization : Injection of the given customization
     */
    public Pet(String name, String skin, Customization customization){
        this.name = name;
        this.skin = skin;
        this.currHealth = MAX_HEALTH;
        this.customization = customization;
    }

    /**
     * Return the maximum health any pet can have.
     * @return : int representing the maximum health a pet can have
     */
    public static int getMaxHealth() {
        return MAX_HEALTH;
    }

    /**
     * Return the current health of this pet.
     * @return : int of the pet's health
     */
    public int getCurrHealth() {
        return currHealth;
    }

    /**
     * Return the name of this pet.
     * @return : string representation of this pet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the skin of this pet.
     * @return : string representation of this pet's skin
     */
    public String getSkin() {
        return skin;
    }

    /**
     * Return this pet's customizations.
     * @return : the customization of this pet.
     */
    public Customization getCustomizations() {
        return customization;
    }

    /**
     * Return the default equipment list given to a pet as its customization.
     * @return : the default customization list to give a pet.
     */
    public Customization getDefaultEquipmentList(){
        customization = new Customization();
        Item halo = new Item("Hat", "Halo", 1, false);
        customization.addEmptyItem();
        customization.addItem(halo);
        return customization;
    }

    /**
     * Set this pet's health to the given health.
     * @param currHealth : int to set the pet's health to
     */
    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    /**
     * Set this pet's customization to the given customization.
     * @param customization : customization to give this pet
     */
    public void setCustomization(Customization customization) {
        this.customization = customization;
    }

    /**
     * Heal this pet by increasing its health by the given amount. The pet's health can be increased up to the
     * maximum health a pet can have.
     * @param healedHealth : the amount by which to increase this pet's health.
     */
    public void heal(int healedHealth){
        currHealth += healedHealth;
        if (currHealth > MAX_HEALTH){
            currHealth = MAX_HEALTH;
        }
    }

    /**
     * Hurt this pet by removing the given amount from this pet's health.
     * @param removedHealth : the amount by which to decrease this pet's health.
     */
    public void ouch(int removedHealth){
        currHealth -= removedHealth;
        if (currHealth < 0){
            currHealth = 0;
        }
    }
}
