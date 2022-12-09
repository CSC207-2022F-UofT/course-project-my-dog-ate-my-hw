package ui;

import controllers.PetShopUIController;

import javax.swing.*;

public class PetShopDisplayer implements PetShopDisplayerInterface{

    /**
     * Creates and runs a PetShopUI that will look the same on all platforms.
     */
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

        PetShopUIController controller = new PetShopUIController();
        PetShopUI shop = new PetShopUI(controller);
        shop.setVisible(true);
    }

}