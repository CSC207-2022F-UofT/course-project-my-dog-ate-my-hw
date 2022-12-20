package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * A class for all the customizations a pet can have. Customizations are of type Item, and they can be added or
 * removed. A string array of all the items stored in customization can be returned.
 */
public class Customization {

    // === Public Static Class Attributes ===

    //Index for the item when the pet has no customizations
    public static final int NO_ITEM_INDEX = 0;

    //Placement item for when the pet has no customizations
    public static final Item NO_ITEM = new Item("None", "None", 0, true);

    // === Private Instance Attributes ===

    //List of all possible items that can be equipped
    private List<Item> customizations;

    //Boolean which returns whether an item is currently equipped
    private boolean isCurrentlyEquipped;

    //The current item equipped by the pet
    private Item currentEquipment;


    /**
     * Construct a Customization given no arguments. Set the currentEquipment to null, the isCurrentlyEquipped to false,
     * and the customizations list to an empty List.
     */

    public Customization(){
        this.currentEquipment = null;
        this.isCurrentlyEquipped = false;
        this.customizations = new ArrayList<>();
    }

    /**
     * Construct a customization for the pet with the given item and equip the pet with the given item. Add the given
     * item to the pet's customizations list.
     * @param item : Item to be added to the pets customizations list
     */
    public Customization(Item item){
        this.currentEquipment = item;
        this.isCurrentlyEquipped = true;
        this.customizations = new ArrayList<>(Arrays.asList(item));
    }

    /**
     * Return whether the pet is currently equipped with an item.
     * @return : True if the pet is currently equipped, false otherwise.
     */
    public boolean getIsCurrentlyEquipped() {
        return isCurrentlyEquipped;
    }

    /**
     * Return the item the pet is currently equipped with.
     * @return : An item if the pet is currently equipped, null otherwise.
     */
    public Item getCurrentEquipment() {
        return currentEquipment;
    }

    /**
     * Return the possible customizations the pet may be equipped with.
     * @return : the customizations of the pet or an empty list if the pet has no possible customizations.
     */
    public List<Item> getPossibleCustomizations() {
        return customizations;
    }


    /**
     * Add the given item to the customization list.
     * @param item : Item to be added to the customizations list.
     */
    public void addItem(Item item) {
        this.customizations.add(item);
    }

    /**
     * Add a placement empty item for when the pet has no customizations.
     */
    public void addEmptyItem(){
        customizations.add(NO_ITEM_INDEX, NO_ITEM);
        currentEquipment = NO_ITEM;
    }

    /**
     * Remove the equipment from the current pet, if the pet has an item equipped. Replace its current item with the
     * placement empty item. Do nothing if the pet has no items equipped.
     */
    public void dequip() {
        if (this.isCurrentlyEquipped) {
            this.currentEquipment = NO_ITEM;
            this.isCurrentlyEquipped = false;
        }
    }

    /**
     * Equip the customization with the given item, iff the given item is unlocked. If the customization is already
     * equipped with an item, replace that item with given item. Set isCurrentlyEquipped as true if the given item
     * is not the placement empty item, set isCurrentlyEquipped as false if the given item is the placement empty item.
     * @param item : Item given to equip the customization with.
     */
    public void equip(Item item) {
        if (item.isUnlocked()) {
            this.currentEquipment = item;
            this.isCurrentlyEquipped = !item.getName().equals(NO_ITEM.getName());
        }
    }

    /**
     * Search for an item name with a name corresponding to the given item name. Throw an AbsentItemNameException if the give name does not match any
     * items' names in customizations.
     * @param itemName : The name of the item desired
     * @return An item stored in customizations with a name corresponding to itemName.
     */
    public Item getItem(String itemName) throws AbsentItemNameException{
        for (Item item : this.customizations)
            if (item.getName().equals(itemName)) {
                return item;
            }
        throw new AbsentItemNameException();
    }

    /**
     * Return a String Array of the customizations list, containing a string representation of each item stored.
     * Each item is represented in a string containing the item's name and the item's locked status.
     * @return String Array containing the string representations of each item stored in customizations.
     */
    public String[] toStringArray(){
        String[] array = new String[customizations.size()];
        for (int i = 0; i < array.length; i++){
            Item item =  customizations.get(i);
            array[i] = item.getName() + getLockedSymbol(item.isUnlocked());
        }
        return array;
    }

    /**
     * Helper method for toStringArray. Return whether the item is locked or unlocked.
     * @param unlocked : Boolean representing the locked status of the item.
     * @return An empty string if the item is unlocked, or "(LOCKED)" if the item is locked.
     */
    private String getLockedSymbol(boolean unlocked){
        if (!unlocked) {
            return "(LOCKED)";
        } else {
            return "";
        }
    }
}
