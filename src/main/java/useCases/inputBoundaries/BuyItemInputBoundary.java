package useCases.inputBoundaries;

import entities.User;

/**
 * The BuyItemInputBoundary interface is used for the use case in which the user can use the points they've gained from
 * completing tasks to buy items to accessorize their adopted pet with. This class takes input from the
 * BuyItemInputBoundary.
 */
public interface BuyItemInputBoundary {
    /**
     * Main methods that purchase an item
     * @param user The user that buys the item
     * @param itemName Name of the item
     */
    void buyItem(User user, String itemName);

    void buyItem(String itemName);

    /**
     * Refresh method that refreshes the UI
     */
    void refreshItem();
}
