package entities;

import java.util.ArrayList;
import java.util.List;

public class Customization {

    public static final int ITEM_NOT_FOUND = -1;
    public static final int ITEM_EQUIPPED = 0;
    private List<Item> customizations;

    public Customization(){
        customizations = new ArrayList<>();
        loadDefaults();
    }

    private void loadDefaults(){
        customizations.add(new Item("halo", 1));
    }

    /**
     * Search method which searches for an item name
     * @param itemName The name of the item desired
     * @return The Item object with given name stored in customization
     */
    public Item findItem(String itemName) throws AbsentItemNameException{
        for (Item item: this.customizations) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new AbsentItemNameException();
    }

    public String[] toStringArray(){
        String[] array = new String[customizations.size()];
        for(int i = 0; i < customizations.size(); i++){
            array[i] = customizations.get(i).getName();
        }
        return array;
    }
}