package useCases;

import entities.User; // Need user points and user pet
import entities.Pet; // Need Pet.getMaxHealth() in case we change this value

public class BuyHeartUC {
    
    /**
    * Updates the User's balance and the corresponding Pet's health (1:1)
    * @param hearts the number of hearts to heal (cost)
    * @param user the User's name
    */
    public static void buyHeart(User user, int hearts){
    
        Pet pet = user.getPet();
        
        if(user.getPoints() > 0 &&
                pet.getCurrHealth() > 0 &&
                pet.getCurrHealth() < Pet.getMaxHealth()){
            user.LosePoints(hearts);
            pet.heal(hearts);
        }
    }
}
