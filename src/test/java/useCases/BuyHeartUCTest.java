package useCases;

public class BuyHeartUCTest {

    /** Create a new pet and user
     * Set user points as 10, pet begins with 10 health
     * Remove 5 hearts
     * Then test BuyHeartUC.buyHeart() by buying 3 hearts
     * User should have 7 points (10 - 3 = 7)
     * Pet should have 8 hearts (5 + 3 = 8)
     */
    @Test
    public void BuyHeartTest() {
        Pet pet = new Pet("Name");
        User user = new User(10, pet);
        pet.ouch(5);
        BuyHeartUC.buyHeart(user, 3);
        Assertions.assertEquals(user.getPoints(), 7);
        Assertions.assertEquals(pet.getCurrHealth(), 8);
    }
}
