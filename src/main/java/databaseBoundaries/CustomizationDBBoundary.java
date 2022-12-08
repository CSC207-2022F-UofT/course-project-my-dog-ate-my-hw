package databaseBoundaries;

import java.util.ArrayList;

/**
 * This class is an interface for the CustomizationDB object
 */
public interface CustomizationDBBoundary {

    /**
     * A Getter for the customizations
     * @return customizations
     */
    ArrayList<ItemDBBoundary> getCustomizations();

    /**
     * A Getter for the currentEquipment
     * @return currentEquipment
     */
    ItemDBBoundary getCurrentEquipment();

}
