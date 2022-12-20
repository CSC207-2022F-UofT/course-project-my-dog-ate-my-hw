package entities;

import java.util.ArrayList;

public class Customization {

    // ==INSTANCE VARIABLES==

    public static final int NO_ITEM_INDEX = 0;
    public static final Item NO_ITEM = new Item("None", "None", 0, true);

    // an array list of all possible items that can be equipped
    private ArrayList<Item> customizations;

    // a boolean which returns whether an item is currently equipped
    private boolean isCurrentlyEquipped;

    // the current item equipped by the pet
    private Item currentEquipment;


    // ==CONSTRUCTORS==

    public Customization(){
        this.currentEquipment = null;
        this.isCurrentlyEquipped = false;
        this.customizations = new ArrayList<>();
    }

    public Customization(Item item){
        this.currentEquipment = item;
        this.isCurrentlyEquipped = true;
        this.customizations = new ArrayList<>();
        this.customizations.add(item);
    }

    // ==GETTERS==
    public boolean getIsCurrentlyEquipped() {
        return isCurrentlyEquipped;
    }

    public Item getCurrentEquipment() {
        return currentEquipment;
    }

    public ArrayList<Item> getPossibleCustomizations() {
        return customizations;
    }


    // ==CLASS METHODS==

    public void addItem(Item item) {
        if (customizations == null){
            customizations = new ArrayList<>();
        }
        customizations.add(item);
    }

    public void addEmptyItem(){
        customizations.add(NO_ITEM_INDEX, NO_ITEM);
        currentEquipment = NO_ITEM;
    }

    public void dequip() {
        if (this.isCurrentlyEquipped) {
            this.currentEquipment = NO_ITEM;
            this.isCurrentlyEquipped = false;
        }
    }

    public void equip(Item item) {
        if (item.isUnlocked()) {
            this.currentEquipment = item;
            this.isCurrentlyEquipped = !item.getName().equals(NO_ITEM.getName());
        }
    }

    /**
     * Search method which searches for an item name
     * @param itemName The name of the item desired
     * @return The Item object with given name stored in customization
     */
    public Item getItem(String itemName) throws AbsentItemNameException{
        for (Item item : this.customizations) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new AbsentItemNameException();
    }

    public String[] toStringArray(){
        String[] array = new String[customizations.size()];
        for (int i = 0; i < array.length; i++){
            Item item =  customizations.get(i);
            array[i] = item.getName() + getLockedSymbol(item.isUnlocked());
        }
        return array;
    }

    // helper for toStringArray()
    private String getLockedSymbol(boolean unlocked){
        if (!unlocked) {
            return "(LOCKED)";
        } else {
            return "";
        }
    }

}
