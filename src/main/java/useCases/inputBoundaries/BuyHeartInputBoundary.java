package useCases.inputBoundaries;

/**
 * The BuyHeartInputBoundary interace is the input boundary for the use case in which the user can use the points
 * they've gained from completing tasks to increase the health of their adopted pet.
 */
public interface BuyHeartInputBoundary {

    /**
     * Buys a singular heart for the singleton user, UserUC.
     */
    void buyHeart();

    /**
     * Call on the Pet refresher to refresh the Pet in the UI.
     */
    void refreshPet();
}
