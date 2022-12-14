package entities;

public class Pet {


    // ==PRIVATE VARIABLES==

    // the maximum health of the pet
    private static final int MAX_HEALTH = 10;

    //the current health of the pet
    private int currHealth;

    // the name of the pet
    private final String name;

    // the string associated with the pet
    private final String skin;

    private Item equippedItem;

    private final Customization customizations;


    // ==CONSTRUCTORS==

    public Pet(String name, String skin){
        this.name = name;
        this.skin = skin;
        currHealth = MAX_HEALTH;
        equippedItem = null;
        customizations = new Customization();
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

    public Item getEquippedItem(){
        return equippedItem;
    }

    public Customization getCustomizations() {
        return customizations;
    }


    // ==SETTERS==

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }


    // ==CLASS METHODS==

    /**
     * Adds inputted value to pet's currHealth, to a maximum of MAX_HEALTH.
     * @param healedHealth the value to be added to the pet's health
     */
    public void heal(int healedHealth){
        currHealth += healedHealth;
        if (currHealth > MAX_HEALTH){
            currHealth = MAX_HEALTH;
        }
    }

    /**
     * Subtracts inputted value from pet's currHealth, to a minimum of 0.
     * @param removedHealth the value to be subtracted from the pet's health
     */
    public void ouch(int removedHealth){
        currHealth -= removedHealth;
        if (currHealth < 0){
            currHealth = 0;
        }
    }

    public void fullyHeal(){
        currHealth = MAX_HEALTH;
    }

    /**
     * Dequips the currently equipped Item
     */
    public void dequip() {
        if(equippedItem != null){
            this.equippedItem = null;
        }
    }

    /**
     * Equips the item with the inputted name to the pet, if it exists and is unlocked.
     * Returns a value that can be used to verify success based on the constants in CustomizationList.
     *
     * @param itemName the name of the item to be equipped
     * @return -1 if item is not in list, 0 if it is unlocked, price if it is locked.
     */
    public int equip(String itemName) {
        try {
            Item item = customizations.findItem(itemName);
            if(item.isUnlocked()){
                equippedItem = item;
                return Customization.ITEM_EQUIPPED;
            } else {
                return item.getPrice();
            }
        } catch (AbsentItemNameException e) {
            return Customization.ITEM_NOT_FOUND;
        }
    }
}