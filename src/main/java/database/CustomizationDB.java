package database;

import databaseBoundaries.CustomizationDBBoundary;
import databaseBoundaries.ItemDBBoundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CustomizationDB implements Serializable, CustomizationDBBoundary {

    private static final long serialVersionUID = 3L;

    public ArrayList<ItemDB> customizations;
    public ItemDB currentEquipment;

    public CustomizationDB() {
        if (DataSaver.loadUser() == null) {
            this.customizations = new ArrayList<>();
            this.currentEquipment = null;
        } else {
            this.customizations = Objects.requireNonNull(DataSaver.loadUser()).myPet.customization.customizations;
            this.currentEquipment = Objects.requireNonNull(DataSaver.loadUser()).myPet.customization.currentEquipment;
        }
    }

    public ArrayList<ItemDBBoundary> getCustomizations(){
        return new ArrayList<>(this.customizations);
    }

    public ItemDB getCurrentEquipment(){return this.currentEquipment;}

}
