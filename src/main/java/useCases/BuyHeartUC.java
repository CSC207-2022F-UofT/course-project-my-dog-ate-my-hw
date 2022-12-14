package useCases;

import entities.User;
import entities.Pet;

public class BuyHeartUC implements BuyHeartInputBoundary{

    private static final int costPerHeart = 1;
    private static final int costToRevive = 100;

    /**
     * Updates the User's balance and the corresponding Pet's health (1:1)
     * @param hearts the number of hearts to heal (cost)
     * @param user the User's name
     */
    public void buyHeart(User user, int hearts){
        int cost = calculateCost(hearts);
        Pet pet = user.getPet();
        if(pet != null) {
            if (user.getPoints() >= cost &&
                    pet.getCurrHealth() > 0 &&
                    pet.getCurrHealth() < Pet.getMaxHealth()) {
                user.losePoints(cost);
                pet.heal(hearts);
            } else if (pet.getCurrHealth() <= 0 && user.getPoints() >= costToRevive) {
                pet.fullyHeal();
            }
        }
    }

    private int calculateCost(int hearts){
        return hearts * costPerHeart;
    }

    public void buyHeart(int hearts){
        buyHeart(UserUC.u(), hearts);
    }

    public void buyHeart(){
        buyHeart(UserUC.u(), 1);
    }

    public void refreshPet(){
        new PetRefresher().refresh();
    }

}