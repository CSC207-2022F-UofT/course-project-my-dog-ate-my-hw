package database;

import databaseBoundaries.PetDBBoundary;
import java.io.Serializable;
import java.util.Objects;

/**
 * This class contains a Serializable Pet DB object,
 * for saving and loading the Pet object
 */
public class PetDB implements Serializable, PetDBBoundary {

    private static final long serialVersionUID = 3784328802611307220L;

    public int currHealth;
    public String name;
    public  String skin;
    public CustomizationDB customization;

    /**
     * Constructor: Check for Pet to load, if there is none,
     * than proceed with default assignments,
     * else, load and set Pet
     */
    public PetDB(){
        if (DataSaver.loadUser() == null){
            customization = new CustomizationDB();
        } else {
            PetDB pet = Objects.requireNonNull(DataSaver.loadUser()).myPet;
            this.currHealth = pet.currHealth;
            this.name = pet.name;
            this.skin = pet.skin;
            this.customization = pet.getCustomization();
        }
    }

    /**
     * A Getter for name
     * @return name
     */
    public String getName(){return this.name;}

    /**
     * A Getter for skin
     * @return skin
     */
    public  String getSkin(){return this.skin; }

    /**
     * A Getter for Customization
     * @return Customization
     */
    public CustomizationDB getCustomization(){return this.customization;}

}
