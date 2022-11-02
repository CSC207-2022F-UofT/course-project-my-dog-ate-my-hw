package entities;

import entities.Item;

import java.util.ArrayList;

public class Customization {

    public boolean is_currently_equipped;
    public Item current_equipment;

    public Customization(){
        this.current_equipment = null;
        this.is_currently_equipped = false;
    }

    public Customization(Item item){
        this.current_equipment = item;
        this.is_currently_equipped = true;
    }

    public boolean isCurrentlyEquipped() {
        return is_currently_equipped;
    }

    public boolean dequip() {
        // maybe no conditional? just dequip without checking?
        if (this.is_currently_equipped) {
            this.current_equipment = null;
            this.is_currently_equipped = false;
            return true;
        }
        return false;
    }

    public boolean equip(Item item) {
        if (!this.is_currently_equipped && item.unlocked) {
            this.current_equipment = item;
            this.is_currently_equipped = true;
            return true;
        }
        return false;
    }
}
