package database;

import databaseBoundaries.ItemDBBoundary;
import java.io.Serializable;

/**
 * This class contains a Serializable Item DB object,
 * for saving and loading the Item object
 */
public class ItemDB implements Serializable, ItemDBBoundary {

    private static final long serialVersionUID = -4326215920871702507L;

    public String name;
    public String type;
    public int price;
    public boolean unlocked;
    public String icon;

    /**
     * Assign default values for Task, since it is contained within the Customization DB
     */
    public ItemDB(String name, String type, int price, boolean unlocked, String icon){
        this.name = name;
        this.type = type;
        this.price = price;
        this.unlocked = unlocked;
        this.icon = icon;
    }

    /**
     * A Getter for name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     * A Getter for type
     * @return type
     */
    public String  getType(){return this.type;}

    /**
     * A Getter for price
     * @return price
     */
    public int getPrice(){return this.price;}

    /**
     * A Getter for unlocked
     * @return unlocked
     */
    public boolean isUnlocked(){return this.unlocked;}

    /**
     * A Getter for icon
     * @return icon
     */
    public String getIcon(){return this.icon;}

}
