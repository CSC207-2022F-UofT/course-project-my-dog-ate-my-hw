package entities;

import javax.swing.*;

public class Item {

    public String name;
    public String type;
    public int price;
    public boolean unlocked;
    public ImageIcon icon;

    // CONSTRUCTORS

    public Item() {
        this.price = 1;
        this.unlocked = false;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.unlocked = false;
    }

    public Item(String name, int price, boolean unlocked) {
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
    }

    public Item(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Item(String type, String name, int price, boolean unlocked) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
    }

    public Item(int price) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
        this.icon = icon;
    }


    // UNLOCK AND LOCK

    public void Unlock() {
        this.unlocked = true;
    }

    public void Lock() {
        this.unlocked = false;
    }


    // SETTERS

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

}

    // FIN