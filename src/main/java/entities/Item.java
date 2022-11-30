package entities;

import javax.swing.*;

public class Item {

    // a String representing the Item name
    private String name;

    // a String representing the Item type (e.g., Hat)
    private String type;

    // an int representing the Item cost
    private int price;

    // a boolean representing whether the Item has been bought
    private boolean unlocked;

    // an ImageIcon representing the Item icon (clean architecture?)
    private ImageIcon icon;


    // ==CONSTRUCTORS==

    public Item() {
        this.price = 1;
        this.unlocked = false;
    }

    public Item(String type, String name, int price, boolean unlocked) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
    }

    public Item(String type, String name, int price, ImageIcon icon, boolean unlocked) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
        this.icon = icon;
    }


    // SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }


    // ==GETTERS==

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}