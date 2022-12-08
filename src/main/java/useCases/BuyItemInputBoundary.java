package useCases;

import entities.User;

public interface BuyItemInputBoundary {
    /**
     * Main methods that purchase an item
     * @param user The user that buys the item
     * @param itemName Name of the item
     */
    static void buyItem(User user, String itemName){}

    static void buyItem(String itemName){}

    /**
     * Refresh method that refreshes the UI
     */
    void refreshItem();
}
