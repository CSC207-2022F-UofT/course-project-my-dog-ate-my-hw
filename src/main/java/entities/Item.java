package entities;

/**
 * A class representing an Item that the Pet can be customized with. Items have a name, type, price, and are locked or
 * unlocked depending on the User's number of points. Items compose the Customizations of the Pet.
 */
public class Item {

    // === Private Instance Attributes ===
    // A String representing the Item name
    private final String name;

    // A String representing the Item type (e.g., Hat)
    private final String type;

    // An int representing the Item cost
    private final int price;

    // A boolean representing whether the Item has been bought
    private boolean unlocked;

    // A String representing the Item icon (clean architecture?)
    private final String icon;

    /**
     * Construct an item with the given instance attributes including an icon.
     * @param type : A String representation of the type of the Item.
     * @param name : A String representation of the name of the Item.
     * @param price : An int representing the price of the Item.
     * @param icon : A string representation of the Item's icon.
     * @param unlocked : True if the item is unlocked, false otherwise.
     */
    // a String representing the Item icon (clean architecture?)
    private String icon;


    // ==CONSTRUCTORS==

    public Item() {
        this.price = 1;
        this.unlocked = false;
    }

    public Item(String type, String name, int price, boolean unlocked) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
    }

    public Item(String type, String name, int price, String icon, boolean unlocked) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
        this.icon = icon;
    }

    /**
     * Set the item's locked status to the given status.
     * @param unlocked : true if the item is unlocked and false otherwise.
     */
    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    /**
     * Return this Item's name
     * @return : String representing the Item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return this Item's type
     * @return : String representing the Item's type
     */
    public String getType() {
        return type;
    }

    /**
     * Return this Item's price.
     * @return : int representing the Item's Price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return whether this item is unlocked by the User.
     * @return : True if the item is unlocked, false if it is locked.
     */
    public boolean isUnlocked() {
        return unlocked;
    }

    /**
     * Return the string representation of this Item's icon.
     * @return : A string representing this item's icon or null if the icon was never initialized.
     */
    public String getIcon() {
        return icon;
    }
}