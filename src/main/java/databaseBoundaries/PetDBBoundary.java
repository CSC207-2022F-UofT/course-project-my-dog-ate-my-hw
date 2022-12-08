package databaseBoundaries;

import database.CustomizationDB;

public interface PetDBBoundary {
    int getCurr();
    String getName();
     String getSkin();
    CustomizationDB getCustomization();
}
