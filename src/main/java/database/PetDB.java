package database;

import databaseBoundaries.PetDBBoundary;

import java.io.Serializable;
import java.util.Objects;

public class PetDB implements Serializable, PetDBBoundary {

    private static final long serialVersionUID = 2L;

    public int curr;
    public String name;
    public  String skin;
    public CustomizationDB customization;

    public PetDB(){
        if (DataSaver.loadUser() == null){
            customization = new CustomizationDB();
        } else {
            this.curr = Objects.requireNonNull(DataSaver.loadUser()).myPet.curr;
            this.name = Objects.requireNonNull(DataSaver.loadUser()).myPet.name;
            this.skin = Objects.requireNonNull(DataSaver.loadUser()).myPet.skin;
            this.customization = Objects.requireNonNull(DataSaver.loadUser()).myPet.getCustomization();
        }
    }

    public int getCurr(){return this.curr;}
    public String getName(){return this.name;}
    public  String getSkin(){return this.skin; }
    public CustomizationDB getCustomization(){return this.customization;}
}
