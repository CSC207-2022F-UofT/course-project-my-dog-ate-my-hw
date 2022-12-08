package database;

import databaseBoundaries.ItemDBBoundary;

import java.io.Serializable;

public class ItemDB implements Serializable, ItemDBBoundary {

    // a String representing the Item name
    public String name;

    // a String representing the Item type (e.g., Hat)
    public String type;

    // an int representing the Item cost
    public int price;

    // a boolean representing whether the Item has been bought
    public boolean unlocked;

    // an ImageIcon representing the Item icon (clean architecture?)
    public String icon;

    public ItemDB(String name, String type, int price, boolean unlocked, String icon){
        this.name = name;
        this.type = type;
        this.price = price;
        this.unlocked = unlocked;
        this.icon = icon;
    }

    public String getName(){return this.name; }
    public String  getType(){return this.type; }
    public int getPrice(){return this.price; }
    public boolean isUnlocked(){return this.unlocked; }
    public String getIcon(){return this.icon; }
}
