package useCases.interactors;

import entities.User;
import entities.Pet;
import useCases.inputBoundaries.BuyHeartInputBoundary;
import useCases.refreshers.PetRefresher;

public class BuyHeartUC implements BuyHeartInputBoundary {

    private static final int COST_PET_HEART = 1;
    private static final int REVIVE_COST = 20;

    /**
    * Updates the User's balance and the corresponding Pet's health (1:1)
    * @param hearts the number of hearts to heal (cost)
    * @param user the User's name
    */
    public void buyHeart(User user, int hearts){
        if (user.getPet() != null) {
            Pet pet = user.getPet();
            int cost = cost(hearts);
            if (user.getPoints() >= cost &&
                    pet.getCurrHealth() > 0 &&
                    pet.getCurrHealth() < Pet.getMaxHealth()) {
                user.losePoints(cost);
                pet.heal(hearts);
            } if (user.getPoints() >= REVIVE_COST && pet.getCurrHealth() == 0) {
                user.losePoints(REVIVE_COST);
                pet.healToFull();
            }
        }
    }

    private int cost(int hearts) {
       return COST_PET_HEART * hearts;
    }

    public void buyHeart(){
        buyHeart(UserUC.u(), 1);
    }

    public void refreshPet(){
        new PetRefresher().refresh();
    }

}
