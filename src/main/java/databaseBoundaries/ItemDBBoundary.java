package databaseBoundaries;

/**
 * This class is an interface for the ItemDB object
 */
public interface ItemDBBoundary {

    /**
     * A Getter for the name
     * @return name
     */
    String getName();

    /**
     * A Getter for the type
     * @return type
     */
    String  getType();

    /**
     * A Getter for the price
     * @return price
     */
    int getPrice();

    /**
     * A Getter for unlocked
     * @return unlocked
     */
    boolean isUnlocked();

    /**
     * A Getter for the iconID
     * @return icon
     */
    String getIcon();
}
