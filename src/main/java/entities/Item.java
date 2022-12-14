package entities;

public class Item {

    // ==PRIVATE VARIABLES==

    // a String representing the Item name
    private final String name;

    // an int representing the Item cost
    private final int price;

    // a boolean representing whether the Item has been bought
    private boolean unlocked;

    // ==CONSTRUCTORS==

    public Item(String name, int price){
        this.name = name;
        this.price = price;
        unlocked = false;
    }

    // ==GETTERS==

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isUnlocked() {
        return unlocked;
    }


    // ==CLASS METHODS==

    public void Unlock() {
        this.unlocked = true;
    }

    /**
     * Compares Items based on their names
     * @param obj object being compared to this Item
     * @return true if both objects are Items with the same name
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            return ((Item) obj).getName().equals(name);
        }
        return false;
    }
}
