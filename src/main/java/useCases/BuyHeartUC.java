package useCases;

import entities.User; // Need user points and user pet
import entities.Pet; // Need Pet.getMaxHealth() in case we change this value

public class BuyHeartUC {

    // Check for points and pet health,
    // if pet health is max, do nothing
    // if user points are 0, do nothing
    // else buy hearts num of hearts
    // and lose hearts num of points

    // If pet health is 0
    // then prevent user from buying hearts
    // since we agreed that when pet health reaches 0
    // the user would have to do something different
    // from just buy hearts

    public static void buyHeart(User user, int hearts){
        Pet pet = user.getPet();
        if(user.getPoints() > 0 &&
                pet.getCurrHealth() > 0 &&
                pet.getCurrHealth() < Pet.getMaxHealth()){
            // hearts to points ratio is 1:1, should we add a multiplier? no, too convuluted, i think...
            // keep it simple stupid
            user.LosePoints(hearts);
            pet.heal(hearts);
        }
    }

}
