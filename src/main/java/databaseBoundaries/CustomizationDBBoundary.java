package databaseBoundaries;

import java.util.ArrayList;

public interface CustomizationDBBoundary {
    ArrayList<ItemDBBoundary> getCustomizations();
    ItemDBBoundary getCurrentEquipment();
}
