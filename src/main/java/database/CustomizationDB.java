package database;

import databaseBoundaries.CustomizationDBBoundary;
import databaseBoundaries.ItemDBBoundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class contains a Serializable Customization DB object,
 * for saving and loading the Customization object
 */
public class CustomizationDB implements Serializable, CustomizationDBBoundary {

    private static final long serialVersionUID = -7491158844134840603L;

    public ArrayList<ItemDB> customizations;
    public ItemDB currentEquipment;

    /**
     * Constructor: Check for Customization to load, if there is none,
     * than proceed with default assignments,
     * else, load and set Customization
     */
    public CustomizationDB() {
        if (DataSaver.loadUser() == null) {
            this.customizations = new ArrayList<>();
            this.currentEquipment = null;
        } else {
            CustomizationDB customization = Objects.requireNonNull(DataSaver.loadUser()).myPet.getCustomization();
            this.customizations = customization.customizations;
            this.currentEquipment = customization.currentEquipment;
        }
    }

    /**
     * A Getter for customizations
     * @return customizations
     */
    public ArrayList<ItemDBBoundary> getCustomizations(){
        return new ArrayList<>(this.customizations);
    }

    /**
     * A Getter for currentEquipment
     * @return currentEquipment
     */
    public ItemDB getCurrentEquipment(){return this.currentEquipment;}

}
