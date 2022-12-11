package databaseBoundaries;

import database.CustomizationDB;

/**
 * This class is an interface for the PetDB object
 */
public interface PetDBBoundary {

    /**
     * A Getter for the currentHealth
     * @return currHealth
     */
    int getCurr();

    /**
     * A Getter for the name
     * @return name
     */
    String getName();

    /**
     * A Getter for the skinID
     * @return skin
     */
    String getSkin();

    /**
     * A Getter for the Customization
     * @return Customization
     */
    CustomizationDB getCustomization();
}
