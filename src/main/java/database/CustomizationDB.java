package database;

import databaseBoundaries.CustomizationDBBoundary;
import databaseBoundaries.ItemDBBoundary;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomizationDB implements Serializable, CustomizationDBBoundary {
    public ArrayList<ItemDB> customizations;
    // the current item equipped by the pet
    public ItemDB current_equipment;

    public CustomizationDB(){
        this.customizations = new ArrayList<>();
        this.current_equipment = null;
    }

    public ArrayList<ItemDBBoundary> getCustomizations(){
        return new ArrayList<>(this.customizations);
    }

    public ItemDB getCurrentEquipment(){return this.current_equipment; }
}
