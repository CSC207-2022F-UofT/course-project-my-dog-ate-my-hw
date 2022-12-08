package entities;

import java.util.ArrayList;

public class Customization {

    // ==PUBLIC ATTRIBUTES==

    // an array list of all possible items that can be equipped
    private ArrayList<Item> customizations;

    // a boolean which returns whether an item is currently equipped
    public boolean isCurrentlyEquipped;

    // the current item equipped by the pet
    public Item currentEquipment;


    // ==CONSTRUCTORS==

    public Customization(){
        this.currentEquipment = null;
        this.isCurrentlyEquipped = false;
        this.customizations = new ArrayList<>();
    }

    public Customization(Item item){
        this.currentEquipment = item;
        this.isCurrentlyEquipped = true;
    }

    // ==GETTERS==
    public boolean isCurrentlyEquipped() {
        return isCurrentlyEquipped;
    }

    public Item currentEquipment() {
        return currentEquipment;
    }

    public ArrayList<Item> possibleCustomizations() {
        return customizations;
    }


    // ==CLASS METHODS==

    public void addItem(Item item) {
        customizations.add(item);
    }

    public void removeItem(Item item) {
        customizations.remove(item);
    }

    public void dequip() {
        if (this.isCurrentlyEquipped) {
            this.currentEquipment = null;
            this.isCurrentlyEquipped = false;
        }
    }

    public void equip(Item item) {
        if (!this.isCurrentlyEquipped && item.isUnlocked()) {
            this.currentEquipment = item;
            this.isCurrentlyEquipped = true;
        }
    }

    /**
     * Search method which searches for an item name
     * @param itemName The name of the item desired
     * @return The Item object with given name stored in customization
     */
    public Item getItem(String itemName) throws AbsentItemNameException{
        for (Item item: this.customizations) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new AbsentItemNameException();
    }

}
