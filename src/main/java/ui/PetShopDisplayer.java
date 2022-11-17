package ui;

import entities.Pet;

import javax.swing.*;

public class PetShopDisplayer {

    /**
     * Creates and runs a PetShopWindow that will look the same on all platforms.
     */
    Pet pet;
    public void createPetShop() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        PetShopWindow shop = new PetShopWindow();
        shop.setVisible(true);
        pet = shop.getPet();
    }

    /**
     * Main method for testing, to be removed
     */
    public static void main(String[] args) {
        PetShopDisplayer d = new PetShopDisplayer();
        d.createPetShop();
    }

}