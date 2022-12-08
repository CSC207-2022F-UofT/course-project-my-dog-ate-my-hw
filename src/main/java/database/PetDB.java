package database;

import databaseBoundaries.PetDBBoundary;

import java.io.Serializable;

public class PetDB implements Serializable, PetDBBoundary {
    public int curr;
    public String name;
    public  String skin;
    public CustomizationDB customization;

    public PetDB(){
        customization = new CustomizationDB();
    }

    public int getCurr(){return this.curr;}
    public String getName(){return this.name;}
    public  String getSkin(){return this.skin; }
    public CustomizationDB getCustomization(){return this.customization;}
}
