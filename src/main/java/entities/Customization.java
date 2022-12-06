package entities;

import java.util.ArrayList;
import java.util.List;

public class Customization {

    // ==PUBLIC ATTRIBUTES==

    // an array list of all possible items that can be equipped
    private ArrayList<Item> customizations;

    // a boolean which returns whether an item is currently equipped
    public boolean is_currently_equipped;

    // the current item equipped by the pet
    public Item current_equipment;


    // ==CONSTRUCTORS==

    public Customization(){
        this.current_equipment = null;
        this.is_currently_equipped = false;
        this.customizations = new ArrayList<>();
    }

    public Customization(Item item){
        this.current_equipment = item;
        this.is_currently_equipped = true;
    }

    // ==GETTERS==
    public boolean isCurrentlyEquipped() {
        return is_currently_equipped;
    }

    public Item currentEquipment() {
        return current_equipment;
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
        if (this.is_currently_equipped) {
            this.current_equipment = null;
            this.is_currently_equipped = false;
        }
    }

    public void equip(Item item) {
        if (!this.is_currently_equipped && item.isUnlocked()) {
            this.current_equipment = item;
            this.is_currently_equipped = true;
        }
    }

    /**
     * Search method which searches for an item name
     * @param itemName The name of the item desired
     * @return The Item object with given name stored in customization
     */
    public Item getItem(String itemName) {
        for (Item item: this.customizations) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

}
