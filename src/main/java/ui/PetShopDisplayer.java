package ui;

import javax.swing.*;

public class PetShopDisplayer {

    /**
     * Creates and runs a PetShopWindow that will look the same on all platforms.
     */
    public void createPetShop(User user) {
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

        PetShopUIController controller = new PetShopUIController(user);
        PetShopWindow shop = new PetShopWindow(controller);
        shop.setVisible(true);
    }

    /**
     * Main method for testing, to be removed
     *
    public static void main(String[] args) {
        PetShopDisplayer d = new PetShopDisplayer();
        d.createPetShop();
    }
    */
}